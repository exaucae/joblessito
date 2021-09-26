package com.exaucet.joblessito.client.rest.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping
@Profile("dev")
public interface ILoginRestController {


    @GetMapping()
    @ResponseBody
    String index();

    @GetMapping("login.html")
    String login();

    @GetMapping("login-error.html")
    String loginError(Model model);

    @RequestMapping("/securedPage")
    String securedPage(Model model,
                       @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                       @AuthenticationPrincipal OAuth2User oauth2User);
}
