package controllers;

import database.Database;
import entities.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "StudentsListController", urlPatterns = "/students")
public class StudentsListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = Database.getAllActiveStudent();
        req.setAttribute("students",students);
        req.getRequestDispatcher("/WEB-INF/jsp/students-list.jsp").forward(req,resp);

    }
}
