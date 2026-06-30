package org.example.finmark_userauth_micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutPageController {

    @GetMapping("/auth/logout-success")
    public String logoutSuccess() {
        return "logout_page";
    }
}
