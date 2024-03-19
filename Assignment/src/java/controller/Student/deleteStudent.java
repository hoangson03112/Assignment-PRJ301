/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Student;

import controller.login.RBAC;
import controller.login.auth;
import data.StudentContext;
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
public class deleteStudent extends RBAC {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        int gid = Integer.parseInt(req.getParameter("gid"));
        int sid = Integer.parseInt(req.getParameter("sid"));
        int subid = Integer.parseInt(req.getParameter("subid"));
        StudentContext dbstudent = new StudentContext();
        
        dbstudent.deleteStudent(sid);
        dbstudent.deleteEnrollment(sid, gid);
        resp.sendRedirect("StudentGrade?subid=" + subid + "&gid=" + gid);
   

//        req.getRequestDispatcher("view/StudentGrade.jsp").forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
