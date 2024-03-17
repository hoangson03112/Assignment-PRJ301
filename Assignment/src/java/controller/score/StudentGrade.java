/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.score;

import controller.login.auth;
import data.GroupContext;
import data.StudentContext;
import data.SubjectContext;
import ennity.Account;
import entity.Student;
import entity.StudentGroup;
import entity.Subject;
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
public class StudentGrade extends auth {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int sid= Integer.parseInt(req.getParameter("sid"));
        String sname= req.getParameter("sname");
        int gid= Integer.parseInt(req.getParameter("gid"));
        StudentContext dbstudent= new StudentContext();
        dbstudent.addStudent(sid, sname);
        dbstudent.addEnrollment(sid, gid);
        resp.getWriter().print("Success!");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int gid = Integer.parseInt(req.getParameter("gid"));
        int subid = Integer.parseInt(req.getParameter("subid"));

        GroupContext dbGroup = new GroupContext();
        ArrayList<Student> students = dbGroup.getStudentByGroup(gid);
  

        SubjectContext dbSubject = new SubjectContext();
        ArrayList<Subject> subs = dbSubject.list();
        req.setAttribute("subid", subid);

        req.setAttribute("subs", subs);

        req.setAttribute("students", students);
        req.getRequestDispatcher("view/StudentGrade.jsp").forward(req, resp);
    }

}