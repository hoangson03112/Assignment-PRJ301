/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import entity.Score;
import entity.Student;
import entity.StudentGroup;
import entity.Subject;
import entity.score.Active_learning;
import entity.score.Ass_1;
import entity.score.Ass_2;
import entity.score.Computer_Project;
import entity.score.FE;
import entity.score.PE;
import entity.score.PT_1;
import entity.score.PT_2;
import entity.score.PT_3;
import entity.score.Presentation;
import entity.score.Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Sơn
 */
public class ScoreContext extends DBContext<Object> {

    public Score getGrade(int sid, int subid) {
        Score s = new Score();
        ArrayList<StudentGroup> listGroup = new ArrayList<>();
        try {
            String sql = " SELECT sc.sid,sc.subid,sc.Active_learning,sc.Assignment_1,sc.Assignment_2,sc.Computer_Project,\n"
                    + " sc.FE,sc.PE,sc.Presentation,sc.Project,sc.PT_1,sc.PT_2,sc.PT_3,s.sname,sub.suname\n"
                    + "                     FROM [dbo].[Score]  sc\n"
                    + "					join [dbo].[Student] s\n"
                    + "					on s.sid=sc.sid \n"
                    + "					join [dbo].[Subject] sub\n"
                    + "					on sub.suid=sc.subid\n"
                    + "				\n"
                    + "					where sc.sid=? and sc.subid =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.setInt(2, subid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("suname"));
                s.setSubject(sub);

                Student stu = new Student();
                stu.setSname(rs.getString("sname"));
                stu.setSid(rs.getInt("sid"));
                stu.setGroups(listGroup);
                s.setStudent(stu);

                if (rs.getDouble("Active_learning") != Double.parseDouble("0.0")) {
                    Active_learning learning = new Active_learning();
                    learning.setValue(Math.round(10.0*rs.getFloat("Active_learning"))/10.0);
                    s.setActive_learning(learning);
                }
                if (rs.getFloat("Assignment_1") != Double.parseDouble("0.0")) {
                    Ass_1 ass1 = new Ass_1();
                    ass1.setValue(Math.round(10.0*rs.getFloat("Assignment_1"))/10.0);
                    s.setAssignment_1(ass1);
                }

                if (rs.getFloat("Assignment_2") != Double.parseDouble("0.0")) {
                    Ass_2 ass2 = new Ass_2();
                    ass2.setValue(Math.round(10.0*rs.getFloat("Assignment_2"))/10.0);
                    s.setAssignment_2(ass2);
                }

                if (rs.getFloat("Computer_Project") != Double.parseDouble("0.0")) {
                    Computer_Project cproject = new Computer_Project();
                    cproject.setValue(Math.round(10.0*rs.getFloat("Computer_Project"))/10.0);
                    s.setComputer_Project(cproject);
                }

                if (rs.getFloat("FE") != Double.parseDouble("0.0")) {
                    FE fe = new FE();
                    fe.setValue(Math.round(10.0*rs.getFloat("FE"))/10.0);
                    s.setFE(fe);
                }

                if (rs.getFloat("Presentation") != Double.parseDouble("0.0")) {
                    Presentation presentation = new Presentation();
                    presentation.setValue(Math.round(10.0*rs.getFloat("Presentation"))/10.0);
                    s.setPresentation(presentation);
                }

                if (rs.getFloat("Project") != Double.parseDouble("0.0")) {
                    Project project = new Project();
                    project.setValue(Math.round(10.0*rs.getFloat("Project"))/10.0);
                    s.setProject(project);
                }

                if (rs.getFloat("PT_1") != Double.parseDouble("0.0")) {
                    PT_1 pt1 = new PT_1();
                    pt1.setValue(Math.round(10.0*rs.getFloat("PT_1"))/10.0);
                    s.setPT_1(pt1);
                }

                if (rs.getFloat("PT_2") != Double.parseDouble("0.0")) {
                    PT_2 pt2 = new PT_2();
                    pt2.setValue(Math.round(10.0*rs.getFloat("PT_2"))/10.0);
                    s.setPT_2(pt2);
                }

                if (rs.getFloat("PT_3") != Double.parseDouble("0.0")) {
                    PT_3 pt3 = new PT_3();
                    pt3.setValue(Math.round(10.0*rs.getFloat("PT_3"))/10.0);
                    s.setPT_3(pt3);
                }

                if (rs.getFloat("PE") != Double.parseDouble("0.0")) {
                    PE pe = new PE();
                    pe.setValue(Math.round(10.0*rs.getFloat("PE"))/10.0);
                    s.setPE(pe);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ScoreContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public ArrayList<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
