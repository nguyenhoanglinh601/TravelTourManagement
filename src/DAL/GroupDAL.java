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
import Entities.Group;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HoangLinh
 */
public class GroupDAL {

    public GroupDAL() {
    }

    public ArrayList<Group> getAllGroupOfTour(int tourId) {
        ArrayList<Group> listGroup = new ArrayList<>();

        String sql = "select * from tour_doan where tour_id=" + tourId;
        setSQL(sql);
        addSort("asc", "doan_id");
        query();
        try {
            while (rs.next()) {
                Group g = new Group();
                g.setGroupId(rs.getInt("doan_id"));
                g.setTourId(rs.getInt("tour_id"));
                g.setGroupName(rs.getString("doan_name"));
                g.setDetail(rs.getString("doan_chitietchuongtrinh"));
                g.setStartDay(rs.getDate("doan_ngaydi"));
                g.setEndDay(rs.getDate("doan_ngayve"));

                listGroup.add(g);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listGroup;
    }
}
