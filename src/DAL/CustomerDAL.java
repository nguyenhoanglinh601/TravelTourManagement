/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.Customer;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HoangLinh
 */
public class CustomerDAL extends DbManager {

    private ArrayList<Customer> list;

    public CustomerDAL() {
    }

    public CustomerDAL(ArrayList<Customer> list) {
        this.list = list;
    }

    private void getTable() {
        query();

        list = new ArrayList<>();

        try {
            ResultSetMetaData rd = rs.getMetaData();
            while (rs.next()) {
                Customer e = new Customer();
                e.setId(rs.getInt("kh_id"));
                e.setName(rs.getString("kh_ten"));
                e.setNumberPhone(rs.getString("kh_sdt"));
                e.setBirthDay(rs.getDate("kh_ngaysinh"));
                e.setEmail(rs.getString("kh_email"));
                e.setIdCard(rs.getString("kh_cmnd"));

                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ArrayList<Customer> getAllCustomers() {
        String sql = "select * from `tour_khachhang`";
        setSQL(sql);
        addSort("asc", "kh_id");
        getTable();
        return list;
    }

    public Customer getCustomer(int idCustomer) {
        Customer e = new Customer();
        String sql = "SELECT * FROM `tour_khachhang` WHERE `kh_id`=" + idCustomer;
        setSQL(sql);
        addSort("asc", "kh_id");
        query();
        try {
            while (rs.next()) {
                e.setId(rs.getInt("kh_id"));
                e.setName(rs.getString("kh_ten"));
                e.setNumberPhone(rs.getString("kh_sdt"));
                e.setBirthDay(rs.getDate("kh_ngaysinh"));
                e.setEmail(rs.getString("kh_email"));
                e.setIdCard(rs.getString("kh_cmnd"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return e;
    }

    public ArrayList findCustomer(String name) {
        String sql = "select * from `tour_khachhang` where `kh_ten` = " + name;
        setSQL(sql);
        addSort("asc", "kh_id");
        getTable();
        return list;
    }

    public void insertCustomer(Customer e) {
        String sql = "INSERT INTO `tour_khachhang`(`kh_id`, `kh_ten`, `kh_sdt`, `kh_ngaysinh`, `kh_email`, `kh_cmnd`) "
                + "VALUES ('" + e.getId() + "','" + e.getName() + "','" + e.getNumberPhone() + "','" + e.getBirthDay() + "','" + e.getEmail() + "','" + e.getIdCard() + "')";
        setSQL(sql);
        update();
    }

    public void updateCustomer(Customer e) {
        String sql = "UPDATE `tour_khachhang` "
                + "SET `kh_ten`='" + e.getName() + "',`kh_sdt`='" + e.getNumberPhone() + "',`kh_ngaysinh`='" + e.getBirthDay() + "',`kh_email`='" + e.getEmail() + "',`kh_cmnd`='" + e.getIdCard() + "' "
                + "WHERE `kh_id`='" + e.getId() + "'";
        setSQL(sql);
        update();
    }

    public void deleteCustomer(Customer e) {
        String sql = "DELETE FROM `tour_khachhang` WHERE `kh_id`='" + e.getId() + "'";
        setSQL(sql);
        update();
    }
}
