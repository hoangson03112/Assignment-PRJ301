
package entity;
import java.sql.*;
import java.util.ArrayList;

public class Lession {
    private int id;
    private Date date;
    private boolean attended;
    private Room room;
    private TimeSlot slot;
    private Lecturer lecturer;
    private StudentGroup group;
    private ArrayList<Attendence> atts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public ArrayList<Attendence> getAtts() {
        return atts;
    }

    public void setAtts(ArrayList<Attendence> atts) {
        this.atts = atts;
    }
    
    
}
