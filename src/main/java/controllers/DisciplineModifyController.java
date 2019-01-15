package controllers;

import database.Database;
import entities.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineModifyController", urlPatterns = "/discipline-modify")
public class DisciplineModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDiscipline = req.getParameter("selectedId");

        Discipline disciplineSelected = Database.getDisciplineById(Integer.parseInt(idDiscipline));
        req.setAttribute("discipline",disciplineSelected);
        req.getRequestDispatcher("WEB-INF/jsp/discipline-modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDis = req.getParameter("disId");
        String nameDis = req.getParameter("disName");
        Database.rewriteDiscipline(nameDis,Integer.parseInt(idDis));
        resp.sendRedirect("/disciplines");
    }
}
