package edu.pe.vallegrande.demo3.rest;

import edu.pe.vallegrande.demo3.dto.CuotaDto;
import edu.pe.vallegrande.demo3.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prestamo")
public class PrestamoRest {

    @Autowired
    private PrestamoService service;

    @GetMapping
    public List<CuotaDto> procesar(int meses, double capital, double tasaAnual) {

        if (meses <= 0 || capital <= 0 || tasaAnual < 0) {
            throw new IllegalArgumentException("Ingresa valores validos");
        }

        return service.procesar(capital, meses, tasaAnual);

    }
}