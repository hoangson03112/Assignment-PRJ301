/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.score;

import controller.login.RBAC;
import data.GroupContext;
import data.StudentContext;
import ennity.Account;
import entity.Role;
import entity.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class StudentGrade extends RBAC {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        String sname = req.getParameter("sname");
        int gid = Integer.parseInt(req.getParameter("gid"));
        int subid = Integer.parseInt(req.getParameter("subid"));

        StudentContext dbstudent = new StudentContext();

        ArrayList<Student> students = dbstudent.list();

        boolean isExisted = false;
        for (Student student : students) {
            if (student.getSid() == sid) {
                isExisted = true;
                resp.getWriter().print("Student existed!");
                break;
            }
        }
        if (!isExisted) {
            dbstudent.addStudent(sid, sname);
            dbstudent.addEnrollment(sid, gid);

            resp.sendRedirect("StudentGrade?subid=" + subid + "&gid=" + gid);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {

        int gid = Integer.parseInt(req.getParameter("gid"));
        int subid = Integer.parseInt(req.getParameter("subid"));

        GroupContext dbGroup = new GroupContext();
        ArrayList<Student> students = dbGroup.getStudentByGroup(gid);
        req.setAttribute("subid", subid);
        req.setAttribute("students", students);
        req.getRequestDispatcher("view/StudentGrade.jsp").forward(req, resp);
    }

}
