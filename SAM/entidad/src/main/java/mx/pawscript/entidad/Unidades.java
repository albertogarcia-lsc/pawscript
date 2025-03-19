/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pawscript.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alber
 */
@Entity
@Table(name = "unidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidades.findAll", query = "SELECT u FROM Unidades u")
    , @NamedQuery(name = "Unidades.findByClaveUnidadAprendizaje", query = "SELECT u FROM Unidades u WHERE u.claveUnidadAprendizaje = :claveUnidadAprendizaje")
    , @NamedQuery(name = "Unidades.findByNombreUnidad", query = "SELECT u FROM Unidades u WHERE u.nombreUnidad = :nombreUnidad")
    , @NamedQuery(name = "Unidades.findByHorasClase", query = "SELECT u FROM Unidades u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "Unidades.findByHorasTaller", query = "SELECT u FROM Unidades u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "Unidades.findByHorasLaboratorio", query = "SELECT u FROM Unidades u WHERE u.horasLaboratorio = :horasLaboratorio")})
public class Unidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "claveUnidadAprendizaje")
    private Integer claveUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "nombreUnidad")
    private String nombreUnidad;
    @Column(name = "horas_clase")
    private Integer horasClase;
    @Column(name = "horas_taller")
    private Integer horasTaller;
    @Column(name = "horas_laboratorio")
    private Integer horasLaboratorio;
    @ManyToMany(mappedBy = "unidadesList")
    private List<Profesores> profesoresList;

    public Unidades() {
    }

    public Unidades(Integer claveUnidadAprendizaje) {
        this.claveUnidadAprendizaje = claveUnidadAprendizaje;
    }

    public Unidades(Integer claveUnidadAprendizaje, String nombreUnidad) {
        this.claveUnidadAprendizaje = claveUnidadAprendizaje;
        this.nombreUnidad = nombreUnidad;
    }

    public Integer getClaveUnidadAprendizaje() {
        return claveUnidadAprendizaje;
    }

    public void setClaveUnidadAprendizaje(Integer claveUnidadAprendizaje) {
        this.claveUnidadAprendizaje = claveUnidadAprendizaje;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    public Integer getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @XmlTransient
    public List<Profesores> getProfesoresList() {
        return profesoresList;
    }

    public void setProfesoresList(List<Profesores> profesoresList) {
        this.profesoresList = profesoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveUnidadAprendizaje != null ? claveUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidades)) {
            return false;
        }
        Unidades other = (Unidades) object;
        if ((this.claveUnidadAprendizaje == null && other.claveUnidadAprendizaje != null) || (this.claveUnidadAprendizaje != null && !this.claveUnidadAprendizaje.equals(other.claveUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

        @Override
        public String toString() {
            return "Clave:" + claveUnidadAprendizaje + "\n" +
                   "Nombre:'" + nombreUnidad + '\'' + "\n" +
                   "Horas Clase:" + horasClase + "\n" +
                   "Horas Taller:" + horasTaller + "\n" +
                   "Horas Laboratorio:" + horasLaboratorio + "\n";
        }

    
}
