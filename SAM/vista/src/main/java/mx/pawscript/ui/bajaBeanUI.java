/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.ui;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.pawscript.entidad.Profesores;
import mx.pawscript.helper.profesorHelper;
import mx.pawscript.helper.unidadesHelper;

/**
 *
 */
@ManagedBean(name = "bajaBeanUI")
@SessionScoped
public class bajaBeanUI implements Serializable {
    private profesorHelper ProfesorHelper;
    private unidadesHelper UnidadesHelper;
    private List<Profesores> listaMaestroSinUnidades;

    public bajaBeanUI() {
        ProfesorHelper = new profesorHelper();
        UnidadesHelper = new unidadesHelper();
    }
    
    @PostConstruct
    public void init() {
        listaMaestroSinUnidades = this.getProfesoresSinUnidades();
    }
    
    public List<Profesores> getProfesoresSinUnidades() {
        return ProfesorHelper.obtenerProfesoresSinUnidades();
    }

    public List<Profesores> getListaMaestroSinUnidades() {
        return listaMaestroSinUnidades;
    }

    public void eliminarProfesor(Profesores profesor) {
        try {
            ProfesorHelper.bajaProfesor(profesor);
            listaMaestroSinUnidades.remove(profesor);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Profesor eliminado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar el profesor");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}