/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.imalab05;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "T04_PERSONA")
@NamedQueries({
    @NamedQuery(name = "T04Persona.findAll", query = "SELECT t FROM T04Persona t")})
public class T04Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CC_RUC")
    private String ccRuc;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "EMAIL")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "t04Persona", fetch = FetchType.LAZY)
    private T04Paciente t04Paciente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "t04Persona", fetch = FetchType.LAZY)
    private T04Refiriente t04Refiriente;

    public T04Persona() {
    }

    public T04Persona(BigDecimal id) {
        this.id = id;
    }

    public T04Persona(BigDecimal id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCcRuc() {
        return ccRuc;
    }

    public void setCcRuc(String ccRuc) {
        this.ccRuc = ccRuc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public T04Paciente getT04Paciente() {
        return t04Paciente;
    }

    public void setT04Paciente(T04Paciente t04Paciente) {
        this.t04Paciente = t04Paciente;
    }

    public T04Refiriente getT04Refiriente() {
        return t04Refiriente;
    }

    public void setT04Refiriente(T04Refiriente t04Refiriente) {
        this.t04Refiriente = t04Refiriente;
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
        if (!(object instanceof T04Persona)) {
            return false;
        }
        T04Persona other = (T04Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.imalab05.T04Persona[ id=" + id + " ]";
    }
    
}
