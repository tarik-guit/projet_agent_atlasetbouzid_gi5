package com.agent.ag.envoieemail;

import com.agent.ag.envoieemail.MyConstants;
import com.agent.ag.requestresponse.MessageResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@CrossOrigin()
public class Sendemail {

    @Autowired
    public JavaMailSender emailSender;




    @PostMapping("/sendSimpleEmail")
    public MessageResponse sendSimpleEmail(@RequestBody MyConstants u) {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(u.getFRIEND_EMAIL());
        message.setSubject(u.getSUBJECT_EMAIL());
        message.setText(u.getTEXT_EMAIL());

        // Send Message!
        this.emailSender.send(message);

        return new MessageResponse("Email Sent!");
    }

}