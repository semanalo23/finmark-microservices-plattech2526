package org.example.finmark_userauth_micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/register")
public class RegisterController {

    //simulated DB
    private static final Map<String, String> users = new ConcurrentHashMap<>();

    static {
        users.put("admin", "admin123");
        users.put("testuser", "password123");
    }

    @GetMapping
    public String showRegisterPage() {
        return "registerpage"; // templates/registerpage.html
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        if (users.containsKey(username)) {
            return "redirect:/login?error";
        }
        users.put(username, password);
        return "redirect:/login?success";
    }

    public static Map<String, String> getUsers() {
        return users;
    }
}
