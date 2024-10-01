package edu.pe.vallegrande.importaciones.prueba;

import edu.pe.vallegrande.importaciones.dto.OfficeDto;
import edu.pe.vallegrande.importaciones.service.OfficeService;

import java.util.List;

public class OfficeTest {
    public static void main(String[] args) {
        OfficeService service = new OfficeService();
        List<OfficeDto> offices = service.getOffice();
        for (OfficeDto office : offices) {
            System.out.println(office);
        }
    }
}
