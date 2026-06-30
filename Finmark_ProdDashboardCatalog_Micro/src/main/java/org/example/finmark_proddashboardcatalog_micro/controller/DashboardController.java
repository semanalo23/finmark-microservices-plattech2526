package org.example.finmark_proddashboardcatalog_micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public String dashboard() {
        return "dashboard"; // dashboard.html
    }

    @GetMapping("/marketing-services")
    public String marketingServices() {
        return "marketing-services";
    }

    @GetMapping("/financial-services")
    public String financialServices() {
        return "financial-services";
    }

    @GetMapping("/bi-services")
    public String biServices() {
        return "bi-services";
    }

    @GetMapping("/consulting-services")
    public String consultingServices() {
        return "consulting-services"; // taxedge.html
    }
}
