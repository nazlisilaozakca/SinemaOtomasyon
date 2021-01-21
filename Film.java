
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
@Table(name = "film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findById", query = "SELECT f FROM Film f WHERE f.id = :id")
    , @NamedQuery(name = "Film.findByAd", query = "SELECT f FROM Film f WHERE f.ad = :ad")
    , @NamedQuery(name = "Film.findByKategori", query = "SELECT f FROM Film f WHERE f.kategori = :kategori")
    , @NamedQuery(name = "Film.findByFiyat", query = "SELECT f FROM Film f WHERE f.fiyat = :fiyat")
    , @NamedQuery(name = "Film.findByUcboyut", query = "SELECT f FROM Film f WHERE f.ucboyut = :ucboyut")})
public class Film implements Serializable,EntityClasses {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "AD")
    private String ad;
    @Column(name = "KATEGORI")
    private String kategori;
    @Column(name = "FIYAT")
    private Integer fiyat;
    @Column(name = "UCBOYUT")
    private Short ucboyut;

    public Film() {
    }

    public Film(Integer id) {
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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Integer getFiyat() {
        return fiyat;
    }

    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    public Short getUcboyut() {
        return ucboyut;
    }

    public void setUcboyut(Short ucboyut) {
        this.ucboyut = ucboyut;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sinema.otomasyon.Film[ id=" + id + " ]";
    }
    @Override
    public int getSonId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sinema-OtomasyonPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT f FROM Film f");
        List<Film> idler = q.getResultList();
        int enBuyuk = 0;
        for (Film film : idler) {
            if (film.getId() > enBuyuk) {
                enBuyuk = film.getId();
            }
        }return enBuyuk;
    }
}
