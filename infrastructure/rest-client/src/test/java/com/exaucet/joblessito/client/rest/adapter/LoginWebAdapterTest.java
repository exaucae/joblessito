package com.exaucet.joblessito.client.rest.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

public class LoginWebAdapterTest {
    @Test
    public void testLoginError() {
        LoginWebAdapter loginWebAdapter = new LoginWebAdapter();
        assertEquals("login", loginWebAdapter.loginError(new ConcurrentModel()));
    }
}

