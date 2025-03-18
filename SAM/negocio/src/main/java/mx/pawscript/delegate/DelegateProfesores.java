/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.delegate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mx.pawscript.entidad.Profesores;
import mx.pawscript.integracion.ServiceLocator;

/**
 *
 * @author alber
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
     * Metodo para registrar profesor
     * @param profesor
     */
    public void registrarProfesor(Profesores profesor) {
        ServiceLocator.getInstanceProfesoresDAO().save(profesor);
    }
    /**
     * Metodo para validaciones
     * @param profesor
     */
    public int validacionesAlta(Profesores profesor){
        String regexPersonaFisica = "^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$";
        String regexPersonaMoral = "^[A-ZÑ&]{3}\\d{6}[A-Z0-9]{3}$";
        System.out.println(profesor);
        
        if(profesor.getNumProfesor() == null){
            return 6;
        }
        if(profesor.getNombre().isEmpty()){
            return 7;
        }
        if(profesor.getApellido().isEmpty()){
            return 8;
        }
        if(profesor.getRfc().isEmpty()){
            return 9;
        }
        if(profesor.getCorreo().isEmpty()){
            return 10;
        }
        if(profesor.getPassword().isEmpty()){
            return 11;
        }

        if(!profesor.getRfc().matches(regexPersonaFisica) && !profesor.getRfc().matches(regexPersonaMoral)){
            return 2;
        }
        
        List<Profesores> rfcDuplicado = ServiceLocator.getInstanceProfesoresDAO().findByOneParameter(profesor.getRfc(), "rfc");
        if (rfcDuplicado != null && !rfcDuplicado.isEmpty()) {
            return 3;
        }
        
        List<Profesores> numProfe = ServiceLocator.getInstanceProfesoresDAO().findByOneParameter(profesor.getNumProfesor().toString(), "numProfesor");
        if (numProfe != null && !numProfe.isEmpty()) {
            return 4;
        }
        
        if (!Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$").matcher(profesor.getCorreo()).matches()) {
           return 5;
        }
        
        return 1;
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveProfesor(Profesores profesor){
        ServiceLocator.getInstanceProfesoresDAO().save(profesor);
    }
    
}
