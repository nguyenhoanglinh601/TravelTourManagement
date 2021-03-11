/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HoangLinh
 */
public class DbManager {

    private static String sql;
    protected static ResultSet rs = null;
    private static Statement s = null;
    private static Connection c = null;

    public static void connectDB(String host, String port, String dbName, String dbUser, String dbPassword) {
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s = c.createStatement();
            //System.out.println("connect DB successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //System.out.println("connect DB fail (SqlException)");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            //System.out.println("connect DB fail (Exception)");
        }
    }

    public static void setSQL(String sql) {
        DbManager.sql = sql;
    }

    public static void query() {
        try {
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void update() {
        try {
            s.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void addSort(String sort, String orderBy) {
        DbManager.sql += " order by " + orderBy + " " + sort;
    }

    public static void main(String args[]) {
        connectDB("localhost", "3306", "tour_dulich", "root", "");

//        QUERY TABLE IN DATABASE
//        setSQL("select * from `tour_nhanvien`");
//        query();
//        try {
//            while(rs.next()){
//                System.out.println(rs.getInt("kh_id"));
//                System.out.println(rs.getString("kh_ten"));
//                System.out.println(rs.getString("kh_sdt"));
//                System.out.println(rs.getDate("kh_ngaysinh"));
//                System.out.println(rs.getString("kh_email"));
//                System.out.println(rs.getString("kh_cmnd"));
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//        UPDATE TABLE IN DATABSE
//        setSQL("update `tour_nhanvien` set `kh_ten`='Hoàng Phúc' where `kh_id`='1'");
//        update();
//        setSQL("select * from `tour_nhanvien`");
//        query();
//        try {
//            while (rs.next()) {
//                System.out.println(rs.getInt("kh_id"));
//                System.out.println(rs.getString("kh_ten"));
//                System.out.println(rs.getString("kh_sdt"));
//                System.out.println(rs.getDate("kh_ngaysinh"));
//                System.out.println(rs.getString("kh_email"));
//                System.out.println(rs.getString("kh_cmnd"));
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//        QUERY TABLE AND SORT RESULTS 
//        setSQL("select * from `tour_nhanvien`");
//        addSort("desc","kh_id");
//        query();
//        try {
//            while (rs.next()) {
//                System.out.println(rs.getInt("kh_id"));
//                System.out.println(rs.getString("kh_ten"));
//                System.out.println(rs.getString("kh_sdt"));
//                System.out.println(rs.getDate("kh_ngaysinh"));
//                System.out.println(rs.getString("kh_email"));
//                System.out.println(rs.getString("kh_cmnd"));
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//

    }
}
