/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moreno.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristina
 */
@Entity
@Table(name = "MOVIES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m order by m.id ASC"),
    @NamedQuery(name = "Movies.findById", query = "SELECT m FROM Movies m WHERE m.id = :id"),
    @NamedQuery(name = "Movies.findByTitulo", query = "SELECT m FROM Movies m WHERE m.titulo like :titulo"),
    @NamedQuery(name = "Movies.findByGenero", query = "SELECT m FROM Movies m WHERE m.genero like :genero"),
    @NamedQuery(name = "Movies.findByValoracion", query = "SELECT m FROM Movies m WHERE m.valoracion = :valoracion"),
    @NamedQuery(name = "Movies.findByVisto", query = "SELECT m FROM Movies m WHERE m.visto = :visto and m.formato like :formato"),
    @NamedQuery(name = "Movies.findByFormato", query = "SELECT m FROM Movies m WHERE m.formato like :formato")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "pidGen", sequenceName = "PID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "pidGen")
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "VALORACION")
    private Integer valoracion;
    @Column(name = "VISTO")
    private Boolean visto;
    @Size(max = 20)
    @Column(name = "FORMATO")
    private String formato;

    public Movies() {
    }

    public Movies(Integer id) {
        this.id = id;
    }

    public Movies(Integer id, String titulo, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Movies(String titulo, String genero, Integer valoracion, Boolean visto, String formato) {
        this.titulo = titulo;
        this.genero = genero;
        this.valoracion = valoracion;
        this.visto = visto;
        this.formato = formato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
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
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.moreno.models.Movies[ id=" + id + " ]";
    }

}
