/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinema.otomasyon;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SinemaOtomasyon {

    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";
    public static final String CONN_STRING
    = "jdbc:mysql://localhost/SinemaOtomasyon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {
      
        //Icecek icecek = new Icecek("Coca Cola", 5, 100);
        Bufe yiyecek = new Yiyecek("Kuru Yemis", 20, 50);
    }

}