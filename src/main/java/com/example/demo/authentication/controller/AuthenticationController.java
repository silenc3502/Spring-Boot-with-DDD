package com.example.demo.authentication.controller;

import com.example.demo.redis_cache.service.RedisCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {
    final private RedisCacheService redisCacheService;

    @PostMapping("/logout")
    public Map<String, String> requestLogout() {
        log.info("Logout request received");
        return Map.of("message", "로그아웃 성공");
    }

    @PostMapping("/validation")
    public Map<String, Object> requestUserTokenValidation(@RequestBody Map<String, String> postRequest) {
        log.info("Token validation request received");

        String userToken = postRequest.get("userToken");
        if (userToken == null || userToken.isEmpty()) {
            log.warn("User token is missing");
            return Map.of(
                    "valid", false,
                    "error", "userToken이 필요합니다"
            );
        }

        try {
            Long accountId = redisCacheService.getValueByKey(userToken);
            if (accountId == null) {
                log.info("Invalid user token");
                return Map.of("valid", false);
            }

            log.info("Valid user token for accountId: {}", accountId);
            return Map.of("valid", true);

        } catch (Exception e) {
            log.error("Internal error during token validation", e);
            return Map.of(
                    "valid", false,
                    "error", "코드 내부 에러"
            );
        }
    }
}
