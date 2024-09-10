package edu.pe.vallegrande.demo3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuotaDto {
    private int mes;
    private double cuota;
    private double intereses;
    private double amortizacion;
    private double saldo;
}
