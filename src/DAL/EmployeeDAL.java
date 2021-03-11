/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.Employee;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HoangLinh
 */
public class EmployeeDAL extends DbManager {

    private ArrayList<Employee> list;

    public EmployeeDAL() {
    }

    public EmployeeDAL(ArrayList<Employee> list) {
        this.list = list;
    }

    private void getTable() {
        query();

        list = new ArrayList<>();

        try {
            ResultSetMetaData rd = rs.getMetaData();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("nv_id"));
                e.setName(rs.getString("nv_ten"));
                e.setNumberPhone(rs.getString("nv_sdt"));
                e.setBirthDay(rs.getDate("nv_ngaysinh"));
                e.setEmail(rs.getString("nv_email"));
                e.setIdCard(rs.getString("nv_cmnd"));

                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        String sql = "select * from `tour_nhanvien`";
        setSQL(sql);
        addSort("asc", "nv_id");
        getTable();
        return list;
    }

    public ArrayList findEmployee(String name) {
        String sql = "select * from `tour_nhanvien` where `nv_ten` = " + name;
        setSQL(sql);
        addSort("asc", "nv_id");
        getTable();
        return list;
    }

    public void insertEmployee(Employee e) {
        String sql = "INSERT INTO `tour_nhanvien`(`nv_id`, `nv_ten`, `nv_sdt`, `nv_ngaysinh`, `nv_email`, `nv_cmnd`) "
                + "VALUES ('" + e.getId() + "','"+e.getName()+"','"+e.getNumberPhone()+"','"+e.getBirthDay()+"','"+e.getEmail()+"','"+e.getIdCard()+"')";
        setSQL(sql);
        update();
    }
    
    public void updateEmployee(Employee e){
        String sql="UPDATE `tour_nhanvien` "
                + "SET `nv_ten`='"+e.getName()+"',`nv_sdt`='"+e.getNumberPhone()+"',`nv_ngaysinh`='"+e.getBirthDay()+"',`nv_email`='"+e.getEmail()+"',`nv_cmnd`='"+e.getIdCard()+"' "
                + "WHERE `nv_id`='"+e.getId()+"'";
        setSQL(sql);
        update();
    }
    
    public void deleteEmployee(Employee e){
        String sql="DELETE FROM `tour_nhanvien` WHERE `nv_id`='"+e.getId()+"'";
        setSQL(sql);
        update();
    }
}
