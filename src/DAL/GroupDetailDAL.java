/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.DbManager.addSort;
import static DAL.DbManager.connectDB;
import static DAL.DbManager.query;
import static DAL.DbManager.rs;
import static DAL.DbManager.setSQL;
import Entities.Customer;
import Entities.GroupDetail;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HoangLinh
 */
public class GroupDetailDAL {

    public ArrayList<GroupDetail> getByIdGroup(int idGroup) {
        ArrayList<GroupDetail> listGroupDetail = new ArrayList<>();
        String sql = "select * from tour_nguoidi where doan_id=" + idGroup;
        setSQL(sql);
        addSort("asc", "doan_id");
        query();
        try {
            while (rs.next()) {
                GroupDetail groupDetail=new GroupDetail();
                groupDetail.setDoan_id(rs.getInt("doan_id"));
                groupDetail.setKh_id(rs.getInt("kh_id"));
                groupDetail.setNv_id(rs.getInt("nv_id"));
                
                listGroupDetail.add(groupDetail);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listGroupDetail;
    }
}
