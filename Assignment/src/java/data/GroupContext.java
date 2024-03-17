/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import entity.Lecturer;
import entity.Lession;
import entity.Student;
import entity.StudentGroup;
import entity.Subject;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Sơn
 */
public class GroupContext extends DBContext<Object> {

    public ArrayList<StudentGroup> list(int subid) {
        ArrayList<StudentGroup> sgs = new ArrayList<>();

        try {
            String sql = "  select g.gid ,g.gname,l.lid,l.lname,s.suname\n"
                    + "                    FROM [dbo].[Group] g \n"
                    + "                      left join [dbo].[Lecturer] l\n"
                    + "                        on g.lid=l.lid\n"
                    + "						join [dbo].[Subject] s\n"
                    + "						on s.suid= g.subid\n"
                    + "                        where subid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, subid);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Lecturer le = new Lecturer();
                le.setId(rs.getInt("lid"));
                le.setName(rs.getString("lname"));
                Subject s = new Subject();
                s.setId(subid);
                s.setName(rs.getString("suname"));
                StudentGroup sg = new StudentGroup();
                sg.setId(rs.getInt("gid"));
                sg.setName(rs.getString("gname"));
                sg.setLecturer(le);
                sg.setSubject(s);
                sgs.add(sg);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GroupContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sgs;

    }

    public ArrayList<Student> getStudentByGroup(int gid) {
        ArrayList<Student> sts = new ArrayList<>();
        ArrayList<StudentGroup> studentGroup = new ArrayList<>();

        try {
            String sql = "SELECT s.sid,s.sname,g.gname\n"
                    + "  FROM [dbo].[Student] s  join\n"
                    + "[dbo].[Enrollment] e\n"
                    + "on e.sid =s.sid\n"
                    + "left join [dbo].[Group] g\n"
                    + "on g.gid =e.gid\n"
                    + "where g.gid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                StudentGroup stg = new StudentGroup();

                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                stg.setName(rs.getString("gname"));
                studentGroup.add(stg);
                s.setGroups(studentGroup);
                sts.add(s);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GroupContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sts;
    }

    @Override
    public void insert(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public StudentGroup get(int gid) {
        try {
            String sql = "SELECT [gid]\n"
                    + "      ,[gname]\n"
                    + "      ,[subid]\n"
                    + "      ,[lid]\n"
                    + "  FROM [dbo].[Group]\n"
                    + "  where gid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs= stm.executeQuery();
            if (rs.next()) {
                StudentGroup group= new StudentGroup();
                group.setId(gid);
                group.setName(rs.getString("gname"));
                return group;
              
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
