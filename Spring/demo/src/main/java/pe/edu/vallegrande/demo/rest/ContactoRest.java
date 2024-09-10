package pe.edu.vallegrande.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.demo.service.ContactoService;

import java.util.Map;

@RestController
@RequestMapping("/contactos")
public class ContactoRest {
    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public Map<String, String> obtenerContactos() {
        return contactoService.obtenerContactos();
    }
}
