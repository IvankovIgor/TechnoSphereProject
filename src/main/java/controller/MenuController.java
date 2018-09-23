package controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Igor Ivankov
 */
@Api
@RestController
public class MenuController {


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
