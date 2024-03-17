package entity;

import java.util.ArrayList;

public class Student {

    private ArrayList<StudentGroup> groups = new ArrayList<>();
    private int sid;
    private String sname;

    public ArrayList<StudentGroup> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<StudentGroup> groups) {
        this.groups = groups;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

}
