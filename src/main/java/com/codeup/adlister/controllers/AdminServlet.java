package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user")== null){
            response.sendRedirect("/login");
        }else{

            User user = (User) request.getSession().getAttribute("user");


            if (user.getAdmin()){
                try {
                    request.setAttribute("users", DaoFactory.getUsersDao().list());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/WEB-INF/admin.jsp")
                        .forward(request, response);

            }else{
                response.sendRedirect("/profile");
            }

        }
    }

}
