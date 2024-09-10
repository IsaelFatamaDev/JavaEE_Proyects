package pe.edu.vallegrande.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {
    @GetMapping("/saludo")
    public String hello() {
        return "Hola todos";
    }
}
