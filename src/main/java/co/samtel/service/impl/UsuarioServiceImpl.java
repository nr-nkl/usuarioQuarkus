package co.samtel.service.impl;

import co.samtel.controller.UsuarioController;
import co.samtel.dao.UsuarioDao;
import co.samtel.entity.Usuario;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;
import co.samtel.utils.ApplicationException;
import co.samtel.utils.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import static co.samtel.constant.Constant.ERROR_SERVICIO;

@ApplicationScoped
public class UsuarioServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    UsuarioDao usuarioDao;

    @Transactional
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia crearUsuarioImpl");
        try {
            Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            UsuarioTypeResponse usuarioTypeResponses = usuarioMapper.usuarioEntityToTypeResponse(usuario);
            LOG.info("Persis usuario");
            return  Collections.singletonList(usuarioTypeResponses);
        }catch (ApplicationException e){
            LOG.error("Error al crear usuario");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser){
        LOG.info("Inicia listarUsuarioImpl");

        try {
            Usuario usuario = usuarioDao.findById(idtblUser.longValue());
            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToTypeResponse(usuario);
            LOG.info("Finaliza listar usuario por id");
            return  Collections.singletonList(response);
        }catch (ApplicationException e){
            LOG.error("Se presento un error al listar usuario por id"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }
}
