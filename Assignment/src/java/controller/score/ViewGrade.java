/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.score;

import controller.login.auth;
import data.ScoreContext;
import ennity.Account;
import entity.Score;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoàng Sơn
 */
public class ViewGrade extends auth {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
       
        int sid = Integer.parseInt(req.getParameter("sid"));
        int subid = Integer.parseInt(req.getParameter("subid"));
        ScoreContext  dbScore= new ScoreContext();
        Score score= dbScore.getGrade(sid, subid);
        req.setAttribute("score", score);
        req.getRequestDispatcher("view/viewgrade.jsp").forward(req, resp);

    }
}
