package co.samtel.controller;

import co.samtel.gen.contract.V1UsuarioApi;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;
import co.samtel.service.impl.UsuarioServiceImpl;
import co.samtel.utils.ApplicationException;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static co.samtel.constant.Constant.ERROR_SERVICIO;

public class UsuarioController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @Override
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia crearUsuario");

        try {
            Object usuarioType = usuarioServiceImpl.crearUsuario(usuarioTypeInput);
            LOG.info("Termina crearUsuarioController");
            return (List<UsuarioTypeResponse>) usuarioType;
        }catch (ApplicationException e){
            LOG.error("Se identifica error en el servicio."+e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser) {
        return null;
    }

}
