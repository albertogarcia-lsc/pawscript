/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.helper;

import java.io.Serializable;
import java.util.List;
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
    
    public List<Profesores> obtenerProfesores(){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().consultaProfesores();
    }
     public List<Profesores> obtenerProfesoresTabla(){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().consultaProfesoresTabla();
    }
    
    public int altaRelacion(int numeroProfesor, int numUnidad){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().altaRelacion(numeroProfesor,numUnidad);
    }
    
    public int eliminarRelacion(int numeroProfesor, int numUnidad){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().eliminarRelacion(numeroProfesor,numUnidad);
    }
    
}
