package controllers;

import database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentsCreateController", urlPatterns = "/student-create")
public class StudentsCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/jsp/student-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputsurname = req.getParameter("surname");
        String inputname = req.getParameter("name");
        String inputgroup = req.getParameter("group");
        String inputdate = req.getParameter("date");

        if(inputsurname.equals("") || inputname.equals("") || inputgroup.equals("") || inputdate.equals("")){
            req.setAttribute("mm", "qwerty");
            req.getRequestDispatcher("/WEB-INF/jsp/student-create.jsp").forward(req, resp);
        }
        else{
            Database.createStudent(inputsurname,inputname,inputgroup,inputdate);
            resp.sendRedirect("/students");
        }
    }
}
