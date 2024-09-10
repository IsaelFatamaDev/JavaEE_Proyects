package edu.pe.vallegrande.demo3.rest;

import edu.pe.vallegrande.demo3.dto.PromedioDto;
import edu.pe.vallegrande.demo3.service.PromedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promedio")
public class PromedioRest {
    @Autowired
    private PromedioService service;

    @GetMapping
    public PromedioDto procesar(int pp, int ep, int ef) {
        PromedioDto dto = new PromedioDto(pp, ep, ef);
        dto = service.procesar(dto);
        return dto;
    }
}
