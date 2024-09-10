package edu.pe.vallegrande.demo3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromedioDto {
    // Datos Entrada
    private int pp;
    private int ep;
    private int ef;

    // Datos Salida
    private int pf;
    private String condicion;

    public PromedioDto(int pp, int ep, int ef) {
        this.pp = pp;
        this.ep = ep;
        this.ef = ef;
    }
}
