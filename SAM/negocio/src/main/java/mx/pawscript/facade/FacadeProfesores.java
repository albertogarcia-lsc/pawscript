    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.facade;

import java.io.Serializable;
import java.util.List;
import mx.pawscript.delegate.DelegateProfesores;
import mx.pawscript.entidad.Profesores;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeProfesores implements Serializable {
    
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
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param profesor
     */
    public void altaProfesor(Profesores profesor) {
        delegateProfesores.registrarProfesor(profesor);
    }
    
    public int validarAlta(Profesores profesor) {
        return delegateProfesores.validacionesAlta(profesor);
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param profesor
     */
    public void saveUsario(Profesores profesor){
        delegateProfesores.saveProfesor(profesor);
    }
    
    public List<Profesores> consultaProfesores() {
        return delegateProfesores.consultaProfesores();
    }
    
    public List<Profesores> consultaProfesoresTabla() {
        return delegateProfesores.consultaProfesoresTabla();
    }
    
    public void bajaProfesor (Profesores profesor){
        delegateProfesores.bajaProfesor(profesor);
    }
    
    public int altaRelacion(int numProfesor, int numUnidad){
        return delegateProfesores.altaRelacion(numProfesor, numUnidad);
    }
}
