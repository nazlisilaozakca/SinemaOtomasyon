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
@Table(name = "musteri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musteri.findAll", query = "SELECT m FROM Musteri m")
    , @NamedQuery(name = "Musteri.findById", query = "SELECT m FROM Musteri m WHERE m.id = :id")
    , @NamedQuery(name = "Musteri.findByAd", query = "SELECT m FROM Musteri m WHERE m.ad = :ad")
    , @NamedQuery(name = "Musteri.findByParola", query = "SELECT m FROM Musteri m WHERE m.parola = :parola")
    , @NamedQuery(name = "Musteri.findBySoyad", query = "SELECT m FROM Musteri m WHERE m.soyad = :soyad")
    , @NamedQuery(name = "Musteri.findByBiletid", query = "SELECT m FROM Musteri m WHERE m.biletid = :biletid")
    , @NamedQuery(name = "Musteri.findByTelefon", query = "SELECT m FROM Musteri m WHERE m.telefon = :telefon")
    , @NamedQuery(name = "Musteri.findByEmaiL", query = "SELECT m FROM Musteri m WHERE m.emaiL = :emaiL")
    , @NamedQuery(name = "Musteri.findByCinsiyet", query = "SELECT m FROM Musteri m WHERE m.cinsiyet = :cinsiyet")})
public class Musteri implements Serializable,EntityClasses {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "AD")
    private String ad;
    @Column(name = "PAROLA")
    private String parola;
    @Column(name = "SOYAD")
    private String soyad;
    @Column(name = "BILETID")
    private String biletid;
    @Column(name = "TELEFON")
    private String telefon;
    @Column(name = "EMA\u0130L")
    private String emaiL;
    @Column(name = "Cinsiyet")
    private String cinsiyet;

    public Musteri() {
    }
    public Musteri(Integer id) {
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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getBiletid() {
        return biletid;
    }

    public void setBiletid(String biletid) {
        this.biletid = biletid;
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
        if (!(object instanceof Musteri)) {
            return false;
        }
        Musteri other = (Musteri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sinema.otomasyon.Musteri[ id=" + id + " ]";
    }
    
    
    @Override
    public int getSonId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sinema-OtomasyonPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM Musteri m");
        List<Musteri> idler = q.getResultList();
        int enBuyuk = 0;
        for (Musteri musteri : idler) {
            System.out.println();
            if (musteri.getId() > enBuyuk) {
                enBuyuk = musteri.getId();
            }
        }return enBuyuk;
    }
    
}
