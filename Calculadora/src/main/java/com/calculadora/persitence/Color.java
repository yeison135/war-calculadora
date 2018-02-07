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
@Table(name = "color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c")
    , @NamedQuery(name = "Color.findByIdcolor", query = "SELECT c FROM Color c WHERE c.idcolor = :idcolor")
    , @NamedQuery(name = "Color.findByCategoria", query = "SELECT c FROM Color c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "Color.findByNombre", query = "SELECT c FROM Color c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Color.findByEspecificacion", query = "SELECT c FROM Color c WHERE c.especificacion = :especificacion")
    , @NamedQuery(name = "Color.findByCodigoHexadecimal", query = "SELECT c FROM Color c WHERE c.codigoHexadecimal = :codigoHexadecimal")
    , @NamedQuery(name = "Color.findByDosificacion", query = "SELECT c FROM Color c WHERE c.dosificacion = :dosificacion")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcolor")
    private Integer idcolor;
    @Size(max = 30)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "especificacion")
    private String especificacion;
    @Size(max = 20)
    @Column(name = "codigo_hexadecimal")
    private String codigoHexadecimal;
    @Size(max = 20)
    @Column(name = "dosificacion")
    private String dosificacion;
    @OneToMany(mappedBy = "colorIdcolor")
    @JsonBackReference(value="opcionList")
    private List<Opcion> opcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorIdcolor")
    @JsonBackReference(value="dependeColorColorList")
    private List<DependeColorColor> dependeColorColorList;

    public Color() {
    }

    public Color(Integer idcolor) {
        this.idcolor = idcolor;
    }

    public Integer getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(Integer idcolor) {
        this.idcolor = idcolor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public String getCodigoHexadecimal() {
        return codigoHexadecimal;
    }

    public void setCodigoHexadecimal(String codigoHexadecimal) {
        this.codigoHexadecimal = codigoHexadecimal;
    }

    public String getDosificacion() {
        return dosificacion;
    }

    public void setDosificacion(String dosificacion) {
        this.dosificacion = dosificacion;
    }

    @XmlTransient
    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
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
        hash += (idcolor != null ? idcolor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.idcolor == null && other.idcolor != null) || (this.idcolor != null && !this.idcolor.equals(other.idcolor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.Color[ idcolor=" + idcolor + " ]";
    }
    
}
