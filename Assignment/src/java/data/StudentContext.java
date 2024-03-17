/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Hoàng Sơn
 */
public class StudentContext extends DBContext<Student> {

    public ArrayList<Student> getByLession(int leid) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.sid,s.sname FROM Student s INNER JOIN Enrollment e ON s.[sid] = e.[sid]\n"
                    + "                   INNER JOIN [Group] g ON g.gid = e.gid\n"
                    + "                   	INNER JOIN Lession les ON les.gid = g.gid\n"
                    + "                   WHERE les.leid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, leid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                students.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
//    public Student getByLessionAndSid(int leid,int sid) {
//  
//        try {
//            String sql = "SELECT s.sid,s.sname FROM Student s INNER JOIN Enrollment e ON s.[sid] = e.[sid]\n"
//                    + "                   INNER JOIN [Group] g ON g.gid = e.gid\n"
//                    + "                   	INNER JOIN Lession les ON les.gid = g.gid\n"
//                    + "                   WHERE les.leid = ? and s.sid=?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, leid);
//            stm.setInt(2, sid);
//
//            ResultSet rs = stm.executeQuery();
//            if(rs.next()) {
//                Student s = new Student();
//                s.setSid(rs.getInt("sid"));
//                s.setSname(rs.getString("sname"));
//               return s;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//        
//    }

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addStudent(int sid, String sname) {
        try {
            String sql = "INSERT INTO [dbo].[Student]\n"
                    + "           ([sid]\n"
                    + "           ,[sname])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setString(2, sname);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addEnrollment(int sid, int gid) {
        try {
            String sql = "INSERT INTO [dbo].[Enrollment]\n"
                    + "           ([sid]\n"
                    + "           ,[gid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setInt(2, gid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudent(int sid) {
        try {
            String sql = "DELETE FROM [dbo].[Student]\n"
                    + "      WHERE sid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteEnrollment(int sid, int gid) {
        try {
            String sql = "DELETE FROM [dbo].[Enrollment]\n"
                    + "      WHERE sid=? and gid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setInt(2, gid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
