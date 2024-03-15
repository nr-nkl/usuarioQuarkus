package co.samtel.utils;

import co.samtel.entity.Usuario;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioMapper {
    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioTypeInput){
        return  new ModelMapper().map(usuarioTypeInput, Usuario.class);
    }

    public UsuarioTypeInput clienteEntityToType(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioTypeInput.class);
    }
    public UsuarioTypeResponse usuarioEntityToTypeResponse(Usuario usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }

    public UsuarioTypeResponse usuarioInputToTypeResponse(UsuarioTypeInput usuarioTypeInput) {
        return new ModelMapper().map(usuarioTypeInput, UsuarioTypeResponse.class);
    }

    public List<Usuario> usuarioTypeListToEntity(List<UsuarioTypeInput> usuarioTypeList){
        return  usuarioTypeList.stream().map(usuario -> usuarioTypeToEntity(usuario))
                .collect(Collectors.toList());
    }




}