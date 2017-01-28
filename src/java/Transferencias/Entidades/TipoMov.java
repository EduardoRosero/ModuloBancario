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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eduardo
 */
@Entity
@Table(name = "tipo_mov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMov.findAll", query = "SELECT t FROM TipoMov t"),
    @NamedQuery(name = "TipoMov.findByTipoId", query = "SELECT t FROM TipoMov t WHERE t.tipoId = :tipoId"),
    @NamedQuery(name = "TipoMov.findByTipoNom", query = "SELECT t FROM TipoMov t WHERE t.tipoNom = :tipoNom"),
    @NamedQuery(name = "TipoMov.findByTipoDesc", query = "SELECT t FROM TipoMov t WHERE t.tipoDesc = :tipoDesc")})
public class TipoMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_id")
    private Short tipoId;
    @Size(max = 20)
    @Column(name = "tipo_nom")
    private String tipoNom;
    @Size(max = 50)
    @Column(name = "tipo_desc")
    private String tipoDesc;
    @OneToMany(mappedBy = "tipoId")
    private List<Movimiento> movimientoList;

    public TipoMov() {
    }

    public TipoMov(Short tipoId) {
        this.tipoId = tipoId;
    }

    public Short getTipoId() {
        return tipoId;
    }

    public void setTipoId(Short tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoNom() {
        return tipoNom;
    }

    public void setTipoNom(String tipoNom) {
        this.tipoNom = tipoNom;
    }

    public String getTipoDesc() {
        return tipoDesc;
    }

    public void setTipoDesc(String tipoDesc) {
        this.tipoDesc = tipoDesc;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoId != null ? tipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMov)) {
            return false;
        }
        TipoMov other = (TipoMov) object;
        if ((this.tipoId == null && other.tipoId != null) || (this.tipoId != null && !this.tipoId.equals(other.tipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencias.Entidades.TipoMov[ tipoId=" + tipoId + " ]";
    }
    
}
