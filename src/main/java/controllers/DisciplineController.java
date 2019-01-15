package controllers;

import database.Database;
import entities.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisciplineController", urlPatterns = "/disciplines")
public class DisciplineController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       List<Discipline> disciplineList = Database.getAllDiscipline();
       req.setAttribute("disciplines", disciplineList);
        req.getRequestDispatcher("/WEB-INF/jsp/disciplines.jsp").forward(req,resp);
    }
}
