package co.samtel.service.contract;

import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;

import java.util.List;

public interface IUsuarioService {
    UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> listarUsuario(Integer idtblUser);
    List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput);
    void eliminarUsuario(Integer idtblUser);
    List<UsuarioTypeResponse> listarTodosLosUsuarios();
}
