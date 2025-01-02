package com.example.demo.kakao_authentication.controller;

import com.example.demo.account.entity.Account;
import com.example.demo.account.service.AccountService;
import com.example.demo.kakao_authentication.controller.request_form.AccessTokenRequestForm;
import com.example.demo.kakao_authentication.service.KakaoAuthenticationService;
import com.example.demo.redis_cache.service.RedisCacheService;
import com.example.demo.account_profile.service.AccountProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao-authentication")
public class KakaoAuthenticationController {
    final private KakaoAuthenticationService kakaoAuthenticationService;
    final private AccountService accountService;
    final private AccountProfileService accountProfileService;
    final private RedisCacheService redisCacheService;

    @PostMapping("/get-login-link")
    public String requestGetLoginLink() {
        log.info("requestGetLoginLink() called");

        return kakaoAuthenticationService.getLoginLink();
    }

    @PostMapping("/get-access-token")
    @Transactional
    public String requestAccessToken(@RequestBody AccessTokenRequestForm accessTokenRequestForm) {
        String code = accessTokenRequestForm.getCode();

        log.info("requestGetLoginLink(): code {}", code);

        try {
            Map<String, Object> tokenResponse = kakaoAuthenticationService.requestAccessToken(code);
            String accessToken = (String) tokenResponse.get("access_token");

            Map<String, Object> userInfo = kakaoAuthenticationService.requestUserInfo(accessToken);
            String nickname = (String) ((Map) userInfo.get("properties")).get("nickname");
            String email = (String) ((Map) userInfo.get("kakao_account")).get("email");

            Account account = accountService.findAccountByEmail(email);
            if (account == null) {
                account = accountService.createAccount(email);
                accountProfileService.createAccountProfile(account, nickname);
            }

            return createUserTokenWithAccessToken(account, accessToken);

        } catch (Exception e) {
            return "error" + e.getMessage();
        }
    }

    private String createUserTokenWithAccessToken(Account account, String accessToken) {
        try {
            String userToken = UUID.randomUUID().toString();
            redisCacheService.setKeyAndValue(account.getId(), accessToken);
            redisCacheService.setKeyAndValue(userToken, account.getId());
            return userToken;
        } catch (Exception e) {
            throw new RuntimeException("Error storing token in Redis: " + e.getMessage());
        }
    }
}
