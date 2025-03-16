/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.facade;

import mx.pawscript.delegate.DelegateProfesores;
import mx.pawscript.entidad.Profesores;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeProfesores {
    
    private final DelegateProfesores delegateProfesores;

    public FacadeProfesores() {
        this.delegateProfesores = new DelegateProfesores();
    }
    
     /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param correo
     * @return Regresa usuario si el correo y contrasena con correctos
     */
    public Profesores login(String password, String correo){
        return delegateProfesores.login(password, correo);
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Profesores profesor){
        delegateProfesores.saveProfesor(profesor);
    }
    
}
