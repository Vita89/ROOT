package controllers;

import database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineCreateController",urlPatterns = "/discipline-create")
public class DisciplineCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/discipline-create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputName = req.getParameter("newDiscipline");

        if(inputName.equals("")){
            req.setAttribute("mm","qwerty");
            req.getRequestDispatcher("WEB-INF/jsp/discipline-create.jsp").forward(req,resp);
        } else {
            Database.createDiscipline(inputName);
            resp.sendRedirect("/disciplines");
        }


    }
}
