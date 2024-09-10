package edu.pe.vallegrande.demo3.rest;

import edu.pe.vallegrande.demo3.service.TablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabla")
public class TablaRest {

    @Autowired
    private TablaService tablaService;

    @GetMapping
    public List<String> mostrarTabla(int numero) {
        return tablaService.generarTabla(numero);
    }
}
