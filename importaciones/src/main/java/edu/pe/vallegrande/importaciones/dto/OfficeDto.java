package edu.pe.vallegrande.importaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDto {
    private int office_id;
    private String office_name;
    private String address;
    private String city;
    private String phone;
}
