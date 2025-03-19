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
import mx.pawscript.entidad.Unidades;
import mx.pawscript.helper.profesorHelper;
import mx.pawscript.helper.unidadesHelper;

/**
 *
 * @author alber
 */
@ManagedBean(name = "consultaBeanUI")
@SessionScoped
public class consultaBeanUI implements Serializable{
    private profesorHelper ProfesorHelper;
    private unidadesHelper UnidadesHelper;
    private Profesores profesor;
    private Profesores opcionSeleccionadaMaestro;
    private List<Profesores> listaMaestro;
    private int idOpcionSeleccionadaMaestro;
    private Unidades unidad;
    private Unidades opcionSeleccionadaUnidad;
    private List<Unidades> listaUnidades;
    private int idOpcionSeleccionadaUnidad;
    
    public consultaBeanUI() {
        ProfesorHelper = new profesorHelper();
        UnidadesHelper = new unidadesHelper();
    }
    
    @PostConstruct
    public void init(){
        profesor = new Profesores();
        listaMaestro = this.getProfesores();
        listaUnidades = this.getUnidades();
    }
    
    public List<Profesores> getProfesores() {
        return ProfesorHelper.obtenerProfesores();
    }
    
    public List<Unidades> getUnidades() {
        return UnidadesHelper.obtenerUnidades();
    }
   
    public int getIdOpcionSeleccionadaMaestro() {
        return idOpcionSeleccionadaMaestro;
    }
    public void setIdOpcionSeleccionadaMaestro(int idOpcionSeleccionadaMaestro) {
        this.idOpcionSeleccionadaMaestro = idOpcionSeleccionadaMaestro;
    }
    
     public int getIdOpcionSeleccionadaUnidad() {
        return idOpcionSeleccionadaUnidad;
    }
     
    public void setIdOpcionSeleccionadaUnidad(int idOpcionSeleccionadaUnidad) {
        this.idOpcionSeleccionadaUnidad = idOpcionSeleccionadaUnidad;
    }
    
    public void alta(){
        FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Profesor agregado correctamente.");
        switch(ProfesorHelper.altaRelacion(this.getIdOpcionSeleccionadaMaestro(),this.getIdOpcionSeleccionadaUnidad())){
                case 1:
                    ProfesorHelper.altaRelacion(idOpcionSeleccionadaMaestro, idOpcionSeleccionadaUnidad);
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Asignación realizada correctamente.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 2:
                    messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La relacion ya se encuentra registrada");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
        }
    }
   

}
