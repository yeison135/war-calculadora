/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculadora.persitence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yeisson alvarez
 */
@Entity
@Table(name = "opcion_linea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionLinea.findAll", query = "SELECT o FROM OpcionLinea o")
    , @NamedQuery(name = "OpcionLinea.findByIdopcionLinea", query = "SELECT o FROM OpcionLinea o WHERE o.idopcionLinea = :idopcionLinea")
    , @NamedQuery(name = "OpcionLinea.findByNombre", query = "SELECT o FROM OpcionLinea o WHERE o.nombre = :nombre")})
public class OpcionLinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idopcion_linea")
    private Integer idopcionLinea;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcionLineaIdopcionLinea")
    @JsonBackReference(value="detalleCotizacionList")
    private List<DetalleCotizacion> detalleCotizacionList;
    @JoinColumn(name = "linea_de_trabajo_idlinea_de_trabajo", referencedColumnName = "idlinea_de_trabajo")
    @ManyToOne(optional = false)
    private LineaDeTrabajo lineaDeTrabajoIdlineaDeTrabajo;
    @JoinColumn(name = "opcion_idopcion", referencedColumnName = "idopcion")
    @ManyToOne(optional = false)
    private Opcion opcionIdopcion;

    public OpcionLinea() {
    }

    public OpcionLinea(Integer idopcionLinea) {
        this.idopcionLinea = idopcionLinea;
    }

    public Integer getIdopcionLinea() {
        return idopcionLinea;
    }

    public void setIdopcionLinea(Integer idopcionLinea) {
        this.idopcionLinea = idopcionLinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<DetalleCotizacion> getDetalleCotizacionList() {
        return detalleCotizacionList;
    }

    public void setDetalleCotizacionList(List<DetalleCotizacion> detalleCotizacionList) {
        this.detalleCotizacionList = detalleCotizacionList;
    }

    public LineaDeTrabajo getLineaDeTrabajoIdlineaDeTrabajo() {
        return lineaDeTrabajoIdlineaDeTrabajo;
    }

    public void setLineaDeTrabajoIdlineaDeTrabajo(LineaDeTrabajo lineaDeTrabajoIdlineaDeTrabajo) {
        this.lineaDeTrabajoIdlineaDeTrabajo = lineaDeTrabajoIdlineaDeTrabajo;
    }

    public Opcion getOpcionIdopcion() {
        return opcionIdopcion;
    }

    public void setOpcionIdopcion(Opcion opcionIdopcion) {
        this.opcionIdopcion = opcionIdopcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idopcionLinea != null ? idopcionLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionLinea)) {
            return false;
        }
        OpcionLinea other = (OpcionLinea) object;
        if ((this.idopcionLinea == null && other.idopcionLinea != null) || (this.idopcionLinea != null && !this.idopcionLinea.equals(other.idopcionLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.OpcionLinea[ idopcionLinea=" + idopcionLinea + " ]";
    }
    
}
