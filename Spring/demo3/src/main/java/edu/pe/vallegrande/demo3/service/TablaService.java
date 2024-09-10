package edu.pe.vallegrande.demo3.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TablaService {

    public List<String> generarTabla(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número debe ser mayor a cero.");
        }

        List<String> tabla = new ArrayList<>();
        for (int i = 0; i <= 12; i++) {
            String entrada = String.format("%d x %d = %d", numero, i, numero * i);
            tabla.add(entrada);
        }

        return tabla;
    }
}
