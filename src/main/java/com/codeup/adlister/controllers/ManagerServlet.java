package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagerServlet {
    @WebServlet(name = "controllers.ManagerServlet", urlPatterns = "/manager")
    public class ViewProfileServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            User user = (User) request.getSession().getAttribute("user");
            if (user.getUsername() != "admin" ){
                response.sendRedirect("/profile");
            }

            request.getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);

        }
    }
}
