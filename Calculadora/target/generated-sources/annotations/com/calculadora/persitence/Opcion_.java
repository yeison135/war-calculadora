package com.calculadora.persitence;

import com.calculadora.persitence.Color;
import com.calculadora.persitence.DependeColorColor;
import com.calculadora.persitence.Herramienta;
import com.calculadora.persitence.Molde;
import com.calculadora.persitence.NoColor;
import com.calculadora.persitence.OpcionLinea;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T13:13:01")
@StaticMetamodel(Opcion.class)
public class Opcion_ { 

    public static volatile SingularAttribute<Opcion, Herramienta> herramientaIdherramienta;
    public static volatile SingularAttribute<Opcion, NoColor> noColorIdnoColor;
    public static volatile SingularAttribute<Opcion, Color> colorIdcolor;
    public static volatile SingularAttribute<Opcion, DependeColorColor> dependeColorColorIddependeColorColor;
    public static volatile SingularAttribute<Opcion, Integer> idopcion;
    public static volatile SingularAttribute<Opcion, String> nombre;
    public static volatile SingularAttribute<Opcion, Molde> moldeIdmolde;
    public static volatile ListAttribute<Opcion, OpcionLinea> opcionLineaList;

}