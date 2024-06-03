package com.sendemail.email.controller;


import com.sendemail.email.domain.EmailDTO;
import com.sendemail.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/send")
public class emailcontroller {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/Message")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO){

        System.out.println("mensaje recibido" + emailDTO);

        emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("estado", "Enviado");

        return ResponseEntity.ok(response);

    }


}
