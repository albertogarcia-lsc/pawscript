/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.facade;

import mx.pawscript.delegate.DelegateUnidades;
import mx.pawscript.entidad.Unidades;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeUnidades {
    
    private final DelegateUnidades delegateUnidades;

    public FacadeUnidades() {
        this.delegateUnidades = new DelegateUnidades();
    }
    
    public void guardarAlumno(Unidades alumno){
        delegateUnidades.saveUnidades(alumno);
    }
    
}
