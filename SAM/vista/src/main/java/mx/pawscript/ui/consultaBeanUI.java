/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private String unidadBuscar;
    private List<Profesores> ProfesoresImparten = new ArrayList<>();
    private Unidades unidadBuscada;
    private String textoLabel;
    private String claveUnidadBuscada;
    private String nombreUnidadBuscada;
    private String HorasCBuscada;
    private String HorasTBuscada;
    private String HorasLBuscada;
    
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
   
   
    public void actualizarTextoUnidadBuscadaM() {
        this.claveUnidadBuscada = "Clave: " + unidadBuscada.getClaveUnidadAprendizaje() +"\n";
        this.nombreUnidadBuscada = "Nombre: " + unidadBuscada.getNombreUnidad()+"\n";
        this.HorasCBuscada = "Horas Clase: " + unidadBuscada.getHorasClase()+"\n";
        this.HorasTBuscada = "Horas Taller: " + unidadBuscada.getHorasTaller()+"\n";
        this.HorasLBuscada = "Horas Laboratorio: " + unidadBuscada.getHorasLaboratorio()+"\n";
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
    
    public void eliminarRelacion(){
        FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Mensaje inicializado");
        switch(ProfesorHelper.eliminarRelacion(this.getIdOpcionSeleccionadaMaestro(),unidadBuscada.getClaveUnidadAprendizaje())){
                case 1:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Asignación eliminada con exito.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
        }
    }
    
    public void buscarUnidad(){
        FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Mensaje inicializado");
        try {
        int numBuscar = Integer.parseInt(unidadBuscar);
            for(Unidades aux: this.getUnidades()){
                if(Objects.equals(aux.getClaveUnidadAprendizaje(), numBuscar)){
                    this.setUnidadBuscada(aux);
                    ProfesoresImparten = aux.getProfesoresList();
                    break;
                }
            }
            
        if(ProfesoresImparten.isEmpty()){
            messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se encontraron profesores");
            FacesContext.getCurrentInstance().addMessage(null, messages);
        }
        
        this.actualizarTextoUnidadBuscadaM();
            
        } catch (NumberFormatException e) {
            messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La busqueda solo permite números. Porfavor solo ingresar números.");
            FacesContext.getCurrentInstance().addMessage(null, messages);
        }


    }
    
    public String redirigirMod() {
        return "asignacionModificacion?faces-redirect=true&parametro1=" + unidadBuscada.getClaveUnidadAprendizaje() + "&parametro2=" + this.getIdOpcionSeleccionadaMaestro();
    }
    
    
    //Setter getters
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
    
    public List<Profesores> getProfesoresImparte() {
        return this.ProfesoresImparten;
    }
    public void setProfesoresImparte(List<Profesores> ProfesoresImparten) {
        this.ProfesoresImparten = ProfesoresImparten;
    }
    
    public String getUnidadBuscar() {
        return unidadBuscar;
    }
    public void setUnidadBuscar(String unidadBuscar) {
        this.unidadBuscar = unidadBuscar;
    }
    
    public Unidades setUnidadBuscada() {
        return unidadBuscada;
    }
    public void setUnidadBuscada(Unidades unidadBuscada) {
        this.unidadBuscada = unidadBuscada;
    }
    
    public String getTextoLabel() {
        return textoLabel;
    }

    public void setTextoLabel(String textoLabel) {
        this.textoLabel = textoLabel;
    }
    public int getIdOpcionSeleccionadaUnidad() {
        return idOpcionSeleccionadaUnidad;
    }
     
    public void setIdOpcionSeleccionadaUnidad(int idOpcionSeleccionadaUnidad) {
        this.idOpcionSeleccionadaUnidad = idOpcionSeleccionadaUnidad;
    }
    
    public String getClaveUnidadBuscada() {
        return claveUnidadBuscada;
    }

    public void setClaveUnidadBuscada(String claveUnidadBuscada) {
        this.claveUnidadBuscada = claveUnidadBuscada;
    }

    public String getNombreUnidadBuscada() {
        return nombreUnidadBuscada;
    }

    public void setNombreUnidadBuscada(String nombreUnidadBuscada) {
        this.nombreUnidadBuscada = nombreUnidadBuscada;
    }

    public String getHorasCBuscada() {
        return HorasCBuscada;
    }

    public void setHorasCBuscada(String horasCBuscada) {
        this.HorasCBuscada = horasCBuscada;
    }

    public String getHorasTBuscada() {
        return HorasTBuscada;
    }

    public void setHorasTBuscada(String horasTBuscada) {
        this.HorasTBuscada = horasTBuscada;
    }

    public String getHorasLBuscada() {
        return HorasLBuscada;
    }

    public void setHorasLBuscada(String horasLBuscada) {
        this.HorasLBuscada = horasLBuscada;
    }

}
