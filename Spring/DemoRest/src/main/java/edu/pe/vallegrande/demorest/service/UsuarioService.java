package edu.pe.vallegrande.demorest.service;

import edu.pe.vallegrande.demorest.dto.UsuarioDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private static final List<UsuarioDto> listado = new ArrayList<>();
    private static int contador = 0;

    static {
        listado.add(new UsuarioDto(1, "Isael", 50));
        listado.add(new UsuarioDto(2, "Juan", 40));
        listado.add(new UsuarioDto(3, "Pedro", 30));
        listado.add(new UsuarioDto(4, "Maria", 20));
        listado.add(new UsuarioDto(5, "Ricardo", 45));
        listado.add(new UsuarioDto(6, "Graciela", 36));
        listado.add(new UsuarioDto(7, "Manuel", 41));
        contador = listado.size();

    }

    public List<UsuarioDto> listar() {
//        if (contador < 10) {
//            throw new RuntimeException("Error en la consulta");
//        }
        return listado;

    }

    public List<UsuarioDto> obtenerLista(String nombre) {
        List<UsuarioDto> listaAux = new ArrayList<>();
        for (UsuarioDto bean : listado) {
            if (bean.getNombre().toUpperCase().contains(nombre.toUpperCase())) {
                listaAux.add(bean);
            }
        }
        return listaAux;
    }

    public UsuarioDto buscarPorId(int id) {
        for (UsuarioDto usuarioDto : listado) {
            if (usuarioDto.getId() == id) {
                return usuarioDto;
            }
        }
        throw new RuntimeException("No se encontro el usuario");

    }

    public UsuarioDto crear(UsuarioDto usuarioDto) {
        for (UsuarioDto usuario : listado) {
            if (usuario.getNombre().equalsIgnoreCase(usuarioDto.getNombre())) {
                throw new RuntimeException("El nombre ya existe en el listado");
            }
        }
        usuarioDto.setId(++contador);
        listado.add(usuarioDto);
        return usuarioDto;
    }


    public UsuarioDto reemplazar(int id, UsuarioDto usuarioDto) {
        for (UsuarioDto bean : listado) {
            if (bean.getId() == usuarioDto.getId()) {
                bean.setId(usuarioDto.getId());
                bean.setNombre(usuarioDto.getNombre());
                bean.setEdad(usuarioDto.getEdad());
                return bean;
            }
        }
        throw new RuntimeException("No se encontro el usuario");
    }

    public UsuarioDto actualizar(int id, UsuarioDto usuarioDto) {
        for (UsuarioDto bean : listado) {
            if (bean.getId() == id) {

                if (usuarioDto.getNombre() != null) {
                    bean.setNombre(usuarioDto.getNombre());
                }
                if (usuarioDto.getEdad() != 0) {
                    bean.setEdad(usuarioDto.getEdad());
                }
                return bean;
            }
        }
        throw new RuntimeException("No se encontró el usuario");
    }

    public void eliminar(int id) {
        for (UsuarioDto bean : listado) {
            if (bean.getId() == id) {
                listado.remove(bean);
                return;
            }
        }
        throw new RuntimeException("No se encontro el usuario");
    }
}
