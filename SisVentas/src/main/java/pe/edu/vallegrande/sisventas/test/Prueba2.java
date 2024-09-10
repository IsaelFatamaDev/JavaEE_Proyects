package pe.edu.vallegrande.sisventas.test;

import pe.edu.vallegrande.sisventas.dto.VentaDto;
import pe.edu.vallegrande.sisventas.service.VentaService;

public class Prueba2 {
    public static void main(String[] args) {
        try {
            // Dato
            VentaDto ventaDto = new VentaDto(0, 1003, "Isael", null, 4000);
            System.out.println("Datos de la venta: " + ventaDto);
            // Proceso
            VentaService ventaService = new VentaService();
            ventaService.registrarVenta(ventaDto, null);
            System.out.println("Venta registrada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al registrar la venta: " + e.getMessage());
        }
    }
}
