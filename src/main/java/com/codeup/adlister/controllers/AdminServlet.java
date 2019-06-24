package com.codeup.adlister.controllers;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



    @WebServlet(name = "controllers.AdminServlet", urlPatterns = "/admin")
    public class AdminServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            if (request.getParameter("user") == null){
                response.sendRedirect("/login");
            }

            User user = (User) request.getSession().getAttribute("user");
            if (!user.getAdmin()){
                response.sendRedirect("/profile");
            }

            request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);

        }
    }

