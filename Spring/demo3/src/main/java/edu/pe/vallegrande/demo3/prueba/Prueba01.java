package edu.pe.vallegrande.demo3.prueba;

import edu.pe.vallegrande.demo3.dto.CuotaDto;
import edu.pe.vallegrande.demo3.service.PrestamoService;

import java.util.List;

public class Prueba01 {

    public static void main(String[] args) {
        // Datos
        int meses = 12;
        double capital = 10000;
        double interes = 10;
        // Proceso
        PrestamoService service = new PrestamoService();
        List<CuotaDto> lista = service.procesar(capital, meses, interes);
        // Reporte
        for (CuotaDto dto : lista) {
            System.out.println(dto.toString());
        }
    }
}