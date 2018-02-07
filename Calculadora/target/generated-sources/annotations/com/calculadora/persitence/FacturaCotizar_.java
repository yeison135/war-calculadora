package com.calculadora.persitence;

import com.calculadora.persitence.Cliente;
import com.calculadora.persitence.DetalleCotizacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T13:13:01")
@StaticMetamodel(FacturaCotizar.class)
public class FacturaCotizar_ { 

    public static volatile SingularAttribute<FacturaCotizar, Integer> idfacturaCotizar;
    public static volatile SingularAttribute<FacturaCotizar, Date> fecha;
    public static volatile SingularAttribute<FacturaCotizar, Cliente> clienteIdcliente;
    public static volatile ListAttribute<FacturaCotizar, DetalleCotizacion> detalleCotizacionList;

}