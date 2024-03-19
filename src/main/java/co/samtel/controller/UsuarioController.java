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
            LOG.info("Termina el proceso crearUsuario Controller");
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " crearUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }
        return Response.status(Response.Status.CREATED).entity(usuarioType).build();
    }

    @Override
    public Response editarUsuarioId(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio el proceso editarUsuario Controller");
        try{
            usuarioServiceImpl.editarUsuarioId(idtblUser, usuarioTypeInput);
            LOG.info("Termina el proceso editarUsuario Controller");
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " editarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioTypeInput).build();
        }
        return Response.status(Response.Status.OK).entity(usuarioTypeInput).build();
    }

    @Override
    public Response eliminarUsuarioId(Integer idtblUser) {
        LOG.info("Inicio el proceso eliminarUsuario Controller.");
        try{
            usuarioServiceImpl.eliminarUsuarioId(idtblUser);
            LOG.info("Termina el proceso eliminarUsuario Controller.");
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " eliminarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Response listarTodosLosUsuarios() {
        LOG.info("Inicio el proceso listarTodosLosUsuarios Controller.");
        List<UsuarioTypeResponse> usuarioType = null;
        try{
            usuarioType = usuarioServiceImpl.listarTodosLosUsuarios();
            LOG.info("Termina el proceso listarTodosLosUsuarios Controller.");
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " listarTodosLosUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }
        return Response.status(Response.Status.FOUND).entity(usuarioType).build();
    }

    @Override
    public Response buscarUsuarioId(Integer idtblUser) {
        LOG.info("Inicio el proceso de listarUsuario Controller.");
        List<UsuarioTypeResponse> usuarioType = null;
        try{
            usuarioType = usuarioServiceImpl.buscarUsuarioId(idtblUser);
            LOG.info("Termina el proceso de listarUsuario Controller.");
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " listarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }
        return Response.status(Response.Status.FOUND).entity(usuarioType).build();
    }

}
