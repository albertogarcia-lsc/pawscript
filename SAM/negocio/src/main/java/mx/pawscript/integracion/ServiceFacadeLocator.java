/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.integracion;

import mx.pawscript.facade.FacadeUnidades;
import mx.pawscript.facade.FacadeProfesores;

/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
    
    private static FacadeUnidades facadeUnidades;
    private static FacadeProfesores facadeProfesores;
    
    public static FacadeUnidades getInstanceFacadeUnidades() {
        if (facadeUnidades == null) {
            facadeUnidades = new FacadeUnidades();
            return facadeUnidades;
        } else {
            return facadeUnidades;
        }
    }
    
    public static FacadeProfesores getInstanceFacadeProfesores() {
        if (facadeProfesores == null) {
            facadeProfesores = new FacadeProfesores();
            return facadeProfesores;
        } else {
            return facadeProfesores;
        }
    }
}
