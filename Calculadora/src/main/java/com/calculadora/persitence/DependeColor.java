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
@Table(name = "depende_color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DependeColor.findAll", query = "SELECT d FROM DependeColor d")
    , @NamedQuery(name = "DependeColor.findByIddependeColor", query = "SELECT d FROM DependeColor d WHERE d.iddependeColor = :iddependeColor")
    , @NamedQuery(name = "DependeColor.findByNombre", query = "SELECT d FROM DependeColor d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DependeColor.findByDosificacion", query = "SELECT d FROM DependeColor d WHERE d.dosificacion = :dosificacion")})
public class DependeColor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddepende_color")
    private Integer iddependeColor;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "dosificacion")
    private String dosificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependeColorIddependeColor")
    @JsonBackReference(value="dependeColorColorList")
    private List<DependeColorColor> dependeColorColorList;

    public DependeColor() {
    }

    public DependeColor(Integer iddependeColor) {
        this.iddependeColor = iddependeColor;
    }

    public Integer getIddependeColor() {
        return iddependeColor;
    }

    public void setIddependeColor(Integer iddependeColor) {
        this.iddependeColor = iddependeColor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosificacion() {
        return dosificacion;
    }

    public void setDosificacion(String dosificacion) {
        this.dosificacion = dosificacion;
    }

    @XmlTransient
    public List<DependeColorColor> getDependeColorColorList() {
        return dependeColorColorList;
    }

    public void setDependeColorColorList(List<DependeColorColor> dependeColorColorList) {
        this.dependeColorColorList = dependeColorColorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddependeColor != null ? iddependeColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependeColor)) {
            return false;
        }
        DependeColor other = (DependeColor) object;
        if ((this.iddependeColor == null && other.iddependeColor != null) || (this.iddependeColor != null && !this.iddependeColor.equals(other.iddependeColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.DependeColor[ iddependeColor=" + iddependeColor + " ]";
    }
    
}
