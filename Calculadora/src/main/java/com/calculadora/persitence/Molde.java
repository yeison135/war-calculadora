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
@Table(name = "molde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Molde.findAll", query = "SELECT m FROM Molde m")
    , @NamedQuery(name = "Molde.findByIdmolde", query = "SELECT m FROM Molde m WHERE m.idmolde = :idmolde")
    , @NamedQuery(name = "Molde.findByCategoria", query = "SELECT m FROM Molde m WHERE m.categoria = :categoria")
    , @NamedQuery(name = "Molde.findByDescripcion", query = "SELECT m FROM Molde m WHERE m.descripcion = :descripcion")})
public class Molde implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmolde")
    private Integer idmolde;
    @Size(max = 30)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "moldeIdmolde")
    @JsonBackReference(value="opcionList")
    private List<Opcion> opcionList;

    public Molde() {
    }

    public Molde(Integer idmolde) {
        this.idmolde = idmolde;
    }

    public Integer getIdmolde() {
        return idmolde;
    }

    public void setIdmolde(Integer idmolde) {
        this.idmolde = idmolde;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        hash += (idmolde != null ? idmolde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Molde)) {
            return false;
        }
        Molde other = (Molde) object;
        if ((this.idmolde == null && other.idmolde != null) || (this.idmolde != null && !this.idmolde.equals(other.idmolde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.Molde[ idmolde=" + idmolde + " ]";
    }
    
}
