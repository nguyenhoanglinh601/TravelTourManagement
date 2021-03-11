/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.DbManager.addSort;
import static DAL.DbManager.query;
import static DAL.DbManager.rs;
import static DAL.DbManager.setSQL;
import Entities.Cost;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HoangLinh
 */
public class CostDAL {

    public CostDAL() {
    }

    public ArrayList<Cost> getAllCostOfGroup(int groupId) {
        ArrayList<Cost> listCost = new ArrayList<>();

        String sql = "select * "
                + "from tour_chiphi, tour_loaichiphi "
                + "where cp_id=chiphi_id and doan_id=" + groupId;
        setSQL(sql);
        addSort("asc", "chiphi_id");
        query();

        try {
            while (rs.next()) {
                Cost c = new Cost();
                c.setCostId(rs.getInt("chiphi_id"));
                c.setGroupId(rs.getInt("doan_id"));
                c.setCostName(rs.getString("cp_ten"));
                c.setCostDes(rs.getString("cp_mota"));
                c.setTotal(rs.getString("chiphi_total"));

                listCost.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return listCost;
    }
}
