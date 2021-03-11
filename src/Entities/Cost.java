/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author HoangLinh
 */
public class Cost {

    private int costId, groupId;
    private String costName, costDes, total;

    public Cost() {
    }

    public Cost(int costId, int groupId, String costName, String costDes, String total) {
        this.costId = costId;
        this.groupId = groupId;
        this.costName = costName;
        this.costDes = costDes;
        this.total = total;
    }

    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostDes() {
        return costDes;
    }

    public void setCostDes(String costDes) {
        this.costDes = costDes;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
