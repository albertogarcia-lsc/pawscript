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
    
    private static ProfesoresDAO profesoresDAO;
    private static UnidadesDAO unidadesDAO;
    /**
     * se crea la instancia para alumno DAO si esta no existe
     */
    public static ProfesoresDAO getInstanceProfesoresDAO(){
        if(profesoresDAO == null){
            profesoresDAO = new ProfesoresDAO();
            return profesoresDAO;
        } else{
            return profesoresDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     */
    public static UnidadesDAO getInstanceUnidadesDAO(){
        if(unidadesDAO == null){
            unidadesDAO = new UnidadesDAO();
            return unidadesDAO;
        } else{
            return unidadesDAO;
        }
    }
    
}
