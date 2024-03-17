/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.login;

import data.AccoutContext;
import ennity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Hoàng Sơn
 */
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        String remember = req.getParameter("remember");

        HttpSession session = req.getSession(); 
        AccoutContext db = new AccoutContext();
        Account account = db.getAccout(username, pass);
        if (account != null) {
            if (remember != null) {
                Cookie c_user = new Cookie("username", account.getUser().trim());
                Cookie c_pass = new Cookie("password", account.getPass().trim());
                Cookie c_remember = new Cookie("remember", remember);
              
                c_user.setMaxAge(1800);
                  
                c_pass.setMaxAge(1800);
                c_remember.setMaxAge(1800);
                resp.addCookie(c_pass);
                resp.addCookie(c_user);
                resp.addCookie(c_remember);

            }
            session.setAttribute("account", account);
            resp.sendRedirect("home");
        } else {
            resp.sendRedirect("view/404.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        boolean isRemember = false;
        if (cookies != null) {
            
            for (Cookie cookie : cookies) {
                
                System.out.println(cookie.getName()+":"+cookie.getName());
                if (cookie.getName().equals("remember") && cookie.getValue().equals("remember")) {
                    isRemember = true;
                    resp.sendRedirect("home");
                    break;
                }
            }
        }
        if (!isRemember) {
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        }

    }

}
