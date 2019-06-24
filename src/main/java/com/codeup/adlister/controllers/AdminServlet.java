package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user")== null){
            response.sendRedirect("/login");
        }else{

            User user = (User) request.getSession().getAttribute("user");

            System.out.println(user.getUsername());
            System.out.println(user.getAdmin());

            if (user.getAdmin()){
                request.getRequestDispatcher("/WEB-INF/admin.jsp")
                        .forward(request, response);

            }else{
                response.sendRedirect("/profile");
            }

        }
    }

}
