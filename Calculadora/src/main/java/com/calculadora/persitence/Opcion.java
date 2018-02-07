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
@Table(name = "opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
    , @NamedQuery(name = "Opcion.findByIdopcion", query = "SELECT o FROM Opcion o WHERE o.idopcion = :idopcion")
    , @NamedQuery(name = "Opcion.findByNombre", query = "SELECT o FROM Opcion o WHERE o.nombre = :nombre")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idopcion")
    private Integer idopcion;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "color_idcolor", referencedColumnName = "idcolor")
    @ManyToOne
    private Color colorIdcolor;
    @JoinColumn(name = "depende_color_color_iddepende_color_color", referencedColumnName = "iddepende_color_color")
    @ManyToOne
    private DependeColorColor dependeColorColorIddependeColorColor;
    @JoinColumn(name = "herramienta_idherramienta", referencedColumnName = "idherramienta")
    @ManyToOne
    private Herramienta herramientaIdherramienta;
    @JoinColumn(name = "molde_idmolde", referencedColumnName = "idmolde")
    @ManyToOne
    private Molde moldeIdmolde;
    @JoinColumn(name = "no_color_idno_color", referencedColumnName = "idno_color")
    @ManyToOne
    private NoColor noColorIdnoColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcionIdopcion")
    @JsonBackReference(value="opcionLineaList")
    private List<OpcionLinea> opcionLineaList;

    public Opcion() {
    }

    public Opcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public Integer getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColorIdcolor() {
        return colorIdcolor;
    }

    public void setColorIdcolor(Color colorIdcolor) {
        this.colorIdcolor = colorIdcolor;
    }

    public DependeColorColor getDependeColorColorIddependeColorColor() {
        return dependeColorColorIddependeColorColor;
    }

    public void setDependeColorColorIddependeColorColor(DependeColorColor dependeColorColorIddependeColorColor) {
        this.dependeColorColorIddependeColorColor = dependeColorColorIddependeColorColor;
    }

    public Herramienta getHerramientaIdherramienta() {
        return herramientaIdherramienta;
    }

    public void setHerramientaIdherramienta(Herramienta herramientaIdherramienta) {
        this.herramientaIdherramienta = herramientaIdherramienta;
    }

    public Molde getMoldeIdmolde() {
        return moldeIdmolde;
    }

    public void setMoldeIdmolde(Molde moldeIdmolde) {
        this.moldeIdmolde = moldeIdmolde;
    }

    public NoColor getNoColorIdnoColor() {
        return noColorIdnoColor;
    }

    public void setNoColorIdnoColor(NoColor noColorIdnoColor) {
        this.noColorIdnoColor = noColorIdnoColor;
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
        hash += (idopcion != null ? idopcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.idopcion == null && other.idopcion != null) || (this.idopcion != null && !this.idopcion.equals(other.idopcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.calculadora.persitence.Opcion[ idopcion=" + idopcion + " ]";
    }
    
}
