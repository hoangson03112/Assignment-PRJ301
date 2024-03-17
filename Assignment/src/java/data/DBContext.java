/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.logging.Level;
import java.sql.*;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public abstract class DBContext<T> {

    protected Connection connection;

    public DBContext() {
        try {
            String url = "jdbc:sqlserver://SOWN\\SQLEXPRESS:1433;databaseName=fap;encrypt=true;trustServerCertificate=true; ";
            String user = "son";
            String pass = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract ArrayList<T> list();

    public abstract void insert(T entity);

    public abstract void update(T entity);

    public abstract void delete(T entity);

    public abstract T get(int id);

}
