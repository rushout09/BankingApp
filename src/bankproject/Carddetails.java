/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rushabh
 */
@Entity
@Table(name = "CARDDETAILS", catalog = "", schema = "RUSHABH")
@NamedQueries({
    @NamedQuery(name = "Carddetails.findAll", query = "SELECT c FROM Carddetails c")
    , @NamedQuery(name = "Carddetails.findByCardNo", query = "SELECT c FROM Carddetails c WHERE c.cardNo = :cardNo")
    , @NamedQuery(name = "Carddetails.findByCardType", query = "SELECT c FROM Carddetails c WHERE c.cardType = :cardType")
    , @NamedQuery(name = "Carddetails.findByCid", query = "SELECT c FROM Carddetails c WHERE c.cid = :cid")})
public class Carddetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CARD_NO")
    private String cardNo;
    @Column(name = "CARD_TYPE")
    private String cardType;
    @Column(name = "CID")
    private Integer cid;

    public Carddetails() {
    }

    public Carddetails(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        String oldCardNo = this.cardNo;
        this.cardNo = cardNo;
        changeSupport.firePropertyChange("cardNo", oldCardNo, cardNo);
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        String oldCardType = this.cardType;
        this.cardType = cardType;
        changeSupport.firePropertyChange("cardType", oldCardType, cardType);
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        Integer oldCid = this.cid;
        this.cid = cid;
        changeSupport.firePropertyChange("cid", oldCid, cid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardNo != null ? cardNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carddetails)) {
            return false;
        }
        Carddetails other = (Carddetails) object;
        if ((this.cardNo == null && other.cardNo != null) || (this.cardNo != null && !this.cardNo.equals(other.cardNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankproject.Carddetails[ cardNo=" + cardNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
