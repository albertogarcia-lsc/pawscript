package mx.pawscript.ui;


import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.pawscript.entidad.Unidades;
import mx.pawscript.helper.unidadesHelper;

/**
 *
 * @author alber
 */

@ManagedBean(name = "unidadBeanUI")
@SessionScoped
public class unidadesBeanUI implements Serializable{
    private unidadesHelper unidadHelper;
    private Unidades unidad;
    
    public unidadesBeanUI() {
        unidadHelper = new unidadesHelper();
    }
    
    @PostConstruct
    public void init(){
        unidad = new Unidades();
    }
    
    public void alta() throws IOException {
        try {
            FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Profesor agregado correctamente.");
            switch(unidadHelper.validarUnidad(unidad)){
                case 1:
                    unidadHelper.alta(unidad);
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Unidad agregada correctamente.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 2:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La clave unidad ya se encuentra registrada.");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 6:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El campo numero unidad esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 7:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El campo nombre unidad esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 8:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El campo horas clase esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 9:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El campo horas taller esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 10:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El campo horas laboratorio esta vacio");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 11:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "La clave unidad no puede ser menor de 0");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 12:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Las horas clase no pueden ser menor que 0");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 13:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Las horas taller no pueden ser menor de 0");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
                case 14:
                    messages = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Las horas laboratorio no pueden ser menor que 0");
                    FacesContext.getCurrentInstance().addMessage(null, messages);
                break;
            }
            
        } catch (Exception e) {

        }
    }
    
    
        // Getter y Setter
    public Unidades getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidades unidad) {
        this.unidad = unidad;
    }
    
}
