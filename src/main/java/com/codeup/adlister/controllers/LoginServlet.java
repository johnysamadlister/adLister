package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
            User user = new User();
        if (username.contains("@")){
            user = DaoFactory.getUsersDao().findByEmail(username);
        }else {
            user = DaoFactory.getUsersDao().findByUsername(username);
        }

        boolean validAttempt = BCrypt.checkpw(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);



            if (user.getAdmin()){
                response.sendRedirect("/admin");
                return;
            }
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
