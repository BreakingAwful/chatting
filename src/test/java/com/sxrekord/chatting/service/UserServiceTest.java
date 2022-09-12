package com.sxrekord.chatting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Rekord
 * @date 2022/9/12 13:21
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void login() {
        System.out.println(userService.loginUser("test1", "test2", null));
    }

    @Test
    public void register() {
        System.out.println(userService.registerUser("test4", "test4"));
    }
}
