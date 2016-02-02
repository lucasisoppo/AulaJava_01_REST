package com.projetoteste.dao;

import com.projetoteste.modelo.Usuarios;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    
    private static List<Usuarios> usuarios = new ArrayList<Usuarios>();
    
    
    public List<Usuarios> buscaTodos(){
      return usuarios;  
    };
    
    public Usuarios buscaPorId(int id){
        for (Usuarios u : this.usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return new Usuarios();
    }
    
    public Usuarios criarUsuario(Usuarios user) {
        
        user.setId(usuarios.size()+1);
        System.out.println("Teste: "+usuarios.size());
        this.usuarios.add(user);
        return user;
    } 
    
    public Usuarios atualizaUsuario(Usuarios user) {
        Usuarios byId = this.buscaPorId(user.getId());
        byId.setUserName(user.getUserName());
        byId.setPassword(user.getPassword());
        byId.setEmail(user.getEmail());
        byId.setAddress(user.getAddress());
        return byId;
    }
    
    public void remove(int id) {
        Usuarios byId = this.buscaPorId(id);
        this.usuarios.remove(byId);
    }
    
    public int buscaNumeroUsuarios() {
        return this.usuarios.size();
    }
    
}
