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
@Table(name = "no_color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NoColor.findAll", query = "SELECT n FROM NoColor n")
    , @NamedQuery(name = "NoColor.findByIdnoColor", query = "SELECT n FROM NoColor n WHERE n.idnoColor = :idnoColor")
    , @NamedQuery(name = "NoColor.findByNombre", query = "SELECT n FROM NoColor n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "NoColor.findByDosificacion", query = "SELECT n FROM NoColor n WHERE n.dosificacion = :dosificacion")})
public class NoColor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idno_color")
    private Integer idnoColor;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "dosificacion")
    private String dosificacion;
    @OneToMany(mappedBy = "noColorIdnoColor")
    @JsonBackReference(value="opcionList")
    private List<Opcion> opcionList;

    public NoColor() {
    }

    public NoColor(Integer idnoColor) {
        this.idnoColor = idnoColor;
    }

    public Integer getIdnoColor() {
        return idnoColor;
    }

    public void setIdnoColor(Integer idnoColor) {
        this.idnoColor = idnoColor;
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
    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnoColor != null ? idnoColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoColor)) {
            return false;
        }
        NoColor other = (NoColor) object;
        if ((this.idnoColor == null && other.idnoColor != null) || (this.idnoColor != null && !this.idnoColor.equals(other.idnoColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.NoColor[ idnoColor=" + idnoColor + " ]";
    }
    
}
