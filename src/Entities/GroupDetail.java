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
public class GroupDetail {
    public int kh_id, nv_id, doan_id;

    public GroupDetail() {
    }

    public GroupDetail(int kh_id, int nv_id, int doan_id) {
        this.kh_id = kh_id;
        this.nv_id = nv_id;
        this.doan_id = doan_id;
    }

    public int getKh_id() {
        return kh_id;
    }

    public void setKh_id(int kh_id) {
        this.kh_id = kh_id;
    }

    public int getNv_id() {
        return nv_id;
    }

    public void setNv_id(int nv_id) {
        this.nv_id = nv_id;
    }

    public int getDoan_id() {
        return doan_id;
    }

    public void setDoan_id(int doan_id) {
        this.doan_id = doan_id;
    }
    
    
}
