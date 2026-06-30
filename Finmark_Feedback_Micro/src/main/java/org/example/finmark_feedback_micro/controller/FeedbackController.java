package org.example.finmark_feedback_micro.controller;

import org.example.finmark_feedback_micro.model.Feedback;
import org.example.finmark_feedback_micro.repo.FeedbackRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FeedbackController {

    private final FeedbackRepo feedbackRepository;

    public FeedbackController(FeedbackRepo feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @GetMapping("/feedback")
    public String feedbackForm() {
        return "feedback";
    }

    @PostMapping("submit-feedback")
    public String submitFeedback (@ModelAttribute Feedback feedback, RedirectAttributes redirectAttributes) {

        //repo section --- saving on log
        feedbackRepository.save(feedback); // persist to DB

        //flag for success alert
        redirectAttributes.addAttribute("submitted", true);

        //redirect
        return "redirect:http://localhost:8082/dashboard";
    }

}
