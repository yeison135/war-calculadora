/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculadora.persitence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yeisson alvarez
 */
@Entity
@Table(name = "factura_cotizar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCotizar.findAll", query = "SELECT f FROM FacturaCotizar f")
    , @NamedQuery(name = "FacturaCotizar.findByIdfacturaCotizar", query = "SELECT f FROM FacturaCotizar f WHERE f.idfacturaCotizar = :idfacturaCotizar")
    , @NamedQuery(name = "FacturaCotizar.findByFecha", query = "SELECT f FROM FacturaCotizar f WHERE f.fecha = :fecha")})
public class FacturaCotizar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura_cotizar")
    private Integer idfacturaCotizar;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCotizarIdfacturaCotizar")
    @JsonBackReference(value="detalleCotizacionList")
    private List<DetalleCotizacion> detalleCotizacionList;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdcliente;

    public FacturaCotizar() {
    }

    public FacturaCotizar(Integer idfacturaCotizar) {
        this.idfacturaCotizar = idfacturaCotizar;
    }

    public Integer getIdfacturaCotizar() {
        return idfacturaCotizar;
    }

    public void setIdfacturaCotizar(Integer idfacturaCotizar) {
        this.idfacturaCotizar = idfacturaCotizar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<DetalleCotizacion> getDetalleCotizacionList() {
        return detalleCotizacionList;
    }

    public void setDetalleCotizacionList(List<DetalleCotizacion> detalleCotizacionList) {
        this.detalleCotizacionList = detalleCotizacionList;
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturaCotizar != null ? idfacturaCotizar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCotizar)) {
            return false;
        }
        FacturaCotizar other = (FacturaCotizar) object;
        if ((this.idfacturaCotizar == null && other.idfacturaCotizar != null) || (this.idfacturaCotizar != null && !this.idfacturaCotizar.equals(other.idfacturaCotizar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.FacturaCotizar[ idfacturaCotizar=" + idfacturaCotizar + " ]";
    }
    
}
