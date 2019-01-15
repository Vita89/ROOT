package controllers;

import database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "TermDeleteController", urlPatterns = "/term-delete")
public class TermDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTermDelete = req.getParameter("idTermDelete");
        String [] idTerm = idTermDelete.split(",");

        int [] termsId = new int[idTerm.length];
        for (int i = 0; i<idTerm.length; i++) {
            termsId[i] = Integer.parseInt(idTerm[i]);
        }

        Database.deleteTerm(termsId);
        resp.sendRedirect("/terms");


    }
}
