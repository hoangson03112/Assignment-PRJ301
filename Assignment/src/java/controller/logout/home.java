/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.home;

import controller.login.auth;
import ennity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoàng Sơn
 */
public class home extends auth {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account  account) throws ServletException, IOException {
      
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        req.getRequestDispatcher("view/home.jsp").forward(req, resp);
    }

}
