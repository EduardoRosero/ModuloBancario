/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transferencias.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eduardo
 */
@Entity
@Table(name = "entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e"),
    @NamedQuery(name = "Entidad.findByEntidadId", query = "SELECT e FROM Entidad e WHERE e.entidadId = :entidadId"),
    @NamedQuery(name = "Entidad.findByEntidadNombre", query = "SELECT e FROM Entidad e WHERE e.entidadNombre = :entidadNombre"),
    @NamedQuery(name = "Entidad.findByEntidadDir", query = "SELECT e FROM Entidad e WHERE e.entidadDir = :entidadDir"),
    @NamedQuery(name = "Entidad.findByRuc", query = "SELECT e FROM Entidad e WHERE e.ruc = :ruc")})
public class Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entidad_id")
    private Short entidadId;
    @Size(max = 20)
    @Column(name = "entidad_nombre")
    private String entidadNombre;
    @Size(max = 20)
    @Column(name = "entidad_dir")
    private String entidadDir;
    @Size(max = 13)
    @Column(name = "ruc")
    private String ruc;
    @OneToMany(mappedBy = "entidadId")
    private List<Usuario> usuarioList;

    public Entidad() {
    }

    public Entidad(Short entidadId) {
        this.entidadId = entidadId;
    }

    public Short getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Short entidadId) {
        this.entidadId = entidadId;
    }

    public String getEntidadNombre() {
        return entidadNombre;
    }

    public void setEntidadNombre(String entidadNombre) {
        this.entidadNombre = entidadNombre;
    }

    public String getEntidadDir() {
        return entidadDir;
    }

    public void setEntidadDir(String entidadDir) {
        this.entidadDir = entidadDir;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entidadId != null ? entidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.entidadId == null && other.entidadId != null) || (this.entidadId != null && !this.entidadId.equals(other.entidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencias.Entidades.Entidad[ entidadId=" + entidadId + " ]";
    }
    
}
