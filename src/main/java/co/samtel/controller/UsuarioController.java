package co.samtel.controller;

import co.samtel.dao.UsuarioDao;
import co.samtel.entity.Usuario;
import co.samtel.gen.contract.V1UsuarioApi;
import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;
import co.samtel.service.impl.UsuarioServiceImpl;
import co.samtel.utils.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static co.samtel.constant.Constant.ERROR_SERVICIO;

public class UsuarioController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @Override
    public Response crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio el proceso crearUsuario Controller");
        UsuarioTypeResponse usuarioType = null;

        try{
            usuarioType = usuarioServiceImpl.crearUsuario(usuarioTypeInput);
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " crearUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }
        return Response.status(Response.Status.CREATED).entity(usuarioType).build();
    }

    @Override
    public Response editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio el proceso editarUsuario Controller");

        try{
            usuarioServiceImpl.editarUsuario(idtblUser, usuarioTypeInput);
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " editarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioTypeInput).build();
        }

        return Response.ok().entity(usuarioTypeInput).build();
    }

    @Override
    public Response eliminarUsuario(Integer idtblUser) {
        LOG.info("Inicio el proceso eliminarUsuario Controller.");
        try{
            usuarioServiceImpl.eliminarUsuario(idtblUser);
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " eliminarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.noContent().build();
    }

    @Override
    public Response listarTodosLosUsuario() {
        LOG.info("Inicio el proceso listarTodosLosUsuarios Controller.");
        List<UsuarioTypeResponse> usuarioType = null;
        try{
            usuarioType = usuarioServiceImpl.listarTodosLosUsuarios();
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " listarTodosLosUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }
        return Response.status(Response.Status.FOUND).entity(usuarioType).build();
    }

    @Override
    public Response listarUsuario(Integer idtblUser) {
        LOG.info("Inicio el proceso de listarUsuario Controller.");

        List<UsuarioTypeResponse> usuarioType = null;

        try{
            usuarioType = usuarioServiceImpl.listarUsuario(idtblUser);
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " listarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }

        return Response.status(Response.Status.FOUND).entity(usuarioType).build();
    }

}
