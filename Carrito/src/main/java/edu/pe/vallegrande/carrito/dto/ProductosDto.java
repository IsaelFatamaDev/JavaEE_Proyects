package edu.pe.vallegrande.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDto {
private int id_producto;
private String nombre;
private double precio;
private int stock;
}
