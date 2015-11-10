/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.imalab05;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "T03_DETERMINACION")
@NamedQueries({
    @NamedQuery(name = "T03Determinacion.findAll", query = "SELECT t FROM T03Determinacion t")})
public class T03Determinacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA_DEF_PRECIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDefPrecio;
    @Column(name = "CON_DESCUENTO")
    private Double conDescuento;
    @Column(name = "SIN_DESCUENTO")
    private Double sinDescuento;
    @Basic(optional = false)
    @Column(name = "IVA")
    private double iva;
    @JoinColumn(name = "ID_CLASIFICACION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private T02Clasificacion t02Clasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t03Determinacion", fetch = FetchType.LAZY)
    private List<T05DetalleFactura> t05DetalleFacturaList;

    public T03Determinacion() {
    }

    public T03Determinacion(BigDecimal id) {
        this.id = id;
    }

    public T03Determinacion(BigDecimal id, String descripcion, Date fechaDefPrecio, double iva) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaDefPrecio = fechaDefPrecio;
        this.iva = iva;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDefPrecio() {
        return fechaDefPrecio;
    }

    public void setFechaDefPrecio(Date fechaDefPrecio) {
        this.fechaDefPrecio = fechaDefPrecio;
    }

    public Double getConDescuento() {
        return conDescuento;
    }

    public void setConDescuento(Double conDescuento) {
        this.conDescuento = conDescuento;
    }

    public Double getSinDescuento() {
        return sinDescuento;
    }

    public void setSinDescuento(Double sinDescuento) {
        this.sinDescuento = sinDescuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public T02Clasificacion getT02Clasificacion() {
        return t02Clasificacion;
    }

    public void setT02Clasificacion(T02Clasificacion t02Clasificacion) {
        this.t02Clasificacion = t02Clasificacion;
    }

    public List<T05DetalleFactura> getT05DetalleFacturaList() {
        return t05DetalleFacturaList;
    }

    public void setT05DetalleFacturaList(List<T05DetalleFactura> t05DetalleFacturaList) {
        this.t05DetalleFacturaList = t05DetalleFacturaList;
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
        if (!(object instanceof T03Determinacion)) {
            return false;
        }
        T03Determinacion other = (T03Determinacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T03Determinacion[ id=" + id + " ]";
    }
    
}
