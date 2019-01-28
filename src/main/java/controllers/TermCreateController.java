package controllers;

import database.Database;
import entities.Discipline;
import entities.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TermCreateController", urlPatterns = "/term-create")
public class TermCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> disciplinesList = Database.getAllDiscipline();
        List<Term> termsList = Database.getAllTerms();

        req.setAttribute("terms", termsList);
        req.setAttribute("disciplines", disciplinesList);
        req.getRequestDispatcher("WEB-INF/jsp/term-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputDuration = req.getParameter("duration");

        String[] disciplinesName = req.getParameterValues("disciplines");

        if (inputDuration.equals("")) {
            req.setAttribute("message", "empty_duration");
            List<Discipline> disciplinesList = Database.getAllDiscipline();
            req.setAttribute("disciplines", disciplinesList);
            req.getRequestDispatcher("WEB-INF/jsp/term-create.jsp").forward(req, resp);
        } else {
          int idNewTerm =  Database.createTerm(inputDuration);
            Database.createTermDisciplineRelation(idNewTerm, disciplinesName);
            resp.sendRedirect("/terms");
        }
    }
}
