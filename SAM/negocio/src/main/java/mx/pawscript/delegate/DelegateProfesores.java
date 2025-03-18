/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.delegate;

import java.util.List;
import mx.pawscript.entidad.Profesores;
import mx.pawscript.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateProfesores {
    
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param correo
     * @return un tipo usuario si no encuntra el usuario sera null
     */
    public Profesores login(String password, String correo){
        Profesores usuario = new Profesores();
        List<Profesores> usuarios = ServiceLocator.getInstanceProfesoresDAO().findAll();
        
        for(Profesores us:usuarios){
            if(us.getPassword().equalsIgnoreCase(password) && us.getCorreo().equalsIgnoreCase(correo)){
                usuario = us;
            }
        }
        return usuario;
    }
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param profesor
     */
    public void registrarProfesor(Profesores profesor) {
        ServiceLocator.getInstanceProfesoresDAO().save(profesor);
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveProfesor(Profesores profesor){
        ServiceLocator.getInstanceProfesoresDAO().save(profesor);
    }
    
}
