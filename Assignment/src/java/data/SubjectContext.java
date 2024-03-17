/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import entity.Subject;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hoàng Sơn
 */
public class SubjectContext extends DBContext<Subject> {

    @Override
    public ArrayList<Subject> list() {
        ArrayList<Subject> subs= new ArrayList<>();
        try {
            String sql = "SELECT [suid]\n"
                    + "      ,[suname]\n"
                    + "      ,[credit]\n"
                    + "  FROM [dbo].[Subject]";
            PreparedStatement stm= connection.prepareStatement(sql);
            ResultSet rs= stm.executeQuery();
            while (rs.next()) {                
                Subject s= new Subject();
                s.setId(rs.getInt("suid"));
                s.setName(rs.getString("suname"));
                s.setCredit(rs.getInt("credit"));
                subs.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  subs;
    }

    @Override
    public void insert(Subject entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Subject entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Subject entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subject get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
