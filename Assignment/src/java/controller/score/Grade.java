/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.score;

import controller.login.auth;
import data.GroupContext;
import data.SubjectContext;
import ennity.Account;
import entity.StudentGroup;
import entity.Subject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class Grade extends auth {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        String raw_subid = req.getParameter("subid");
        int subid = 0;
        if (raw_subid != null) {
            subid = Integer.parseInt(raw_subid);
            GroupContext dbgr= new GroupContext();
               ArrayList<StudentGroup> grs = dbgr.list(subid);
            
               req.setAttribute("grs", grs);
        }

        SubjectContext dbSubject = new SubjectContext();
        ArrayList<Subject> sus = dbSubject.list();
        req.setAttribute("sus", sus);
        req.setAttribute("subid", subid);

        req.getRequestDispatcher("view/Grade.jsp").forward(req, resp);
    }

}
