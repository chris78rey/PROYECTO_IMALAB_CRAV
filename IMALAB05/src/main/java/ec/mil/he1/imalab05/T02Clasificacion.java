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

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "T02_CLASIFICACION")
@NamedQueries({
    @NamedQuery(name = "T02Clasificacion.findAll", query = "SELECT t FROM T02Clasificacion t")})
public class T02Clasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t02Clasificacion", fetch = FetchType.LAZY)
    private List<T03Determinacion> t03DeterminacionList;
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private T01Grupos t01Grupos;

    public T02Clasificacion() {
    }

    public T02Clasificacion(BigDecimal id) {
        this.id = id;
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

    public List<T03Determinacion> getT03DeterminacionList() {
        return t03DeterminacionList;
    }

    public void setT03DeterminacionList(List<T03Determinacion> t03DeterminacionList) {
        this.t03DeterminacionList = t03DeterminacionList;
    }

    public T01Grupos getT01Grupos() {
        return t01Grupos;
    }

    public void setT01Grupos(T01Grupos t01Grupos) {
        this.t01Grupos = t01Grupos;
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
        if (!(object instanceof T02Clasificacion)) {
            return false;
        }
        T02Clasificacion other = (T02Clasificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T02Clasificacion[ id=" + id + " ]";
    }
    
}
