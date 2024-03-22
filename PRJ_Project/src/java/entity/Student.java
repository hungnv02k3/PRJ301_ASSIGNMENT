/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Student extends BaseEntity {
    private int stid;
    private String stname;
    private Date stdob;
    private Boolean stgender;
    private ArrayList<Group> groups = new ArrayList<>();

    public Date getStdob() {
        return stdob;
    }

    public void setStdob(Date stdob) {
        this.stdob = stdob;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getStname() {
        return stname;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public Boolean getStgender() {
        return stgender;
    }

    public void setStgender(Boolean stgender) {
        this.stgender = stgender;
    } 
}
