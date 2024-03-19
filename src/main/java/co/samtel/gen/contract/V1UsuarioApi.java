package co.samtel.gen.contract;

import co.samtel.gen.type.UsuarioTypeInput;
import co.samtel.gen.type.UsuarioTypeResponse;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-19T08:20:33.181263700-05:00[America/Bogota]")
public interface V1UsuarioApi {

    @GET
    @Path("/buscarUsuarioId/{idtbl_user}")
    @Produces({ "application/json" })
    Response buscarUsuarioId(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @POST
    @Path("/crearUsuario")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearUsuario(@Valid UsuarioTypeInput usuarioTypeInput);

    @PUT
    @Path("/editarUsuarioId/{idtbl_user}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response editarUsuarioId(@PathParam("idtbl_user") @Min(1) Integer idtblUser,@Valid UsuarioTypeInput usuarioTypeInput);

    @DELETE
    @Path("/eliminarUsuarioId/{idtbl_user}")
    Response eliminarUsuarioId(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @GET
    @Path("/listadoUsuarios")
    @Produces({ "application/json" })
    Response listarTodosLosUsuarios();
}
