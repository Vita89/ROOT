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
        String idTerm = req.getParameter("termIdModify");
        Term idSelected = Database.getTermById(idTerm);
        req.setAttribute("term", idSelected);
        List<Discipline> disciplinesList = Database.getAllDiscipline();
        req.setAttribute("disciplines", disciplinesList);

        req.getRequestDispatcher("WEB-INF/jsp/term-modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String termId = req.getParameter("termId");
        String duration = req.getParameter("duration");
        String[] disciplinesId = req.getParameterValues("disciplines");

        Database.updateTerm(termId, duration);
        Database.deleteDesciplinesFromTerm(termId);
        Database.createTermDisciplineRelation(Integer.parseInt(termId), disciplinesId);

        resp.sendRedirect("/terms");
    }
}
