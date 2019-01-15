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

        String disciplinesName = req.getParameter("disciplines");
        String [] disciplines = disciplinesName.split(",");
        String [] disNames = new String[disciplines.length];
        System.out.println();
        for(int i = 0; i < disciplines.length; i++)
        {
            disNames[i] = disciplines[i];
        }

        if (inputDuration.equals("")) {
            req.setAttribute("mm", "qwerty");
            req.getRequestDispatcher("WEB-INF/jsp/term-create").forward(req,resp);
        } else {
            Database.createTerm(inputDuration);
            resp.sendRedirect("/terms");
        }
    }
}
