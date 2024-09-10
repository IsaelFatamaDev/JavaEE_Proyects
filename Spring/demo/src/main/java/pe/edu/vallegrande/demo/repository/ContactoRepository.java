package pe.edu.vallegrande.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ContactoRepository {
    public Map<String, String> getContactos(){
        Map<String, String> lista = new LinkedHashMap<>();
        lista.put("C01", "Juan Perez");
        lista.put("C02", "Maria Lopez");
        lista.put("C03", "Carlos Ramirez");
        lista.put("C04", "Luisa Torres");
        lista.put("C05", "Pedro Rojas");
        lista.put("C06", "Rosa Mendoza");
        return lista;
    }
}
