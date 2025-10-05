package com.sl2genform;
import com.sl2genform.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Application... ");
        SpringApplication.run(Main.class, args);
    }
}