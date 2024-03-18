/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.score;

import controller.login.RBAC;
import ennity.Account;
import entity.Role;
import entity.Score;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class addScore extends RBAC {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        double Active_learning = Double.parseDouble(req.getParameter("Active_learning"));
        double Presentation = Double.parseDouble(req.getParameter("Presentation"));
        double Computer_Project = Double.parseDouble(req.getParameter("Computer_Project"));
        double Assignment_1 = Double.parseDouble(req.getParameter("Assignment_1"));
        double Assignment_2 = Double.parseDouble(req.getParameter("Assignment_2"));
        double PT_1 = Double.parseDouble(req.getParameter("PT_1"));
        double PT_2 = Double.parseDouble(req.getParameter("PT_2"));
        double PT_3 = Double.parseDouble(req.getParameter("PT_3"));
        double Project = Double.parseDouble(req.getParameter("Project"));
        double PE = Double.parseDouble(req.getParameter("PE"));
        double FE = Double.parseDouble(req.getParameter("FE"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
