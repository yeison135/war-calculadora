package com.calculadora.persitence;

import com.calculadora.persitence.Opcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T13:58:20")
@StaticMetamodel(Herramienta.class)
public class Herramienta_ { 

    public static volatile SingularAttribute<Herramienta, String> descripcion;
    public static volatile ListAttribute<Herramienta, Opcion> opcionList;
    public static volatile SingularAttribute<Herramienta, Integer> idherramienta;

}