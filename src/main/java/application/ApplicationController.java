package application;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ApplicationController {

    @RequestMapping("/")
    public String index() {
        return "Get Application!";
    }

}