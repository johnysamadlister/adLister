package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
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

        request.setAttribute("categories",DaoFactory.getCategoriesDao().list());

        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Category> categories = DaoFactory.getCategoriesDao().list();

        ArrayList<String> category = new ArrayList<>();

        for(int x = 0; x < categories.size(); x++ ){
            String cat = "category"+x;

            if (request.getParameter(cat) != null){
                category.add(categories.get(x).getCategory_name());
            }
        }

        System.out.println(category.toString());


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


        response.sendRedirect("/ads");

    }
}