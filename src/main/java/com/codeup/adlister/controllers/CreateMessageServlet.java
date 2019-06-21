package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Message;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/messages/create")
public class CreateMessageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/messages/create.jsp")
                .forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        User recipient = (User) request.getSession().setAttribute().getUser();
        Ad ad = (Ad) request.getSession().getAttribute("messageAd");



        Message message = new Message(
                date,
                user.getId(),
                request.getParameter("recipient_id"),
                request.getParameter("message_id"),
                request.getParameter("body")
        );

        DaoFactory.getMessagesDao().insert(message);
        response.sendRedirect("/messages");
    }
}