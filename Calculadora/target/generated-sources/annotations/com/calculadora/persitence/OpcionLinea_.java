package com.calculadora.persitence;

import com.calculadora.persitence.DetalleCotizacion;
import com.calculadora.persitence.LineaDeTrabajo;
import com.calculadora.persitence.Opcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T13:58:20")
@StaticMetamodel(OpcionLinea.class)
public class OpcionLinea_ { 

    public static volatile SingularAttribute<OpcionLinea, Opcion> opcionIdopcion;
    public static volatile SingularAttribute<OpcionLinea, Integer> idopcionLinea;
    public static volatile SingularAttribute<OpcionLinea, LineaDeTrabajo> lineaDeTrabajoIdlineaDeTrabajo;
    public static volatile SingularAttribute<OpcionLinea, String> nombre;
    public static volatile ListAttribute<OpcionLinea, DetalleCotizacion> detalleCotizacionList;

}