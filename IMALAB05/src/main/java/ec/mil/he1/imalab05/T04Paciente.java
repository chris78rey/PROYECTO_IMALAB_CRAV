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
@Table(name = "T04_PACIENTE")
@NamedQueries({
    @NamedQuery(name = "T04Paciente.findAll", query = "SELECT t FROM T04Paciente t")})
public class T04Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private T04Persona t04Persona;
    @OneToMany(mappedBy = "t04Paciente", fetch = FetchType.LAZY)
    private List<T05Factura> t05FacturaList;

    public T04Paciente() {
    }

    public T04Paciente(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public T04Persona getT04Persona() {
        return t04Persona;
    }

    public void setT04Persona(T04Persona t04Persona) {
        this.t04Persona = t04Persona;
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
        if (!(object instanceof T04Paciente)) {
            return false;
        }
        T04Paciente other = (T04Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T04Paciente[ id=" + id + " ]";
    }
    
}
