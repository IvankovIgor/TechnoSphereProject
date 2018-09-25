package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Value("${user.default}")
    private String user;

    @RequestMapping("/")
    public String index() {
        return user + ", greetings from Spring Boot!";
    }
}
