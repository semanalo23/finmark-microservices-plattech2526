package org.example.finmark_userauth_micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reset")
public class ResetPageController {

    @GetMapping
    public String showResetPage() {
        return "resetpage"; // templates/reset.html
    }

    @PostMapping
    public String resetPassword(@RequestParam String username,
                                @RequestParam String newPassword) {
        if (!RegisterController.getUsers().containsKey(username)) {
            return "redirect:/reset?error";
        }
        RegisterController.getUsers().put(username, newPassword);
        return "redirect:/login?success";
    }
}
