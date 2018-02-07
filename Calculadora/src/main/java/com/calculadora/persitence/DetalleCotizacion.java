/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculadora.persitence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yeisson alvarez
 */
@Entity
@Table(name = "detalle_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCotizacion.findAll", query = "SELECT d FROM DetalleCotizacion d")
    , @NamedQuery(name = "DetalleCotizacion.findByIddetalleCotizacion", query = "SELECT d FROM DetalleCotizacion d WHERE d.iddetalleCotizacion = :iddetalleCotizacion")
    , @NamedQuery(name = "DetalleCotizacion.findByConcepto", query = "SELECT d FROM DetalleCotizacion d WHERE d.concepto = :concepto")
    , @NamedQuery(name = "DetalleCotizacion.findByValorlitro", query = "SELECT d FROM DetalleCotizacion d WHERE d.valorlitro = :valorlitro")
    , @NamedQuery(name = "DetalleCotizacion.findByValorkilos", query = "SELECT d FROM DetalleCotizacion d WHERE d.valorkilos = :valorkilos")
    , @NamedQuery(name = "DetalleCotizacion.findByValorunidad", query = "SELECT d FROM DetalleCotizacion d WHERE d.valorunidad = :valorunidad")})
public class DetalleCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_cotizacion")
    private Integer iddetalleCotizacion;
    @Size(max = 80)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 30)
    @Column(name = "valorlitro")
    private String valorlitro;
    @Size(max = 30)
    @Column(name = "valorkilos")
    private String valorkilos;
    @Size(max = 30)
    @Column(name = "valorunidad")
    private String valorunidad;
    @JoinColumn(name = "factura_cotizar_idfactura_cotizar", referencedColumnName = "idfactura_cotizar")
    @ManyToOne(optional = false)
    private FacturaCotizar facturaCotizarIdfacturaCotizar;
    @JoinColumn(name = "opcion_linea_idopcion_linea", referencedColumnName = "idopcion_linea")
    @ManyToOne(optional = false)
    private OpcionLinea opcionLineaIdopcionLinea;

    public DetalleCotizacion() {
    }

    public DetalleCotizacion(Integer iddetalleCotizacion) {
        this.iddetalleCotizacion = iddetalleCotizacion;
    }

    public Integer getIddetalleCotizacion() {
        return iddetalleCotizacion;
    }

    public void setIddetalleCotizacion(Integer iddetalleCotizacion) {
        this.iddetalleCotizacion = iddetalleCotizacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getValorlitro() {
        return valorlitro;
    }

    public void setValorlitro(String valorlitro) {
        this.valorlitro = valorlitro;
    }

    public String getValorkilos() {
        return valorkilos;
    }

    public void setValorkilos(String valorkilos) {
        this.valorkilos = valorkilos;
    }

    public String getValorunidad() {
        return valorunidad;
    }

    public void setValorunidad(String valorunidad) {
        this.valorunidad = valorunidad;
    }

    public FacturaCotizar getFacturaCotizarIdfacturaCotizar() {
        return facturaCotizarIdfacturaCotizar;
    }

    public void setFacturaCotizarIdfacturaCotizar(FacturaCotizar facturaCotizarIdfacturaCotizar) {
        this.facturaCotizarIdfacturaCotizar = facturaCotizarIdfacturaCotizar;
    }

    public OpcionLinea getOpcionLineaIdopcionLinea() {
        return opcionLineaIdopcionLinea;
    }

    public void setOpcionLineaIdopcionLinea(OpcionLinea opcionLineaIdopcionLinea) {
        this.opcionLineaIdopcionLinea = opcionLineaIdopcionLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleCotizacion != null ? iddetalleCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCotizacion)) {
            return false;
        }
        DetalleCotizacion other = (DetalleCotizacion) object;
        if ((this.iddetalleCotizacion == null && other.iddetalleCotizacion != null) || (this.iddetalleCotizacion != null && !this.iddetalleCotizacion.equals(other.iddetalleCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.DetalleCotizacion[ iddetalleCotizacion=" + iddetalleCotizacion + " ]";
    }
    
}
