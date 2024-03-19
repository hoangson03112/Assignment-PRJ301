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
public class updateScore extends RBAC {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        int subid= Integer.parseInt(req.getParameter("subid"));
        int sid= Integer.parseInt(req.getParameter("sid"));
        int gid= Integer.parseInt(req.getParameter("gid"));
        
        ScoreContext dbs= new ScoreContext();
        Score s= dbs.getGrade(sid, subid);
        System.out.println(s.getProject().getValue());
        req.setAttribute("gid", gid);
        req.setAttribute("score", s);
        
        req.getRequestDispatcher("view/updateScore.jsp").forward(req, resp);
    }
   

}
