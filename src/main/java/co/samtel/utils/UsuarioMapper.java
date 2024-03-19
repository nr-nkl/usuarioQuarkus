package co.samtel.utils;

import co.samtel.entity.Usuario;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioMapper {
    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioTypeInput){
        return  new ModelMapper().map(usuarioTypeInput, Usuario.class);
    }
    public UsuarioTypeResponse usuarioEntityToTypeResponse(Usuario usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }

    public List<UsuarioTypeResponse> usuarioTypeListEntityToTypeResponse(List<Usuario> listUsuarios ){
        List<UsuarioTypeResponse> usuariosTypeResponseList = new ArrayList<>();
        for (Usuario usuario: listUsuarios){
            UsuarioTypeResponse response = new ModelMapper().map(usuario, UsuarioTypeResponse.class);
            usuariosTypeResponseList.add(response);
        }
        return usuariosTypeResponseList;
    }




}