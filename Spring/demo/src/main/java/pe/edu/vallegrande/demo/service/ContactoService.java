package pe.edu.vallegrande.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demo.repository.ContactoRepository;

import java.util.Map;

@Service
public class ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

//    @Autowired
//    public void ContactoRepository(ContactoRepository contactoRepository) {
//        this.contactoRepository = contactoRepository;
//    }

//    @Autowired
//    public ContactoService(ContactoRepository repository) {
//        this.contactoRepository = repository;
//    }
    public Map<String, String> obtenerContactos() {
        return contactoRepository.getContactos();
    }
}
