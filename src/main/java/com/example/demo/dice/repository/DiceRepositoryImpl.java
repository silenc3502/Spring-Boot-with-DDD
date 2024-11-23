package com.example.demo.dice.repository;

import org.springframework.stereotype.Repository;

// Spring Beans <<<
// Spring Core가 IoC Container를 관리하는데
// @Controller, @Service, @Repository 붙은 애들이 결국 Beans
// 결론적으로 @Repository라는 것을 알려줘서
// 이것이 싱글톤이니까 알아서 RequiredArgsConstructor가 인식하도록 만드세요.
@Repository
public class DiceRepositoryImpl implements DiceRepository {
    @Override
    public Integer rollDice() {
        return null;
    }
}
