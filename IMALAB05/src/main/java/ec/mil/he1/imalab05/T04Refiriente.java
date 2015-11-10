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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "T04_REFIRIENTE")
@NamedQueries({
    @NamedQuery(name = "T04Refiriente.findAll", query = "SELECT t FROM T04Refiriente t")})
public class T04Refiriente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "DIR_CONSULTORIO")
    private String dirConsultorio;
    @Column(name = "PORCENTAJE_REFIRIENTE")
    private Double porcentajeRefiriente;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private T04Persona t04Persona;
    @OneToMany(mappedBy = "t04Refiriente", fetch = FetchType.LAZY)
    private List<T05DetalleFactura> t05DetalleFacturaList;

    public T04Refiriente() {
    }

    public T04Refiriente(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDirConsultorio() {
        return dirConsultorio;
    }

    public void setDirConsultorio(String dirConsultorio) {
        this.dirConsultorio = dirConsultorio;
    }

    public Double getPorcentajeRefiriente() {
        return porcentajeRefiriente;
    }

    public void setPorcentajeRefiriente(Double porcentajeRefiriente) {
        this.porcentajeRefiriente = porcentajeRefiriente;
    }

    public T04Persona getT04Persona() {
        return t04Persona;
    }

    public void setT04Persona(T04Persona t04Persona) {
        this.t04Persona = t04Persona;
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
        if (!(object instanceof T04Refiriente)) {
            return false;
        }
        T04Refiriente other = (T04Refiriente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T04Refiriente[ id=" + id + " ]";
    }
    
}
