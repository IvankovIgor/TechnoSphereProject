package controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Igor Ivankov
 */
@Api
@RestController
public class MenuController {

    @Value("${user.default}")
    private String user;

    @RequestMapping("/")
    public String index() {
        return user + ", greetings from Spring Boot!";
    }
}
