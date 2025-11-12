package com.james.controller;

import com.james.Module.ContactMessage;
import com.james.repository.EmailRepository;
import com.james.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class EmailController {
    private final EmailRepository repo;
    public EmailService service;
    @Autowired
    public EmailController(EmailService service, EmailRepository repo) {
        this.service = service;
        this.repo = repo;
    }
    @PostMapping
    public  String submitMessage(@RequestBody ContactMessage message){
        repo.save(message);
        service.sendEmail(
                "tomkim590@gmail.com",
                "how  are you doing ",
                "From: " +message.getName() +
                "\nemail: " + message.getEmail() +
                "\n\nMassage: \n" + message.getMessage()
        );
        return "Message sent successfully";
    }


}
