/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.ui;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.pawscript.entidad.Profesores;
import mx.pawscript.helper.LoginHelper;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable{
    private LoginHelper loginHelper;
    private Profesores profesor;
    
    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }
    
    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init(){
        profesor= new Profesores();
    }

     public void login() throws IOException{
        String appURL = "/vistaProfesor.xhtml";
        // los atributos de usuario vienen del xhtml 
        try{
        Profesores us = new Profesores();
        us = loginHelper.Login(profesor.getCorreo(), profesor.getPassword());
        System.out.println(us);
        if(us != null && !us.getCorreo().isEmpty()){
            // asigno el usuario encontrado al usuario de esta clase para que 
            // se muestre correctamente en la pagina de informacion
            profesor=us;
            if(profesor.getAdministrador() != null){
                appURL = "/vistaAdministrador.xhtml";
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
        }else{
            FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_WARN, "INFO", "Contraseña o correo invalido, intente de nuevo.");
            FacesContext.getCurrentInstance().addMessage(null, messages);
        }
        }catch(Exception e){
            FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_WARN, "INFO", "Contraseña o correo invalido, intente de nuevo.");
            FacesContext.getCurrentInstance().addMessage(null, messages);
        }
    }

    
    /* getters y setters*/

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
    
    
    
    
    
    
    
    

    

    
}
