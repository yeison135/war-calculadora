package com.calculadora.persitence;

import com.calculadora.persitence.Opcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T13:58:20")
@StaticMetamodel(Molde.class)
public class Molde_ { 

    public static volatile SingularAttribute<Molde, String> descripcion;
    public static volatile ListAttribute<Molde, Opcion> opcionList;
    public static volatile SingularAttribute<Molde, Integer> idmolde;
    public static volatile SingularAttribute<Molde, String> categoria;

}