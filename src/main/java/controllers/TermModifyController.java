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

@WebServlet(name = "TermModifyController", urlPatterns = "/term-modify")
public class TermModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> disciplinesList = Database.getAllDiscipline();

        req.setAttribute("disciplines", disciplinesList);
        req.getRequestDispatcher("WEB-INF/jsp/term-modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String termId = req.getParameter("termId");
        String duration = req.getParameter("duration");
        Database.updateTerm(termId,duration );
        resp.sendRedirect("/terms");
    }
}
