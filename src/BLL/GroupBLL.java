/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CustomerDAL;
import static DAL.DbManager.connectDB;
import DAL.GroupDetailDAL;
import Entities.Customer;
import Entities.GroupDetail;
import java.util.ArrayList;

/**
 *
 * @author HoangLinh
 */
public class GroupBLL {

    public ArrayList<Customer> getCustomersInGroup(int idGroup) {
        GroupDetailDAL groupDetailDAL = new GroupDetailDAL();
        CustomerDAL customerDAL = new CustomerDAL();

        ArrayList<Customer> listCustomer = new ArrayList<>();
        ArrayList<GroupDetail> listGroupDetail = groupDetailDAL.getByIdGroup(idGroup);

        for (GroupDetail g : listGroupDetail) {
            Customer c = customerDAL.getCustomer(g.getKh_id());

            listCustomer.add(c);
        }

        return listCustomer;
    }

    public static void main(String args[]) {
        connectDB("localhost", "3306", "tour_dulich", "root", "");

        GroupBLL g = new GroupBLL();
        ArrayList<Customer> l = g.getCustomersInGroup(1);
        for (Customer c : l) {
            System.out.println(c.getName());
        }
    }
}
