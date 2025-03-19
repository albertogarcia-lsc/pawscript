/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.delegate;

import java.util.List;
import mx.pawscript.entidad.Unidades;
import mx.pawscript.integracion.ServiceLocator;

/**
 *
 * @author albert
 */
public class DelegateUnidades {
    
    /**
     * Metodo para dar de alta unidad
     * @param unidad
     */
    public void registrarUnidad(Unidades unidad) {
        ServiceLocator.getInstanceUnidadesDAO().save(unidad);
    }
    
    /**
     * Metodo para validaciones
     * @param unidad
     */
    public int validacionesUnidad(Unidades unidad){
        
       
        if(unidad.getClaveUnidadAprendizaje() == null){
            return 6;
        }
        if(unidad.getNombreUnidad().isEmpty()){
            return 7;
        }
        if(unidad.getHorasClase() == null){
            return 8;
        }
        if(unidad.getHorasTaller() == null){
            return 9;
        }
        if(unidad.getHorasLaboratorio() == null){
            return 10;
        }
        List<Unidades> claveUnidadDuplicado = ServiceLocator.getInstanceUnidadesDAO().findByOneParameter(unidad.getClaveUnidadAprendizaje().toString(), "claveUnidadAprendizaje");
        if (claveUnidadDuplicado != null && !claveUnidadDuplicado.isEmpty()) {
            return 2;
        }
        
        if(unidad.getClaveUnidadAprendizaje() <= 0){
            return 11;
        }
        if(unidad.getHorasClase() < 0){
            return 12;
        }
        if(unidad.getHorasTaller() < 0){
            return 13;
        }
        if(unidad.getHorasLaboratorio() < 0){
            return 14;
        }
        
        return 1;
    }
    
    public List<Unidades> obtenerUnidades(){
        return ServiceLocator.getInstanceUnidadesDAO().findAll();
    }
}
