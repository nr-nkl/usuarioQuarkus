package co.samtel.service.impl;

import co.samtel.dao.UsuarioDao;
import co.samtel.entity.Usuario;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;
import co.samtel.service.contract.IUsuarioService;
import co.samtel.utils.ApplicationException;
import co.samtel.utils.UsuarioMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import static co.samtel.constant.Constant.ERROR_SERVICIO;

@ApplicationScoped
public class UsuarioServiceImpl implements IUsuarioService {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    UsuarioDao usuarioDao;

    @Transactional
    public UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia crearUsuario Impl");
        try {
            Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            UsuarioTypeResponse usuarioTypeResponses = usuarioMapper.usuarioEntityToTypeResponse(usuario);
            LOG.info("Finaliza crearUsuario Impl");
            return  usuarioTypeResponses;
        }catch (ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    @Transactional // Sin esto no funciona .-.
    public List<UsuarioTypeResponse> editarUsuarioId(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia editarUsuario Impl.");
        try {
            Usuario usuario = usuarioDao.findById(idtblUser.longValue());
            Usuario usuarioCamb = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuario.setName(usuarioCamb.getName());
            usuario.setLastname(usuarioCamb.getLastname());
            usuario.setCreateat(usuarioCamb.getCreateat());
            UsuarioTypeResponse usuarioTypeResponse = usuarioMapper.usuarioEntityToTypeResponse(usuarioCamb);
            LOG.info("Finaliza editarUsuario Impl.");
            return Collections.singletonList(usuarioTypeResponse);
        }catch (ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    @Transactional
    public void eliminarUsuarioId(Integer idtblUser) {
        LOG.info("Inicia eliminarUsuario Impl.");
        try{
            usuarioDao.deleteById(idtblUser.longValue());
            LOG.info("Termina eliminarUsuario Impl.");
        }catch (ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    public List<UsuarioTypeResponse> buscarUsuarioId(Integer idtblUser){
        LOG.info("Inicia listarUsuario Impl");
        try {
            Usuario usuario = usuarioDao.findById(idtblUser.longValue());
            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToTypeResponse(usuario);
            LOG.info("Finaliza listarUsuario Impl");
            return  Collections.singletonList(response);
        }catch (ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }

    public List<UsuarioTypeResponse> listarTodosLosUsuarios() {
        LOG.info("Inicia listarTodosLosUsuarios Impl.");
        try{
            PanacheQuery query = usuarioDao.findAll();
            List<Usuario> listUsuarios = query.list();
            LOG.info("Termina listarTodosLosUsuarios Impl.");

            return usuarioMapper.usuarioTypeListEntityToTypeResponse(listUsuarios);
        }catch (ApplicationException e){
            LOG.error("Ha ocurrido un error en listarTodosLosUsuarios Impl:" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
    }
}
