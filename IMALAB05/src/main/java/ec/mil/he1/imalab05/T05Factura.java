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
@Table(name = "T05_FACTURA")
@NamedQueries({
    @NamedQuery(name = "T05Factura.findAll", query = "SELECT t FROM T05Factura t")})
public class T05Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SERIE_FACTURA")
    private String serieFactura;
    @Column(name = "NUMERO_FACTURA")
    private String numeroFactura;
    @Basic(optional = false)
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private T00Empresa t00Empresa;
    @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private T04Paciente t04Paciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t05Factura", fetch = FetchType.LAZY)
    private List<T05DetalleFactura> t05DetalleFacturaList;

    public T05Factura() {
    }

    public T05Factura(BigDecimal id) {
        this.id = id;
    }

    public T05Factura(BigDecimal id, Date fechaFactura) {
        this.id = id;
        this.fechaFactura = fechaFactura;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public T00Empresa getT00Empresa() {
        return t00Empresa;
    }

    public void setT00Empresa(T00Empresa t00Empresa) {
        this.t00Empresa = t00Empresa;
    }

    public T04Paciente getT04Paciente() {
        return t04Paciente;
    }

    public void setT04Paciente(T04Paciente t04Paciente) {
        this.t04Paciente = t04Paciente;
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
        if (!(object instanceof T05Factura)) {
            return false;
        }
        T05Factura other = (T05Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T05Factura[ id=" + id + " ]";
    }
    
}
