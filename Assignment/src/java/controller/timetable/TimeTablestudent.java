/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.timetable;

import controller.login.RBAC;
import controller.login.auth;
import data.AttendanceContext;
import data.LessionContext;
import data.SlotContext;
import ennity.Account;
import entity.Attendence;
import entity.Lession;
import entity.Role;
import entity.TimeSlot;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import util.DateTimeHelper;

/**
 *
 * @author Hoàng Sơn
 */
public class TimeTablestudent extends RBAC {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
         String r_sid = req.getParameter("sid");
            int sid = Integer.parseInt(r_sid);
       

        String raw_from = req.getParameter("from");

        String raw_to = req.getParameter("to");

        Date today = new Date();

        java.sql.Date from = null;
        java.sql.Date to = null;

        if (raw_from == null) {
            from = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.getWeekStart(today));
        } else {
            from = java.sql.Date.valueOf(raw_from);
        }

        if (raw_to == null) {
            to = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.
                    addDaysToDate(DateTimeHelper.getWeekStart(today), 6));
        } else {
            to = java.sql.Date.valueOf(raw_to);
        }
        ArrayList<java.sql.Date> dates = DateTimeHelper.getDatesBetween(from, to);
      
        SlotContext slotDB = new SlotContext();
        ArrayList<TimeSlot> slots = slotDB.getTimeSlot();

        LessionContext lessDB = new LessionContext();
        ArrayList<Lession> lessions = lessDB.getBySid(sid, from, to);
        AttendanceContext dbatts= new AttendanceContext();
        ArrayList<Attendence> atts= dbatts.getAtts(sid);
        req.setAttribute("atts", atts);
        req.setAttribute("sid", sid);
        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.setAttribute("slots", slots);
        req.setAttribute("dates", dates);
        req.setAttribute("lessions", lessions);
        
        req.getRequestDispatcher("view/timetablestudent.jsp").forward(req, resp);
    }

}
