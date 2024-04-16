package pe.edu.vallegrande.crudweb.service;

import pe.edu.vallegrande.crudweb.dto.ContactoDTO;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {
    public List<ContactoDTO> getAll() {
        //return DB.contactos;
        //Variables
        List<ContactoDTO> lista = new ArrayList<>();
        //Proceso
        for (ContactoDTO bean : DB.contactos) {
            if (bean.getEstado() == 1) {
                lista.add(bean);
            }
        }
        //Reporte
        return lista;
    }

    public ContactoDTO getById(int id) {
        //return DB.contactos.get(1);
        ContactoDTO rpta;
        rpta = null;
        for (ContactoDTO bean : DB.contactos) {
            if (bean.getId() == id && bean.getEstado() == 1) {
                rpta = bean;
            }
        }
        return rpta;
    }
}
