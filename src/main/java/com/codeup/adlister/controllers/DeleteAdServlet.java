package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/profile/deleteAd")
public class DeleteAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("ad_id"));
        DaoFactory.getAdsDao().deleteAd(id);

        User user = (User) request.getSession().getAttribute("user");

        if (user.getAdmin()){
            response.sendRedirect("/admin");
            return;
        }
        response.sendRedirect("/profile");
    }
}
