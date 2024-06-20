package ma.imadfaouzi.build_sprgbt_and_push_to_nexus.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/description")
    public String description() {
        return "This is a simple Spring Boot application.";
    }
}