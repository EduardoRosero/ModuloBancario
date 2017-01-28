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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuario.findByUsuarioCi", query = "SELECT u FROM Usuario u WHERE u.usuarioCi = :usuarioCi"),
    @NamedQuery(name = "Usuario.findByUsuarioNom1", query = "SELECT u FROM Usuario u WHERE u.usuarioNom1 = :usuarioNom1"),
    @NamedQuery(name = "Usuario.findByUsuarioNom2", query = "SELECT u FROM Usuario u WHERE u.usuarioNom2 = :usuarioNom2"),
    @NamedQuery(name = "Usuario.findByUsuarioApe1", query = "SELECT u FROM Usuario u WHERE u.usuarioApe1 = :usuarioApe1"),
    @NamedQuery(name = "Usuario.findByUsuarioApe2", query = "SELECT u FROM Usuario u WHERE u.usuarioApe2 = :usuarioApe2"),
    @NamedQuery(name = "Usuario.findByUsuarioTelf", query = "SELECT u FROM Usuario u WHERE u.usuarioTelf = :usuarioTelf"),
    @NamedQuery(name = "Usuario.findByUsuarioDir", query = "SELECT u FROM Usuario u WHERE u.usuarioDir = :usuarioDir"),
    @NamedQuery(name = "Usuario.findByUsuarioSexo", query = "SELECT u FROM Usuario u WHERE u.usuarioSexo = :usuarioSexo"),
    @NamedQuery(name = "Usuario.findByUsuarioEdad", query = "SELECT u FROM Usuario u WHERE u.usuarioEdad = :usuarioEdad"),
    @NamedQuery(name = "Usuario.findByUsuarioEmail", query = "SELECT u FROM Usuario u WHERE u.usuarioEmail = :usuarioEmail"),
    @NamedQuery(name = "Usuario.findByUsuarioPass", query = "SELECT u FROM Usuario u WHERE u.usuarioPass = :usuarioPass"),
    @NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u WHERE u.usuarioEmail = :usuarioEmail"),
    @NamedQuery(name = "Usuario.findByUsuarioTipo", query = "SELECT u FROM Usuario u WHERE u.usuarioTipo = :usuarioTipo")})

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Short usuarioId;
    @Size(max = 10)
    @Column(name = "usuario_ci")
    private String usuarioCi;
    @Size(max = 15)
    @Column(name = "usuario_nom1")
    private String usuarioNom1;
    @Size(max = 15)
    @Column(name = "usuario_nom2")
    private String usuarioNom2;
    @Size(max = 15)
    @Column(name = "usuario_ape1")
    private String usuarioApe1;
    @Size(max = 15)
    @Column(name = "usuario_ape2")
    private String usuarioApe2;
    @Size(max = 10)
    @Column(name = "usuario_telf")
    private String usuarioTelf;
    @Size(max = 25)
    @Column(name = "usuario_dir")
    private String usuarioDir;
    @Size(max = 10)
    @Column(name = "usuario_sexo")
    private String usuarioSexo;
    @Column(name = "usuario_edad")
    private Short usuarioEdad;
    @Size(max = 40)
    @Column(name = "usuario_email")
    private String usuarioEmail;
    @Size(max = 20)
    @Column(name = "usuario_pass")
    private String usuarioPass;
    @Column(name = "usuario_tipo")
    private Boolean usuarioTipo;
    @JoinColumn(name = "entidad_id", referencedColumnName = "entidad_id")
    @ManyToOne
    private Entidad entidadId;
    @OneToMany(mappedBy = "usuarioId")
    private List<Cuenta> cuentaList;

    public Usuario() {
    }

    public Usuario(Short usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Short getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Short usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioCi() {
        return usuarioCi;
    }

    public void setUsuarioCi(String usuarioCi) {
        this.usuarioCi = usuarioCi;
    }

    public String getUsuarioNom1() {
        return usuarioNom1;
    }

    public void setUsuarioNom1(String usuarioNom1) {
        this.usuarioNom1 = usuarioNom1;
    }

    public String getUsuarioNom2() {
        return usuarioNom2;
    }

    public void setUsuarioNom2(String usuarioNom2) {
        this.usuarioNom2 = usuarioNom2;
    }

    public String getUsuarioApe1() {
        return usuarioApe1;
    }

    public void setUsuarioApe1(String usuarioApe1) {
        this.usuarioApe1 = usuarioApe1;
    }

    public String getUsuarioApe2() {
        return usuarioApe2;
    }

    public void setUsuarioApe2(String usuarioApe2) {
        this.usuarioApe2 = usuarioApe2;
    }

    public String getUsuarioTelf() {
        return usuarioTelf;
    }

    public void setUsuarioTelf(String usuarioTelf) {
        this.usuarioTelf = usuarioTelf;
    }

    public String getUsuarioDir() {
        return usuarioDir;
    }

    public void setUsuarioDir(String usuarioDir) {
        this.usuarioDir = usuarioDir;
    }

    public String getUsuarioSexo() {
        return usuarioSexo;
    }

    public void setUsuarioSexo(String usuarioSexo) {
        this.usuarioSexo = usuarioSexo;
    }

    public Short getUsuarioEdad() {
        return usuarioEdad;
    }

    public void setUsuarioEdad(Short usuarioEdad) {
        this.usuarioEdad = usuarioEdad;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioPass() {
        return usuarioPass;
    }

    public void setUsuarioPass(String usuarioPass) {
        this.usuarioPass = usuarioPass;
    }

    public Boolean getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(Boolean usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public Entidad getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Entidad entidadId) {
        this.entidadId = entidadId;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencias.Entidades.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
