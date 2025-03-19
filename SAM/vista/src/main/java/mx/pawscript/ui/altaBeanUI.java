/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.ui;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private List<Profesores> profesores;
    
    public altaBeanUI() {
        ProfesorHelper = new profesorHelper();
    }
    
    @PostConstruct
    public void init(){
        profesor = new Profesores();
        profesores = new ArrayList();
    }
    
    public void alta() throws IOException {
        try {
            FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Profesor agregado correctamente.");
            switch(ProfesorHelper.validarAlta(profesor)){
                case 1:
                    ProfesorHelper.alta(profesor);
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Profesor agregado correctamente.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 2:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El RFC no sigue el formato correcto.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 3:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El RFC ya esta registrado.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 4:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El número de profesor se encuentra ya registrado.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 5:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El correo electronico no sigue el formato correcto.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 6:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El campo numero profesor esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 7:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El campo nombre profesor esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 8:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El campo apellido profesor esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 9:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El campo RFC esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 10:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El campo correo electronico esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 11:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El campo contraseña esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
            }
            
        } catch (Exception e) {

        }
    }
    
    public List<Profesores> consultaProfesores() throws IOException {
        return profesorHelper.consultaProfesores();
    }
    
    
        // Getter y Setter
    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
    
    public void setProfesores(List<Profesores> profesores){
        this.profesores = profesores;
        }
    public List<Profesores> getProfesores(){
        return profesores;
    }
}
