package sinema.otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NAZLI
 */
public class Icecek extends Bufe {

    public Icecek(String Ad, int Fiyat, int Adet) {
        Connection conn = null;
        PreparedStatement stmt = null;
        this.ad = Ad;
        this.fiyat = Fiyat;
        this.adet = Adet;
        try {
            conn = DriverManager.getConnection(SinemaOtomasyon.CONN_STRING, SinemaOtomasyon.USERNAME, SinemaOtomasyon.PASSWORD);
            System.out.println("connected");
            int id = 8;
            String adi = Ad;
            int fiyat = Fiyat;
            int adet = Adet;
            String sql = "INSERT INTO icecek (Ad,Fiyat,Adet) VALUES (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, adi);
            stmt.setInt(2, fiyat);
            stmt.setInt(3, adet);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void Sat(String Ad,int Adet) {
        Connection con = null;
        PreparedStatement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(SinemaOtomasyon.CONN_STRING, SinemaOtomasyon.USERNAME, SinemaOtomasyon.PASSWORD);
            String sql = "UPDATE icecek SET Adet=? WHERE Ad=?";
            s = con.prepareStatement(sql);
            s.setInt(1, Adet - 1);
            s.setString(2, Ad);
            s.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    @Override
    public void Al(String Ad, int yeniAdet, int EskiAdet) {
        Connection con = null;
        PreparedStatement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(SinemaOtomasyon.CONN_STRING, SinemaOtomasyon.USERNAME, SinemaOtomasyon.PASSWORD);
            String sql = "UPDATE icecek SET Adet=? WHERE Ad=?";
            s = con.prepareStatement(sql);
            s.setInt(1, EskiAdet + yeniAdet);
            s.setString(2, Ad);
            s.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
