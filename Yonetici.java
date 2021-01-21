/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinema.otomasyon;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NAZLI
 */
@Entity
@Table(name = "yonetici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yonetici.findAll", query = "SELECT y FROM Yonetici y")
    , @NamedQuery(name = "Yonetici.findById", query = "SELECT y FROM Yonetici y WHERE y.id = :id")
    , @NamedQuery(name = "Yonetici.findByAd", query = "SELECT y FROM Yonetici y WHERE y.ad = :ad")
    , @NamedQuery(name = "Yonetici.findBySoyad", query = "SELECT y FROM Yonetici y WHERE y.soyad = :soyad")
    , @NamedQuery(name = "Yonetici.findByParola", query = "SELECT y FROM Yonetici y WHERE y.parola = :parola")
    , @NamedQuery(name = "Yonetici.findByTelefon", query = "SELECT y FROM Yonetici y WHERE y.telefon = :telefon")
    , @NamedQuery(name = "Yonetici.findByEmaiL", query = "SELECT y FROM Yonetici y WHERE y.emaiL = :emaiL")
    , @NamedQuery(name = "Yonetici.findByCinsiyet", query = "SELECT y FROM Yonetici y WHERE y.cinsiyet = :cinsiyet")})
public class Yonetici implements Serializable,EntityClasses {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "AD")
    private String ad;
    @Column(name = "SOYAD")
    private String soyad;
    @Column(name = "PAROLA")
    private String parola;
    @Column(name = "TELEFON")
    private String telefon;
    @Column(name = "EMA\u0130L")
    private String emaiL;
    @Column(name = "Cinsiyet")
    private String cinsiyet;

    public Yonetici() {
    }
    public Yonetici(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public String getSoyad() {
        return soyad;
    }
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    public String getParola() {
        return parola;
    }
    public void setParola(String parola) {
        this.parola = parola;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getEmaiL() {
        return emaiL;
    }
    public void setEmaiL(String emaiL) {
        this.emaiL = emaiL;
    }
    public String getCinsiyet() {
        return cinsiyet;
    }
    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
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
        if (!(object instanceof Yonetici)) {
            return false;
        }
        Yonetici other = (Yonetici) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sinema.otomasyon.Yonetici[ id=" + id + " ]";
    }
    @Override
    public int getSonId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sinema-OtomasyonPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT y FROM Yonetici y");
        List<Yonetici> idler = q.getResultList();
        int enBuyuk = 0;
        for (Yonetici yonetici : idler) {
            System.out.println();
            if (yonetici.getId()> enBuyuk) {
                enBuyuk = yonetici.getId();
            }
        }return enBuyuk;
    }
    
}
