/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculadora.persitence;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yeisson alvarez
 */
@Entity
@Table(name = "depende_color_color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DependeColorColor.findAll", query = "SELECT d FROM DependeColorColor d")
    , @NamedQuery(name = "DependeColorColor.findByIddependeColorColor", query = "SELECT d FROM DependeColorColor d WHERE d.iddependeColorColor = :iddependeColorColor")})
public class DependeColorColor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddepende_color_color")
    private Integer iddependeColorColor;
    @OneToMany(mappedBy = "dependeColorColorIddependeColorColor")
    private List<Opcion> opcionList;
    @JoinColumn(name = "color_idcolor", referencedColumnName = "idcolor")
    @ManyToOne(optional = false)
    private Color colorIdcolor;
    @JoinColumn(name = "depende_color_iddepende_color", referencedColumnName = "iddepende_color")
    @ManyToOne(optional = false)
    private DependeColor dependeColorIddependeColor;

    public DependeColorColor() {
    }

    public DependeColorColor(Integer iddependeColorColor) {
        this.iddependeColorColor = iddependeColorColor;
    }

    public Integer getIddependeColorColor() {
        return iddependeColorColor;
    }

    public void setIddependeColorColor(Integer iddependeColorColor) {
        this.iddependeColorColor = iddependeColorColor;
    }

    @XmlTransient
    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
    }

    public Color getColorIdcolor() {
        return colorIdcolor;
    }

    public void setColorIdcolor(Color colorIdcolor) {
        this.colorIdcolor = colorIdcolor;
    }

    public DependeColor getDependeColorIddependeColor() {
        return dependeColorIddependeColor;
    }

    public void setDependeColorIddependeColor(DependeColor dependeColorIddependeColor) {
        this.dependeColorIddependeColor = dependeColorIddependeColor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddependeColorColor != null ? iddependeColorColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependeColorColor)) {
            return false;
        }
        DependeColorColor other = (DependeColorColor) object;
        if ((this.iddependeColorColor == null && other.iddependeColorColor != null) || (this.iddependeColorColor != null && !this.iddependeColorColor.equals(other.iddependeColorColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.DependeColorColor[ iddependeColorColor=" + iddependeColorColor + " ]";
    }
    
}
