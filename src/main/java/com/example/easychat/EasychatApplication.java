package com.example.easychat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
@CrossOrigin
public class EasychatApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasychatApplication.class, args);
    }

}
