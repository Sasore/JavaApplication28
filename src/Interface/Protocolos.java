/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author soare_000
 */
@Entity
@Table(name = "protocolos", catalog = "oiprotocolo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Protocolos.findAll", query = "SELECT p FROM Protocolos p"),
    @NamedQuery(name = "Protocolos.findById", query = "SELECT p FROM Protocolos p WHERE p.id = :id"),
    @NamedQuery(name = "Protocolos.findByProtocolo", query = "SELECT p FROM Protocolos p WHERE p.protocolo = :protocolo"),
    @NamedQuery(name = "Protocolos.findByData", query = "SELECT p FROM Protocolos p WHERE p.data = :data"),
    @NamedQuery(name = "Protocolos.findByHora", query = "SELECT p FROM Protocolos p WHERE p.hora = :hora"),
    @NamedQuery(name = "Protocolos.findByAssunto", query = "SELECT p FROM Protocolos p WHERE p.assunto = :assunto"),
    @NamedQuery(name = "Protocolos.findByDescricao", query = "SELECT p FROM Protocolos p WHERE p.descricao = :descricao")})
public class Protocolos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "protocolo")
    private String protocolo;
    @Column(name = "data")
    private String data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "descricao")
    private String descricao;

    public Protocolos() {
    }

    public Protocolos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        String oldProtocolo = this.protocolo;
        this.protocolo = protocolo;
        changeSupport.firePropertyChange("protocolo", oldProtocolo, protocolo);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        String oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        String oldAssunto = this.assunto;
        this.assunto = assunto;
        changeSupport.firePropertyChange("assunto", oldAssunto, assunto);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
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
        if (!(object instanceof Protocolos)) {
            return false;
        }
        Protocolos other = (Protocolos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interface.Protocolos[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
