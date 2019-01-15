package controllers;

import database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentsDeleteController", urlPatterns = "/delete-student")
public class StudentsDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idS = req.getParameter("studentDelete");
        String[] idStudents = idS.split(",");
        int[] studentsId = new int[idStudents.length];
        for (int i = 0; i < idStudents.length; i++){
            studentsId[i]= Integer.parseInt(idStudents[i]);
        }
        Database.deleteStudent(studentsId);
        resp.sendRedirect("/students");
    }
}
