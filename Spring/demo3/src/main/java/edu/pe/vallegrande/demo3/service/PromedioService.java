package edu.pe.vallegrande.demo3.service;

import edu.pe.vallegrande.demo3.dto.PromedioDto;
import org.springframework.stereotype.Service;

@Service
public class PromedioService {
    public PromedioDto procesar(PromedioDto dto) {
        int promedioFinal = (dto.getPp() + dto.getEp() + dto.getEf()) / 3;
        dto.setPf(promedioFinal);
        if (promedioFinal >= 13) {
            dto.setCondicion("Aprobado");
        } else {
            dto.setCondicion("Desaprobado");
        }
        return dto;

    }
}
