/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.helper;

import java.io.Serializable;
import java.util.List;
import mx.pawscript.entidad.Unidades;
import mx.pawscript.integracion.ServiceFacadeLocator;

/**
 *
 * @author alber
 */
public class unidadesHelper implements Serializable {
       /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param unidad 
     */
    public void alta(Unidades unidad){
        ServiceFacadeLocator.getInstanceFacadeUnidades().altaUnidad(unidad);
    }
    
    public int validarUnidad(Unidades unidad){
        return ServiceFacadeLocator.getInstanceFacadeUnidades().validarUnidad(unidad);
    }
    
    public List<Unidades> obtenerUnidades(){
        return ServiceFacadeLocator.getInstanceFacadeUnidades().obtenerUnidades();
    }
     
}
