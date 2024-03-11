package co.samtel.service.impl;

import co.samtel.controller.UsuarioController;
import co.samtel.dao.UsuarioDao;
import co.samtel.entity.Usuario;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.service.contract.IUsuarioService;
import co.samtel.utils.ApplicationException;
import co.samtel.utils.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.samtel.constant.Constant.ERROR_SERVICIO;

@ApplicationScoped
public class UsuarioServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    UsuarioDao usuarioDao;

    @Transactional
    public Object crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia crearUsuarioImpl");

        try {
            Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            // iusuarioService.persist(usuario);
            LOG.info("Persis usuario");
        }catch (ApplicationException e){
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        return null;
    }
}
