/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import entity.Lecturer;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hoàng Sơn
 */
public class LecturerContext extends DBContext<Lecturer> {

    @Override
    public ArrayList<Lecturer> list() {
        ArrayList<Lecturer> listLec= new ArrayList<>();
        try {
            String sql = "SELECT [lid]\n"
                    + "      ,[lname]\n"
                    + "  FROM [dbo].[Lecturer]";
            PreparedStatement stm= connection.prepareStatement(sql);;
            ResultSet rs= stm.executeQuery();
            while (rs.next()) {                
                Lecturer l= new Lecturer();
                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));
                listLec.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLec;
    }

    @Override
    public void insert(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecturer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lecturer get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
