/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.integracion;

import mx.pawscript.DAO.ProfesoresDAO;
import mx.pawscript.DAO.UnidadesDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static ProfesoresDAO alumnoDAO;
    private static UnidadesDAO usuarioDAO;
    /**
     * se crea la instancia para alumno DAO si esta no existe
     */
    public static ProfesoresDAO getInstanceProfesoresDAO(){
        if(alumnoDAO == null){
            alumnoDAO = new ProfesoresDAO();
            return alumnoDAO;
        } else{
            return alumnoDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     */
    public static UnidadesDAO getInstanceUnidadesDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UnidadesDAO();
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
    
}
