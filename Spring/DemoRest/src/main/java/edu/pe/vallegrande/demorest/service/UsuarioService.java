package edu.pe.vallegrande.demorest.service;

import edu.pe.vallegrande.demorest.dto.UsuarioDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private static final List<UsuarioDto> listado = new ArrayList<>();
    private static final int contador;

    static {
        listado.add(new UsuarioDto(1, "Isael", 50));
        listado.add(new UsuarioDto(2, "Juan", 40));
        listado.add(new UsuarioDto(3, "Pedro", 30));
        listado.add(new UsuarioDto(4, "Maria", 20));
        contador = listado.size();

    }

    public List<UsuarioDto> listar() {
//        if (contador < 10) {
//            throw new RuntimeException("Error en la consulta");
//        }
        return listado;

    }

    public String buscarPorId(int id) {
        for (UsuarioDto usuarioDto : listado) {
            if (usuarioDto.getId() == id) {
                return usuarioDto.toString();
            }
        }
        return "No se encontro el usuario";
    }
}
