package com.cal.springemail;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AllArgsConstructor
public class SpringEmailApplication {

    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        senderService.sendEmail("gönderim yapılacak mail adresi", "This is Body to Email", "This is subject");
    }
}
