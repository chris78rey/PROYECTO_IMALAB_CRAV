/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.imalab05;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "T00_EMPRESA")
@NamedQueries({
    @NamedQuery(name = "T00Empresa.findAll", query = "SELECT t FROM T00Empresa t")})
public class T00Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "RUC")
    private String ruc;
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELF")
    private String telf;
    @Column(name = "REPRESENTANTE_LEGAL")
    private String representanteLegal;
    @Column(name = "ACTIVIDAD_DEDICADA")
    private String actividadDedicada;
    @OneToMany(mappedBy = "t00Empresa", fetch = FetchType.LAZY)
    private List<T05Factura> t05FacturaList;

    public T00Empresa() {
    }

    public T00Empresa(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getActividadDedicada() {
        return actividadDedicada;
    }

    public void setActividadDedicada(String actividadDedicada) {
        this.actividadDedicada = actividadDedicada;
    }

    public List<T05Factura> getT05FacturaList() {
        return t05FacturaList;
    }

    public void setT05FacturaList(List<T05Factura> t05FacturaList) {
        this.t05FacturaList = t05FacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T00Empresa)) {
            return false;
        }
        T00Empresa other = (T00Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T00Empresa[ id=" + id + " ]";
    }
    
}
