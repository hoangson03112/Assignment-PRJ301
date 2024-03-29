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
        int sid = Integer.parseInt(req.getParameter("sid"));
        int subid = Integer.parseInt(req.getParameter("subid"));
        ScoreContext dbScore = new ScoreContext();
        String mode = "";

        try {
            req.setAttribute("sid", sid);
            req.setAttribute("subid", subid);
            Score score = dbScore.getGrade(sid, subid);
            req.setAttribute("score", score);
            req.getRequestDispatcher("view/viewgrade.jsp").forward(req, resp);
        } catch (Exception e) {
            mode = "add";
            req.setAttribute("mode", mode);
            req.getRequestDispatcher("view/addScore.jsp").forward(req, resp);
        }
    }
}
