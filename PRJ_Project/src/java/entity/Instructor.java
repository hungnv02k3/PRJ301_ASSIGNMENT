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
public class Instructor extends BaseEntity{
    private int Inid;
    private String Inname;
    private Date indob;
    private boolean ingender;
    private ArrayList<Session> sessions = new ArrayList<>();
    private ArrayList<Group> groups = new ArrayList<>();

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public int getInid() {
        return Inid;
    }

    public void setInid(int Inid) {
        this.Inid = Inid;
    }

    public String getInname() {
        return Inname;
    }

    public void setInname(String Inname) {
        this.Inname = Inname;
    }

    public Date getIndob() {
        return indob;
    }

    public void setIndob(Date indob) {
        this.indob = indob;
    }

    public boolean isIngender() {
        return ingender;
    }

    public void setIngender(boolean ingender) {
        this.ingender = ingender;
    }
    
    
}
