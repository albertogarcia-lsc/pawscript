/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.delegate;

import mx.pawscript.entidad.Unidades;
import mx.pawscript.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUnidades {
    
    /**
     * Metodo de ejemplo para guardar Alumno
     * @param alumno de tipo usuario con id 0 para que se cree un id nuevo
     */
    public void saveUnidades(Unidades unidad){
        ServiceLocator.getInstanceUnidadesDAO().save(unidad);
    }
    
}
