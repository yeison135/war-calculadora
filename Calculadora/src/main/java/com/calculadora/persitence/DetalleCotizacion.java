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
    @Size(max = 15)
    @Column(name = "unidadmolde")
    private String unidadmolde;
    @Size(max = 10)
    @Column(name = "moldecompra")
    private String moldecompra;
    @Size(max = 10)
    @Column(name = "conceptosellador")
    private String conceptosellador;
    @Size(max = 10)
    @Column(name = "conceptofibra")
    private String conceptofibra;
    @Size(max = 10)
    @Column(name = "centimetrofibra")
    private String centimetrofibra;
    @Size(max = 45)
    @Column(name = "detalle_cotizacioncol")
    private String detalleCotizacioncol;
    @Size(max = 10)
    @Column(name = "PSI-integral")
    private String pSIintegral;
    @Size(max = 10)
    @Column(name = "PSI-porcentaje")
    private String pSIporcentaje;
    @Size(max = 15)
    @Column(name = "dosificacion")
    private String dosificacion;
    @Size(max = 15)
    @Column(name = "unidadporlitro10")
    private String unidadporlitro10;
    @Size(max = 15)
    @Column(name = "unidadporlitro20")
    private String unidadporlitro20;
    @Size(max = 15)
    @Column(name = "unidadporkilo10")
    private String unidadporkilo10;
    @Size(max = 15)
    @Column(name = "unidadporkilo20")
    private String unidadporkilo20;


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

    public String getUnidadmolde() {
        return unidadmolde;
    }

    public void setUnidadmolde(String unidadmolde) {
        this.unidadmolde = unidadmolde;
    }

    public String getMoldecompra() {
        return moldecompra;
    }

    public void setMoldecompra(String moldecompra) {
        this.moldecompra = moldecompra;
    }

    public String getConceptosellador() {
        return conceptosellador;
    }

    public void setConceptosellador(String conceptosellador) {
        this.conceptosellador = conceptosellador;
    }

    public String getConceptofibra() {
        return conceptofibra;
    }

    public void setConceptofibra(String conceptofibra) {
        this.conceptofibra = conceptofibra;
    }

    public String getCentimetrofibra() {
        return centimetrofibra;
    }

    public void setCentimetrofibra(String centimetrofibra) {
        this.centimetrofibra = centimetrofibra;
    }

    public String getDetalleCotizacioncol() {
        return detalleCotizacioncol;
    }

    public void setDetalleCotizacioncol(String detalleCotizacioncol) {
        this.detalleCotizacioncol = detalleCotizacioncol;
    }

    public String getPSIintegral() {
        return pSIintegral;
    }

    public void setPSIintegral(String pSIintegral) {
        this.pSIintegral = pSIintegral;
    }

    public String getPSIporcentaje() {
        return pSIporcentaje;
    }

    public void setPSIporcentaje(String pSIporcentaje) {
        this.pSIporcentaje = pSIporcentaje;
    }

    public String getDosificacion() {
        return dosificacion;
    }

    public void setDosificacion(String dosificacion) {
        this.dosificacion = dosificacion;
    }

    public String getUnidadporlitro10() {
        return unidadporlitro10;
    }

    public void setUnidadporlitro10(String unidadporlitro10) {
        this.unidadporlitro10 = unidadporlitro10;
    }

    public String getUnidadporlitro20() {
        return unidadporlitro20;
    }

    public void setUnidadporlitro20(String unidadporlitro20) {
        this.unidadporlitro20 = unidadporlitro20;
    }

    public String getUnidadporkilo10() {
        return unidadporkilo10;
    }

    public void setUnidadporkilo10(String unidadporkilo10) {
        this.unidadporkilo10 = unidadporkilo10;
    }

    public String getUnidadporkilo20() {
        return unidadporkilo20;
    }

    public void setUnidadporkilo20(String unidadporkilo20) {
        this.unidadporkilo20 = unidadporkilo20;
    }
    
}
