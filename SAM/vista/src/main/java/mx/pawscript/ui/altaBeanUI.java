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
import mx.pawscript.helper.profesorHelper;
/**
 *
 * @author alber
 */

@ManagedBean(name = "profesorBeanUI")
@SessionScoped
public class altaBeanUI implements Serializable{
    private profesorHelper ProfesorHelper;
    private Profesores profesor;
    
    public altaBeanUI() {
        ProfesorHelper = new profesorHelper();
    }
    
    @PostConstruct
    public void init(){
        profesor = new Profesores();
    }
    
    public void alta() throws IOException {
        try {
            System.out.println("Prueba alta");
            ProfesorHelper.alta(profesor);
        } catch (Exception e) {

        }
    }
    
        // Getter y Setter
    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
    
}
