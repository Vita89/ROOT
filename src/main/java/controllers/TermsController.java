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
import java.util.List;

@WebServlet(name = "TermsController", urlPatterns = "/terms")
public class TermsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Term> termsList = Database.getAllTerms();
        Term selectedterm = termsList.get(0);
        List<Discipline> disciplinesList = Database.getAllDisciplineByTermId(selectedterm.getId());

        req.setAttribute("terms", termsList);
        req.setAttribute("selectedTerm", selectedterm);
        req.setAttribute("disciplines", disciplinesList);
        req.getRequestDispatcher("/WEB-INF/jsp/terms.jsp").forward(req,resp);
    }
}
