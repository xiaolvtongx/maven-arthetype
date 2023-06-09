package com.example.bankmap;

import com.example.bankmap.config.WebSocketConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author Administrator
 */
@SpringBootApplication
public class BankMapApplication {

    public static void main(String[] args) {

        SpringApplication.run(BankMapApplication.class, args);
    }



}