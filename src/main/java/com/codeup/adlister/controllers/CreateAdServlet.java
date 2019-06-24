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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        String adimg = request.getParameter("img");

        ArrayList<String> category = new ArrayList<>();

        if (request.getParameter("cat1") != null) {
            category.add(request.getParameter("cat1"));
        }

        if (request.getParameter("cat2") != null) {
            category.add(request.getParameter("cat2"));
        }

        if (request.getParameter("cat3") != null) {
            category.add(request.getParameter("cat3"));
        }

        if (request.getParameter("cat4") != null) {
            category.add(request.getParameter("cat4"));
        }

        if (request.getParameter("cat5") != null) {
            category.add(request.getParameter("cat5"));
        }

        if (request.getParameter("cat6") != null) {
            category.add(request.getParameter("cat6"));
        }

        System.out.println(category.toString());

        if (adimg == null) {
            adimg = "img/default_profile.png";
        }

        Ad ad = new Ad(
                user.getId(), // for now were not gonna hard code a user.
                request.getParameter("title"),
                request.getParameter("description")
        );
        long id = DaoFactory.getAdsDao().insert(ad);
        try {
            DaoFactory.getCategoriesDao().insert(category, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/profile");
        response.sendRedirect("/ads");
    }
}