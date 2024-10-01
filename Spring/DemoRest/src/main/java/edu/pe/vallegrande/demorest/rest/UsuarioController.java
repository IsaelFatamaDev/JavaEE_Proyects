package edu.pe.vallegrande.demorest.rest;

import edu.pe.vallegrande.demorest.dto.UsuarioDto;
import edu.pe.vallegrande.demorest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/saludo", method = RequestMethod.GET)
    public String saludo() {
        return "Hola a Todos";
    }

    @GetMapping("/saludo2")
    public String saludo2() {
        return "Hola a Todos 2";
    }

    @GetMapping
    public List<String> listado() {
        List<String> listado = new ArrayList<>();
        listado.add("Isael");
        listado.add("Juan");
        listado.add("Pedro");
        listado.add("Maria");
        return listado;
    }

    @GetMapping("/listado")
    ResponseEntity<List<UsuarioDto>> listar() {

        try {
            return ResponseEntity.status(200)
                    .header("Consulta", "Datos traidos con exito")
                    .body(service.listar());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id);
    }
}
