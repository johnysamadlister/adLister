package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
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

    private long offset = 0;
    private List<Ad> ads = new ArrayList<>();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adlimit = 6;
        ads = DaoFactory.getAdsDao().addToAds(adlimit,offset,ads);
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        offset += 6;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }

    }

