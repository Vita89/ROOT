package controllers;

import database.Database;
import entities.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static database.Database.modifyStudent;

@WebServlet(name = "StudentModifyController", urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStudent = req.getParameter("studentIdHidden");
        Student idSelected = Database.getStudentById(Integer.parseInt(idStudent));
        req.setAttribute("student", idSelected);
        req.getRequestDispatcher("WEB-INF/jsp/student-modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String surname = req.getParameter("studentSurname");
        String name = req.getParameter("studentName");
        String group = req.getParameter("studentGroup");
        String date = req.getParameter("studentEntranceDate");
        modifyStudent(surname, name,group,date);
        resp.sendRedirect("/students");

    }
}
