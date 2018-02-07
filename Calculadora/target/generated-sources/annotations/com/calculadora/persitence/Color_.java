package com.calculadora.persitence;

import com.calculadora.persitence.DependeColorColor;
import com.calculadora.persitence.Opcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T13:13:01")
@StaticMetamodel(Color.class)
public class Color_ { 

    public static volatile ListAttribute<Color, DependeColorColor> dependeColorColorList;
    public static volatile SingularAttribute<Color, Integer> idcolor;
    public static volatile ListAttribute<Color, Opcion> opcionList;
    public static volatile SingularAttribute<Color, String> categoria;
    public static volatile SingularAttribute<Color, String> codigoHexadecimal;
    public static volatile SingularAttribute<Color, String> especificacion;
    public static volatile SingularAttribute<Color, String> nombre;
    public static volatile SingularAttribute<Color, String> dosificacion;

}