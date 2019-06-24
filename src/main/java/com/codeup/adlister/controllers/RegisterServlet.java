package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String img = request.getParameter("img");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        String errormessage = "";

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            errormessage = "Passwords must match.";
            request.getSession().setAttribute("error", errormessage);
            response.sendRedirect("/register");
            return;
        }

        boolean userAlreadyExists = (DaoFactory.getUsersDao().findByUsername(username) != null);

        if (userAlreadyExists) {
            errormessage = "That Username already exists.";
            request.getSession().setAttribute("error", errormessage);
            response.sendRedirect("/register");
            return;
        }

        boolean emailAlreadyExists = (DaoFactory.getUsersDao().findByEmail(email) != null );

        if (emailAlreadyExists) {
            errormessage = "That e-mail is already in use.";
            request.getSession().setAttribute("error", errormessage);
            response.sendRedirect("/register");
            return;
        }

        boolean containsInvalidSymbol =
                   username.contains("@")
                || username.contains("*")
                || username.contains("&")
                || username.contains("#")
                || username.contains("%")
                || username.contains("!")
                || username.contains("$")
                || username.contains("^")
                || username.contains("~");

        if (containsInvalidSymbol) {
            errormessage = "Username cannot contain Special Symbols.";
            request.getSession().setAttribute("error", errormessage);
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        System.out.println(img);


            img = "img/default_profile.png";
            String hash_word = BCrypt.hashpw(password, BCrypt.gensalt());
            User user = new User(username, email, hash_word);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");

    }
}
