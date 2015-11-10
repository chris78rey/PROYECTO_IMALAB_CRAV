/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.imalab05;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "T05_DETALLE_FACTURA")
@NamedQueries({
    @NamedQuery(name = "T05DetalleFactura.findAll", query = "SELECT t FROM T05DetalleFactura t")})
public class T05DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private double valor;
    @JoinColumn(name = "ID_DETERMINACION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private T03Determinacion t03Determinacion;
    @JoinColumn(name = "ID_REFIRIENTE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private T04Refiriente t04Refiriente;
    @JoinColumn(name = "ID_FACURA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private T05Factura t05Factura;

    public T05DetalleFactura() {
    }

    public T05DetalleFactura(BigDecimal id) {
        this.id = id;
    }

    public T05DetalleFactura(BigDecimal id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public T03Determinacion getT03Determinacion() {
        return t03Determinacion;
    }

    public void setT03Determinacion(T03Determinacion t03Determinacion) {
        this.t03Determinacion = t03Determinacion;
    }

    public T04Refiriente getT04Refiriente() {
        return t04Refiriente;
    }

    public void setT04Refiriente(T04Refiriente t04Refiriente) {
        this.t04Refiriente = t04Refiriente;
    }

    public T05Factura getT05Factura() {
        return t05Factura;
    }

    public void setT05Factura(T05Factura t05Factura) {
        this.t05Factura = t05Factura;
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
        if (!(object instanceof T05DetalleFactura)) {
            return false;
        }
        T05DetalleFactura other = (T05DetalleFactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T05DetalleFactura[ id=" + id + " ]";
    }
    
}
