/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.attendence;

import controller.login.auth;
import data.AttendanceContext;
import data.LessionContext;
import data.StudentContext;
import ennity.Account;
import entity.Attendence;
import entity.Lession;
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
public class takeattendence extends auth {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {

        StudentContext stuDB = new StudentContext();
        AttendanceContext db = new AttendanceContext();
        ArrayList<Attendence> atts = new ArrayList<>();
        String raw_leid = req.getParameter("leid");
        String raw_lid = req.getParameter("lid");

        int leid = Integer.parseInt(raw_leid);
        int lid = Integer.parseInt(raw_lid);

        Lession lession = new Lession();
        lession.setId(leid);
        lession.setAttended(true);

        ArrayList<Student> students = stuDB.getByLession(leid);
        for (Student student : students) {
            Attendence a = new Attendence();
            a.setLession(lession);
            a.setStudent(student);
            a.setDescription(req.getParameter("description" + student.getSid()));
            a.setPresent(req.getParameter("present" + student.getSid()).equals("yes"));

            atts.add(a);
        }

        db.updateByLession(leid, atts);
        resp.sendRedirect("attendance?lid=" + lid + "&leid=" + leid);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp,
            Account account) throws ServletException, IOException {
        int leid = Integer.parseInt(req.getParameter("leid"));
        LessionContext db = new LessionContext();
        ArrayList<Attendence> atts = new ArrayList<>();
        req.setAttribute("leid", leid);

        atts = db.getAttendencesBy(leid);

        req.setAttribute("atts", atts);
        req.getRequestDispatcher("view/att.jsp").forward(req, resp);
    }

}
