/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import entity.Attendence;
import entity.Lession;
import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Sơn
 */
public class AttendanceContext extends DBContext<Attendence> {

    public void updateByLession(int leid, ArrayList<Attendence> atts) {
        try {

            connection.setAutoCommit(false);
            String sql_remove_atts = "DELETE FROM [dbo].[Attendence] \n"
                    + "      WHERE leid=?";
            PreparedStatement stm_remove_atts = connection.prepareStatement(sql_remove_atts);
            stm_remove_atts.setInt(1, leid);
            stm_remove_atts.executeUpdate();
            String sql_insert_att = "INSERT INTO [dbo].[Attendence]\n"
                    + "           ([leid]\n"
                    + "           ,[sid]\n"
                    + "           ,[description]\n"
                    + "           ,[isPresent]\n"
                    + "           ,[capturedtime])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,FORMAT(GETDATE(), 'yyyy-MM-dd HH:mm'))";
            for (Attendence att : atts) {
                PreparedStatement stm_insert_att = connection.prepareStatement(sql_insert_att);
                stm_insert_att.setInt(1, leid);
                stm_insert_att.setInt(2, att.getStudent().getSid());
                stm_insert_att.setString(3, att.getDescription());
                stm_insert_att.setBoolean(4, att.isPresent());
                stm_insert_att.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendanceContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Attendence get(int sid, int leid) {
        Attendence a = new Attendence();
        try {
            String sql = "SELECT les.leid,s.sid,s.sname,a.aid,a.description,a.isPresent,a.capturedtime      \n"
                    + "              FROM\n"
                    + "                   Student s INNER JOIN Enrollment e ON s.[sid] = e.[sid]\n"
                    + "                INNER JOIN [Group] g ON g.gid = e.gid\n"
                    + "                INNER JOIN Lession les ON les.gid = g.gid\n"
                    + "                  LEFT JOIN Attendence a ON a.leid = les.leid AND s.sid = a.sid\n"
                    + "                  WHERE les.leid = ? and s.sid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, leid);
            stm.setInt(2, sid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                a = new Attendence();

                Lession lession = new Lession();
                lession.setId(rs.getInt("leid"));
                a.setLession(lession);

                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                a.setStudent(s);
                a.setId(rs.getInt("aid"));
                if (a.getId() != 0) {
                    a.setDescription(rs.getString("description"));
                    a.setPresent(rs.getBoolean("isPresent"));
                    a.setTime(rs.getTimestamp("capturedtime"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LessionContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    public ArrayList<Attendence> getAtts(int sid) {
        ArrayList<Attendence> atts = new ArrayList<>();
        try {
            String sql = "SELECT les.leid,s.sid,s.sname,a.aid,a.description,a.isPresent,a.capturedtime     \n"
                    + "                  FROM\n"
                    + "                Student s INNER JOIN Enrollment e ON s.[sid] = e.[sid]\n"
                    + "                INNER JOIN [Group] g ON g.gid = e.gid\n"
                    + "                INNER JOIN Lession les ON les.gid = g.gid\n"
                    + "              LEFT JOIN Attendence a ON a.leid = les.leid AND s.sid = a.sid\n"
                    + "               WHERE  s.sid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendence a = new Attendence();
                Lession lession = new Lession();
                lession.setId(rs.getInt("leid"));
                a.setLession(lession);

                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));

                a.setStudent(s);
                a.setId(rs.getInt("aid"));
                a.setDescription(rs.getString("description"));
                a.setPresent(rs.getBoolean("isPresent"));
                a.setTime(rs.getTimestamp("capturedtime"));
                atts.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LessionContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return atts;
    }

    @Override
    public ArrayList<Attendence> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendence entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendence entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendence entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendence get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
