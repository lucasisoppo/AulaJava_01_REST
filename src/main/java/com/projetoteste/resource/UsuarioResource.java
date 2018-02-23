package com.projetoteste.resource;

import com.projetoteste.dao.Banco;
import com.projetoteste.modelo.Usuarios;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType; 

@Path("/usuario") 
public class UsuarioResource {  
    List<Usuarios> usuarios = new ArrayList();
    Banco db = new Banco();
    
    @GET
    @Path("numberOfUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNumberOfUsers() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException  {
        System.out.println("busca numero de usuarios cadastrados");
        return db.buscaNumeroUsuarios();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> getAllUsersInJSON() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException  {
        System.out.println("GET TODOS");
        usuarios = db.buscaTodos();
        return usuarios;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios getUserById(@PathParam("id") int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("GET:"+id);
        return db.buscaPorId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios create(Usuarios user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
         System.out.println("POST: "+user.getUserName());
         Usuarios u = db.criarUsuario(user);
        
        return u;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios update(Usuarios user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("PUT:"+user.getId());
        Usuarios u = db.atualizaUsuario(user);
        
        return u;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("DELETE:"+id);
        db.remove(id);
    }
}
