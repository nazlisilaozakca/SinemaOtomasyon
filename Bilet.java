
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

@Entity
@Table(name = "bilet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bilet.findAll", query = "SELECT b FROM Bilet b")
    , @NamedQuery(name = "Bilet.findById", query = "SELECT b FROM Bilet b WHERE b.id = :id")
    , @NamedQuery(name = "Bilet.findByN95", query = "SELECT b FROM Bilet b WHERE b.n95 = :n95")
    , @NamedQuery(name = "Bilet.findByFilmid", query = "SELECT b FROM Bilet b WHERE b.filmid = :filmid")
    , @NamedQuery(name = "Bilet.findByUcboyut", query = "SELECT b FROM Bilet b WHERE b.ucboyut = :ucboyut")
    , @NamedQuery(name = "Bilet.findByTarih", query = "SELECT b FROM Bilet b WHERE b.tarih = :tarih")
    , @NamedQuery(name = "Bilet.findBySaat", query = "SELECT b FROM Bilet b WHERE b.saat = :saat")
    , @NamedQuery(name = "Bilet.findByKoltukno", query = "SELECT b FROM Bilet b WHERE b.koltukno = :koltukno")
    , @NamedQuery(name = "Bilet.findBySalonid", query = "SELECT b FROM Bilet b WHERE b.salonid = :salonid")
    , @NamedQuery(name = "Bilet.findByBiletfiyat", query = "SELECT b FROM Bilet b WHERE b.biletfiyat = :biletfiyat")})

public class Bilet implements Serializable,EntityClasses {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "N95")
    private Short n95;
    @Column(name = "FILMID")
    private Integer filmid;
    @Column(name = "UCBOYUT")
    private Short ucboyut;
    @Column(name = "TARIH")
    private String tarih;
    @Column(name = "SAAT")
    private String saat;
    @Column(name = "KOLTUKNO")
    private Integer koltukno;
    @Column(name = "SALONID")
    private Integer salonid;
    @Column(name = "BILETFIYAT")
    private Integer biletfiyat;

    public Bilet() {
    }
    public Bilet(Integer id) {
        this.id = id;}
    public Integer getId() {
        return id;}
    public void setId(Integer id) {
        this.id = id;}
    public Short getN95() {
        return n95;}
    public void setN95(Short n95) {
        this.n95 = n95;}
    public Integer getFilmid() {
        return filmid;}
    public void setFilmid(Integer filmid) {
        this.filmid = filmid;}
    public Short getUcboyut() {
        return ucboyut;}
    public void setUcboyut(Short ucboyut) {
        this.ucboyut = ucboyut;}

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public Integer getKoltukno() {
        return koltukno;
    }

    public void setKoltukno(Integer koltukno) {
        this.koltukno = koltukno;
    }

    public Integer getSalonid() {
        return salonid;
    }

    public void setSalonid(Integer salonid) {
        this.salonid = salonid;
    }

    public Integer getBiletfiyat() {
        return biletfiyat;
    }

    public void setBiletfiyat(Integer biletfiyat) {
        this.biletfiyat = biletfiyat;
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
        if (!(object instanceof Bilet)) {
            return false;
        }
        Bilet other = (Bilet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sinema.otomasyon.Bilet[ id=" + id + " ]";
    }
    @Override
    public int getSonId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sinema-OtomasyonPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT b FROM Bilet b");
        List<Bilet> idler = q.getResultList();
        int enBuyuk = 0;
        for (Bilet bilet : idler) {
            System.out.println();
            if (bilet.getId()> enBuyuk) {
                enBuyuk = bilet.getId();
            }
        }return enBuyuk;
    }

}
