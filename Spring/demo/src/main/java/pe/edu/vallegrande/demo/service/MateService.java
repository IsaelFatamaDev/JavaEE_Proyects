package pe.edu.vallegrande.demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class MateService {
    @PostConstruct
    public void turnOn() {
        System.out.println("Objeto MateService Creado");
    }

    public int sumar(int n1, int n2) {
        return (n1 + n2);
    }
}

