/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.score;

import controller.login.RBAC;
import data.ScoreContext;
import ennity.Account;
import entity.Role;
import entity.Score;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class ViewGrade extends RBAC {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        try {
            int sid = Integer.parseInt(req.getParameter("sid"));
            int subid = Integer.parseInt(req.getParameter("subid"));
            int gid= Integer.parseInt(req.getParameter("gid"));
            ScoreContext dbScore = new ScoreContext();
            Score score = dbScore.getGrade(sid, subid);
            req.setAttribute("score", score);
            req.setAttribute("sid", sid);
            req.setAttribute("subid", subid);
            req.getRequestDispatcher("view/viewgrade.jsp").forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("view/editScore.jsp").forward(req, resp);

        }

    }
}
