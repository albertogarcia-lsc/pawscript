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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "profesores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p")
    , @NamedQuery(name = "Profesores.findByNumProfesor", query = "SELECT p FROM Profesores p WHERE p.numProfesor = :numProfesor")
    , @NamedQuery(name = "Profesores.findByNombre", query = "SELECT p FROM Profesores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesores.findByApellido", query = "SELECT p FROM Profesores p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Profesores.findByRfc", query = "SELECT p FROM Profesores p WHERE p.rfc = :rfc")
    , @NamedQuery(name = "Profesores.findByAdministrador", query = "SELECT p FROM Profesores p WHERE p.administrador = :administrador")
    , @NamedQuery(name = "Profesores.findByCorreo", query = "SELECT p FROM Profesores p WHERE p.correo = :correo")
    , @NamedQuery(name = "Profesores.findByPassword", query = "SELECT p FROM Profesores p WHERE p.password = :password")})
public class Profesores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numProfesor")
    private Integer numProfesor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "Administrador")
    private Boolean administrador;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinTable(name = "usuarios_unidades", joinColumns = {
        @JoinColumn(name = "numProfesor", referencedColumnName = "numProfesor")}, inverseJoinColumns = {
        @JoinColumn(name = "claveUnidadAprendizaje", referencedColumnName = "claveUnidadAprendizaje")})
    @ManyToMany
    private List<Unidades> unidadesList;

    public Profesores() {
    }

    public Profesores(Integer numProfesor) {
        this.numProfesor = numProfesor;
    }

    public Profesores(Integer numProfesor, String nombre, String apellido, String rfc, String correo, String password) {
        this.numProfesor = numProfesor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rfc = rfc;
        this.correo = correo;
        this.password = password;
    }

    public Integer getNumProfesor() {
        return numProfesor;
    }

    public void setNumProfesor(Integer numProfesor) {
        this.numProfesor = numProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Unidades> getUnidadesList() {
        return unidadesList;
    }

    public void setUnidadesList(List<Unidades> unidadesList) {
        this.unidadesList = unidadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numProfesor != null ? numProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.numProfesor == null && other.numProfesor != null) || (this.numProfesor != null && !this.numProfesor.equals(other.numProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pawscript.entidad.Profesores[ numProfesor=" + numProfesor + " ]";
    }
    
}
