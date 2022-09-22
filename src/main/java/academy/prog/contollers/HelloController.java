package academy.prog.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloboot")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
