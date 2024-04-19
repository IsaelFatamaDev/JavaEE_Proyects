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
    public ContactoDTO create(ContactoDTO bean){
        bean.setId(++DB.contador);
        DB.contactos.add(bean);
        return bean;
    }

    public ContactoDTO update(ContactoDTO bean) {
        for (int i = 0; i < DB.contactos.size(); i++) {
            if (DB.contactos.get(i).getId() == bean.getId()) {
                DB.contactos.set(i, bean);
                return bean;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        for (ContactoDTO contacto : DB.contactos) {
            if (contacto.getId() == id) {
                DB.contactos.remove(contacto);
                return true;
            }
        }
        return false;
    }
}
