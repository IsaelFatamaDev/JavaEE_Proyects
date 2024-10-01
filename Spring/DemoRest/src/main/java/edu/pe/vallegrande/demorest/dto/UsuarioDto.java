package edu.pe.vallegrande.demorest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private int id;
    private String nombre;
    private int edad;
}
