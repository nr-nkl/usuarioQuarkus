package co.samtel.utils;

import co.samtel.entity.Usuario;
import co.samtel.gen.type.UsuarioTypeInput;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class UsuarioMapper {
    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioType) {
        return new ModelMapper().map(usuarioType, Usuario.class);
    }
}