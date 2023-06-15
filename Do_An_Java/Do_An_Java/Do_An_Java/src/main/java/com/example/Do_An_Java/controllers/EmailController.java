package com.example.Do_An_Java.controllers;

import com.example.Do_An_Java.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Do_An_Java.entities.Email;


@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/emailForm")
    public String showEmailForm(Model model) {
        model.addAttribute("email", new Email());
        return "emailForm";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute("email") Email email) {
        emailService.sendEmail(email.getRecipient(), email.getSubject(), email.getContent());
        return "redirect:/emailSent";
    }

    @GetMapping("/emailSent")
    public String showEmailSentPage() {
        return "emailSent";
    }
}