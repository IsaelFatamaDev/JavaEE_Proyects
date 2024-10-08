package edu.pe.vallegrande.demorest.rest;

import edu.pe.vallegrande.demorest.dto.UsuarioDto;
import edu.pe.vallegrande.demorest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRest {
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

    @GetMapping("/listado")
    public List<String> listado() {
        List<String> listado = new ArrayList<>();
        listado.add("Isael");
        listado.add("Juan");
        listado.add("Pedro");
        listado.add("Maria");
        return listado;
    }

    @GetMapping
    ResponseEntity<List<UsuarioDto>> listar() {
        try {
            return ResponseEntity.status(200)
                    .header("Consulta", "Datos traidos con exito")
                    .body(service.listar());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios(@PathVariable String nombre) {
        try {
            List<UsuarioDto> lista = service.obtenerLista(nombre.trim());
            if (lista.isEmpty()) {
                throw new RuntimeException("No se encontrol registros.");
            }
            return new ResponseEntity<List<UsuarioDto>>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.status(200)
                    .header("Consulta por ID", "Datos traidos con exito")
                    .body(service.buscarPorId(id));
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Consulta por ID", "Datos de error");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .headers(headers)
                    .build();
        }
    }

    @PostMapping("/nuevo")
    ResponseEntity<UsuarioDto> crear(@RequestBody UsuarioDto usuarioDto) {
        try {
            return ResponseEntity.status(201)
                    .header("Creacion", "Usuario creado con exito")
                    .body(service.crear(usuarioDto));
        } catch (RuntimeException e) {
            if (e.getMessage().equals("El nombre ya existe en el listado")) {
                return ResponseEntity.status(409).header("Error", e.getMessage()).build();
            }
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<UsuarioDto> reemplazar(@PathVariable int id, @RequestBody UsuarioDto usuarioDto) {
        try {
            usuarioDto.setId(id);
            return ResponseEntity.status(200)
                    .header("Reemplazo", "Usuario actualizado con exito")
                    .body(
                            service.reemplazar(id, usuarioDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PatchMapping("/{id}")
    ResponseEntity<UsuarioDto> actualizar(@PathVariable int id, @RequestBody UsuarioDto usuarioDto) {
        try {
            UsuarioDto actualizado = service.actualizar(id, usuarioDto);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Actualizacion", "Usuario actualizado con éxito")
                    .body(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).header("Error", e.getMessage()).build();
        }
    }


    @DeleteMapping("/{id}")
    ResponseEntity<String> eliminar(@PathVariable int id) {
        try {
            service.eliminar(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Resultado", "Usuario eliminado con éxito");
            return ResponseEntity.status(204)
                    .headers(headers)
                    .body("El usuario con ID " + id + " ha sido eliminado.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al eliminar el usuario: " + e.getMessage());
        }
    }

}
