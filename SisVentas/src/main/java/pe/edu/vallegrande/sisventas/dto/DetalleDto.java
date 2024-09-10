package pe.edu.vallegrande.sisventas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DetalleDto {
    private int idprod;
    private String nombre;
    private double precio;
    private int cantidad;
    private double subtotal;

}
