package com.calculadora.persitence;

import com.calculadora.persitence.OpcionLinea;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T13:58:20")
@StaticMetamodel(LineaDeTrabajo.class)
public class LineaDeTrabajo_ { 

    public static volatile SingularAttribute<LineaDeTrabajo, String> descripcion;
    public static volatile SingularAttribute<LineaDeTrabajo, Integer> idlineaDeTrabajo;
    public static volatile ListAttribute<LineaDeTrabajo, OpcionLinea> opcionLineaList;

}