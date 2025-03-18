/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.helper;

import java.io.Serializable;
import mx.pawscript.entidad.Profesores;
import mx.pawscript.integracion.ServiceFacadeLocator;

/**
 *
 * @author alber
 */
public class profesorHelper implements Serializable{
    
    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param profesor 
     */
    public void alta(Profesores profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesores().altaProfesor(profesor);
    }
    
    public int validarAlta(Profesores profesor){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().validarAlta(profesor);
    }
    
}
