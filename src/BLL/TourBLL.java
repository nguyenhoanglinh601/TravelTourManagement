/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CostDAL;
import static DAL.DbManager.connectDB;
import DAL.GroupDAL;
import Entities.Cost;
import Entities.Group;
import java.util.ArrayList;

/**
 *
 * @author HoangLinh
 */
public class TourBLL {

    public ArrayList<Cost> statisticCost(int idTour) {
        ArrayList<Cost> listCostReturn = new ArrayList<>();

        GroupDAL groupDAL = new GroupDAL();
        CostDAL costDAL = new CostDAL();

        ArrayList<Group> listGroup = groupDAL.getAllGroupOfTour(idTour);
        for (Group g : listGroup) {
            ArrayList<Cost> listCost = costDAL.getAllCostOfGroup(g.getGroupId());
            listCostReturn.addAll(listCost);
        }
        return listCostReturn;
    }

    public static void main(String args[]) {
        connectDB("localhost", "3306", "tour_dulich", "root", "");
        TourBLL t = new TourBLL();
        ArrayList<Cost> listCost = t.statisticCost(1);
        for (Cost c : listCost) {
            System.out.println(c.getCostId());
            System.out.println(c.getCostName());
            System.out.println(c.getCostDes());
            System.out.println(c.getGroupId());
            System.out.println(c.getTotal());
        }
    }
}
