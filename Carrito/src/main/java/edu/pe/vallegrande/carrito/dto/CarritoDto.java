package edu.pe.vallegrande.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDto {
    private int id_carrito;
    private int cantidad;
    private Date fechaAgregado;
    private ProductosDto id_producto;

}
