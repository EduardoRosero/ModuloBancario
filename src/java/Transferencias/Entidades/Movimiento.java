/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transferencias.Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eduardo
 */
@Entity
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByMovId", query = "SELECT m FROM Movimiento m WHERE m.movId = :movId"),
    @NamedQuery(name = "Movimiento.findByMovFecha", query = "SELECT m FROM Movimiento m WHERE m.movFecha = :movFecha"),
    @NamedQuery(name = "Movimiento.findByMovHora", query = "SELECT m FROM Movimiento m WHERE m.movHora = :movHora"),
    @NamedQuery(name = "Movimiento.findByMovValor", query = "SELECT m FROM Movimiento m WHERE m.movValor = :movValor"),
    @NamedQuery(name = "Movimiento.findByMovOrigen", query = "SELECT m FROM Movimiento m WHERE m.movOrigen = :movOrigen"),
    @NamedQuery(name = "Movimiento.findByMovDestino", query = "SELECT m FROM Movimiento m WHERE m.movDestino = :movDestino")})
public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mov_id")
    private Long movId;
    @Column(name = "mov_fecha")
    @Temporal(TemporalType.DATE)
    private Date movFecha;
    @Column(name = "mov_hora")
    @Temporal(TemporalType.TIME)
    private Date movHora;
    @Column(name = "mov_valor")
    private BigInteger movValor;
    @Size(max = 10)
    @Column(name = "mov_origen")
    private String movOrigen;
    @Size(max = 10)
    @Column(name = "mov_destino")
    private String movDestino;
    @JoinColumn(name = "tipo_id", referencedColumnName = "tipo_id")
    @ManyToOne
    private TipoMov tipoId;
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    @ManyToOne
    private Cuenta cuentaId;

    public Movimiento() {
    }

    public Movimiento(Long movId) {
        this.movId = movId;
    }

    public Long getMovId() {
        return movId;
    }

    public void setMovId(Long movId) {
        this.movId = movId;
    }

    public Date getMovFecha() {
        return movFecha;
    }

    public void setMovFecha(Date movFecha) {
        this.movFecha = movFecha;
    }

    public Date getMovHora() {
        return movHora;
    }

    public void setMovHora(Date movHora) {
        this.movHora = movHora;
    }

    public BigInteger getMovValor() {
        return movValor;
    }

    public void setMovValor(BigInteger movValor) {
        this.movValor = movValor;
    }

    public String getMovOrigen() {
        return movOrigen;
    }

    public void setMovOrigen(String movOrigen) {
        this.movOrigen = movOrigen;
    }

    public String getMovDestino() {
        return movDestino;
    }

    public void setMovDestino(String movDestino) {
        this.movDestino = movDestino;
    }

    public TipoMov getTipoId() {
        return tipoId;
    }

    public void setTipoId(TipoMov tipoId) {
        this.tipoId = tipoId;
    }

    public Cuenta getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Cuenta cuentaId) {
        this.cuentaId = cuentaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movId != null ? movId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.movId == null && other.movId != null) || (this.movId != null && !this.movId.equals(other.movId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencias.Entidades.Movimiento[ movId=" + movId + " ]";
    }
    
}
