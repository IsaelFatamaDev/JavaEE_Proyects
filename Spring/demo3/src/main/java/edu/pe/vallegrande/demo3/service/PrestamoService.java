package edu.pe.vallegrande.demo3.service;

import edu.pe.vallegrande.demo3.dto.CuotaDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {

    public List<CuotaDto> procesar(double capital, int meses, double tasaAnual) {
        List<CuotaDto> lista = new ArrayList<>();
        double tasaMensual = (tasaAnual / 100) / 12;
        double cuotaMensual = Math.round((capital * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -meses)) * 100.0) / 100.0;
        double saldoRestante = capital;

        for (int mes = 1; mes <= meses; mes++) {
            double intereses = Math.round((saldoRestante * tasaMensual) * 100.0) / 100.0;
            double amortizacion = Math.round((cuotaMensual - intereses) * 100.0) / 100.0;
            saldoRestante = Math.round((saldoRestante - amortizacion) * 100.0) / 100.0;

            if (saldoRestante < 0) {
                saldoRestante = 0;
            }

            CuotaDto cuotaDto = new CuotaDto(
                    mes,
                    cuotaMensual,
                    intereses,
                    amortizacion,
                    saldoRestante
            );
            lista.add(cuotaDto);
        }

        return lista;
    }
}
