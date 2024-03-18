/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Student;

import controller.login.RBAC;
import controller.login.auth;
import ennity.Account;
import entity.Role;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class addStudent extends RBAC {

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        req.setAttribute("gid", Integer.parseInt(req.getParameter("gid")));
        req.setAttribute("subid", Integer.parseInt(req.getParameter("subid")));

        req.getRequestDispatcher("view/addStudent.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        req.getRequestDispatcher("view/addStudent.jsp").forward(req, resp);
    }

}
