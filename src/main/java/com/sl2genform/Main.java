package com.sl2genform;
import com.sl2genform.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        User user1 = new User(3,"Milene"  ,"Leandro", "milenegleandro@icloud.com");

        System.out.println("Hello Spring");
        SpringApplication.run(Main.class, args);
    }
}