package mx.pawscript.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.pawscript.entidad.Profesores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-03-18T01:07:23")
@StaticMetamodel(Unidades.class)
public class Unidades_ { 

    public static volatile SingularAttribute<Unidades, Integer> horasLaboratorio;
    public static volatile SingularAttribute<Unidades, Integer> claveUnidadAprendizaje;
    public static volatile SingularAttribute<Unidades, Integer> horasClase;
    public static volatile SingularAttribute<Unidades, String> nombreUnidad;
    public static volatile SingularAttribute<Unidades, Integer> horasTaller;
    public static volatile ListAttribute<Unidades, Profesores> profesoresList;

}