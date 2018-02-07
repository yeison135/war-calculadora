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
@Table(name = "herramienta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Herramienta.findAll", query = "SELECT h FROM Herramienta h")
    , @NamedQuery(name = "Herramienta.findByIdherramienta", query = "SELECT h FROM Herramienta h WHERE h.idherramienta = :idherramienta")
    , @NamedQuery(name = "Herramienta.findByDescripcion", query = "SELECT h FROM Herramienta h WHERE h.descripcion = :descripcion")})
public class Herramienta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idherramienta")
    private Integer idherramienta;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "herramientaIdherramienta")
    @JsonBackReference(value="opcionList")
    private List<Opcion> opcionList;

    public Herramienta() {
    }

    public Herramienta(Integer idherramienta) {
        this.idherramienta = idherramienta;
    }

    public Integer getIdherramienta() {
        return idherramienta;
    }

    public void setIdherramienta(Integer idherramienta) {
        this.idherramienta = idherramienta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idherramienta != null ? idherramienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Herramienta)) {
            return false;
        }
        Herramienta other = (Herramienta) object;
        if ((this.idherramienta == null && other.idherramienta != null) || (this.idherramienta != null && !this.idherramienta.equals(other.idherramienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.Herramienta[ idherramienta=" + idherramienta + " ]";
    }
    
}
