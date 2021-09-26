package com.exaucet.joblessito.client.rest.adapter;

import com.exaucet.joblessito.client.rest.controller.ILoginRestController;
import com.exaucet.joblessito.common.annotation.WebAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;

@WebAdapter
public class LoginWebAdapter implements ILoginRestController {


    @Override
    public String index() {
        return "You made it!";
    }

    @Override
    public String login() {
        return "login";
    }

    @Override
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @Override
    public String securedPage(Model model,
                              @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                              @AuthenticationPrincipal OAuth2User oauth2User) {
        model.addAttribute("userName", oauth2User.getName());
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", oauth2User.getAttributes());
        return "securedPage";
    }

}
