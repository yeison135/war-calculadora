package com.calculadora.persitence;

import com.calculadora.persitence.FacturaCotizar;
import com.calculadora.persitence.OpcionLinea;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T13:13:01")
@StaticMetamodel(DetalleCotizacion.class)
public class DetalleCotizacion_ { 

    public static volatile SingularAttribute<DetalleCotizacion, OpcionLinea> opcionLineaIdopcionLinea;
    public static volatile SingularAttribute<DetalleCotizacion, String> valorlitro;
    public static volatile SingularAttribute<DetalleCotizacion, String> valorkilos;
    public static volatile SingularAttribute<DetalleCotizacion, Integer> iddetalleCotizacion;
    public static volatile SingularAttribute<DetalleCotizacion, String> valorunidad;
    public static volatile SingularAttribute<DetalleCotizacion, String> concepto;
    public static volatile SingularAttribute<DetalleCotizacion, FacturaCotizar> facturaCotizarIdfacturaCotizar;

}