package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import org.graalvm.compiler.lir.LIRInstruction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null){
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
        }else{
            User user = (User) request.getSession().getAttribute("user");
            request.setAttribute("ads", DaoFactory.getAdsDao().NotUsersAds(user.getUsername()));
        }
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);

    }


    }

