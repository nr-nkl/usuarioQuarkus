package co.samtel.service.contract;

import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;

import java.util.List;

public interface IUsuarioService {
    UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> editarUsuarioId(Integer idtblUser, UsuarioTypeInput usuarioTypeInput);
    void eliminarUsuarioId(Integer idtblUser);
    List<UsuarioTypeResponse> buscarUsuarioId(Integer idtblUser);
    List<UsuarioTypeResponse> listarTodosLosUsuarios();
}
