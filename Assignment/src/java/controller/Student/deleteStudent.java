/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Student;
import controller.login.auth;
import data.StudentContext;
import ennity.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoàng Sơn
 */
public class deleteStudent extends auth {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int gid = Integer.parseInt(req.getParameter("gid"));
        int sid = Integer.parseInt(req.getParameter("sid"));
        StudentContext dbstudent = new StudentContext();
        dbstudent.deleteStudent(sid);
        dbstudent.deleteEnrollment(sid, gid);
        req.getRequestDispatcher("view/StudentGrade.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
