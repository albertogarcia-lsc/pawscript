package mx.pawscript.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.pawscript.entidad.Unidades;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-03-17T01:42:50")
@StaticMetamodel(Profesores.class)
public class Profesores_ { 

    public static volatile ListAttribute<Profesores, Unidades> unidadesList;
    public static volatile SingularAttribute<Profesores, Boolean> administrador;
    public static volatile SingularAttribute<Profesores, String> password;
    public static volatile SingularAttribute<Profesores, Integer> numProfesor;
    public static volatile SingularAttribute<Profesores, String> apellido;
    public static volatile SingularAttribute<Profesores, String> correo;
    public static volatile SingularAttribute<Profesores, String> nombre;
    public static volatile SingularAttribute<Profesores, String> rfc;

}