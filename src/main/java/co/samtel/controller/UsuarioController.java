package co.samtel.controller;

import co.samtel.dao.UsuarioDao;
import co.samtel.entity.Usuario;
import co.samtel.gen.contract.V1UsuarioApi;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;
import co.samtel.service.impl.UsuarioServiceImpl;
import co.samtel.utils.ApplicationException;
import co.samtel.utils.UsuarioMapper;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import static co.samtel.constant.Constant.ERROR_SERVICIO;

public class UsuarioController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @Override
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio el proceso crearUsuario");
        return  usuarioServiceImpl.crearUsuario(usuarioTypeInput);
    }

    @Override
    public List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio el proceso editarUsuario");
        return usuarioServiceImpl.editarUsuario(idtblUser, usuarioTypeInput);
    }

    @Override
    public void eliminarUsuario(Integer idtblUser) {
        LOG.info("Inicio el proceso eliminarUsuario.");
        usuarioServiceImpl.eliminarUsuario(idtblUser);
    }

    @Override
    public List<UsuarioTypeResponse> listarTodosLosUsuario() {
        LOG.info("Inicio el proceso listarTodosLosUsuarios.");
        return usuarioServiceImpl.listarTodosLosUsuarios();
    }

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser) {
        LOG.info("Inicio el proceso de listarUsuario");
        return usuarioServiceImpl.listarUsuario(idtblUser);
    }

}
