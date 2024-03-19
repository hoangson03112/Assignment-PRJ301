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
import entity.score.Active_learning;
import entity.score.Ass_1;
import entity.score.Ass_2;
import entity.score.Computer_Project;
import entity.score.FE;
import entity.score.PE;
import entity.score.PT_1;
import entity.score.PT_2;
import entity.score.PT_3;
import entity.score.Presentation;
import entity.score.Project;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class addScore extends RBAC {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        Active_learning Active_learning = new Active_learning();
        Computer_Project cp = new Computer_Project();
        Presentation Presentation = new Presentation();
        Ass_2 ass2 = new Ass_2();
        Ass_1 ass1 = new Ass_1();
        PT_2 p2 = new PT_2();
        PT_1 p1 = new PT_1();
        PT_3 p3 = new PT_3();
        Project pj = new Project();
        FE f = new FE();
        PE p = new PE();

        int gid = Integer.parseInt(req.getParameter("gid"));
        int sid = Integer.parseInt(req.getParameter("sid"));
        int subid = Integer.parseInt(req.getParameter("subid"));

        double Acl = 0;
        if (req.getParameter("Active_learning").length() != 0) {
            Acl = Double.parseDouble(req.getParameter("Active_learning"));
        }
        Active_learning.setValue(Acl);

        double Pre = 0;
        if (req.getParameter("Presentation").length() != 0) {
            Pre = Double.parseDouble(req.getParameter("Presentation"));

        }
        Presentation.setValue(Pre);

        double Computer_Project = 0;

        if (req.getParameter("Computer_Project").length() != 0) {
            Computer_Project = Double.parseDouble(req.getParameter("Computer_Project"));

        }
        cp.setValue(Computer_Project);

        double A1 = 0;
        if (req.getParameter("Assignment_1").length() != 0) {
            A1 = Double.parseDouble(req.getParameter("Assignment_1"));

        }

        ass1.setValue(A1);

        double A2 = 0;
        if (req.getParameter("Assignment_2").length() != 0) {
            A2 = Double.parseDouble(req.getParameter("Assignment_2"));

        }

        ass2.setValue(A2);

        double PT_1 = 0;
        if (req.getParameter("PT_1").length() != 0) {
            PT_1 = Double.parseDouble(req.getParameter("PT_1"));

        }

        p1.setValue(PT_1);

        double PT_2 = 0;
        if (req.getParameter("PT_2").length() != 0) {
            PT_2 = Double.parseDouble(req.getParameter("PT_2"));

        }
        p2.setValue(PT_2);
        double PT_3 = 0;

        if (req.getParameter("PT_3").length() != 0) {
            PT_3 = Double.parseDouble(req.getParameter("PT_3"));

        }

        p3.setValue(PT_3);

        double Project = 0;
        if (req.getParameter("Project").length() != 0) {
            Project = Double.parseDouble(req.getParameter("Project"));

        }

        pj.setValue(Project);
        double PE = 0;
        if (req.getParameter("PE").length() != 0) {
            PE = Double.parseDouble(req.getParameter("PE"));

        }

        p.setValue(PE);
        double FE = 0;
        if (req.getParameter("FE").length() != 0) {
            FE = Double.parseDouble(req.getParameter("FE"));

        }

        f.setValue(FE);
        Score score = new Score(Active_learning, Presentation, cp, ass1, ass2, p1, p2, p3, pj, p, f);

        ScoreContext db = new ScoreContext();
        db.addScore(sid, subid, score);
        resp.sendRedirect("StudentGrade?subid=" + subid + "&gid=" + gid);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<Role> roles) throws ServletException, IOException {
        ScoreContext dbScore = new ScoreContext();
        Score score = dbScore.getGrade(Integer.parseInt(req.getParameter("sid ")), Integer.parseInt(req.getParameter("subid")));
        String mode = req.getParameter("mode");
        req.setAttribute("mode", mode);
        req.setAttribute("score", score);
        req.getRequestDispatcher("view/editScore.jsp").forward(req, resp);

    }

}
