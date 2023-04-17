package com.ms.email.controllers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.entities.Email;
import com.ms.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto,email);
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
    @GetMapping("/get-emails")
    public List<Email> getEmails(){
        return emailService.getEmails();

    }



}
