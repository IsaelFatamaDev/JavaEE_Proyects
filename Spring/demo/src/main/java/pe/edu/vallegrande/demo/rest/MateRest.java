package pe.edu.vallegrande.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.demo.service.MateService;

@RestController
public class MateRest {
    @Autowired
    private MateService mateService;

    @GetMapping("/sumar")
    public String sumar(@RequestParam int n1, @RequestParam int n2) {
        int resultado = mateService.sumar(n1, n2);
        return "La suma es: " + resultado;
    }
}
