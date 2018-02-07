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
@Table(name = "linea_de_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaDeTrabajo.findAll", query = "SELECT l FROM LineaDeTrabajo l")
    , @NamedQuery(name = "LineaDeTrabajo.findByIdlineaDeTrabajo", query = "SELECT l FROM LineaDeTrabajo l WHERE l.idlineaDeTrabajo = :idlineaDeTrabajo")
    , @NamedQuery(name = "LineaDeTrabajo.findByDescripcion", query = "SELECT l FROM LineaDeTrabajo l WHERE l.descripcion = :descripcion")})
public class LineaDeTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlinea_de_trabajo")
    private Integer idlineaDeTrabajo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaDeTrabajoIdlineaDeTrabajo")
    @JsonBackReference(value="opcionLineaList")
    private List<OpcionLinea> opcionLineaList;

    public LineaDeTrabajo() {
    }

    public LineaDeTrabajo(Integer idlineaDeTrabajo) {
        this.idlineaDeTrabajo = idlineaDeTrabajo;
    }

    public Integer getIdlineaDeTrabajo() {
        return idlineaDeTrabajo;
    }

    public void setIdlineaDeTrabajo(Integer idlineaDeTrabajo) {
        this.idlineaDeTrabajo = idlineaDeTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<OpcionLinea> getOpcionLineaList() {
        return opcionLineaList;
    }

    public void setOpcionLineaList(List<OpcionLinea> opcionLineaList) {
        this.opcionLineaList = opcionLineaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlineaDeTrabajo != null ? idlineaDeTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaDeTrabajo)) {
            return false;
        }
        LineaDeTrabajo other = (LineaDeTrabajo) object;
        if ((this.idlineaDeTrabajo == null && other.idlineaDeTrabajo != null) || (this.idlineaDeTrabajo != null && !this.idlineaDeTrabajo.equals(other.idlineaDeTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.LineaDeTrabajo[ idlineaDeTrabajo=" + idlineaDeTrabajo + " ]";
    }
    
}
