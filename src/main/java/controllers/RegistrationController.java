package controllers;

import database.Database;
import entities.Account;
import entities.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RegistrationController", urlPatterns = "/registration-form")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Role> roles = Database.getRole();
        req.setAttribute("roles", roles);
        req.getRequestDispatcher("WEB-INF/jsp/login-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if(login.equals("") || password.equals("")){
            req.setAttribute("mm", "qwerty");
            ArrayList<Role> roles = Database.getRole();
            req.setAttribute("roles", roles);
            req.getRequestDispatcher("WEB-INF/jsp/login-form.jsp").forward(req, resp);
            return;
        }

        Account account = Database.getAccount(login, password);
        if(account==null){
            req.setAttribute("mm", "account");
            ArrayList<Role> roles = Database.getRole();
            req.setAttribute("roles", roles);
            req.getRequestDispatcher("WEB-INF/jsp/login-form.jsp").forward(req, resp);
            return;
        }


    }
}
