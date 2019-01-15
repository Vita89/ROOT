package controllers;

import database.Database;
import entities.Mark;
import entities.Student;
import entities.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChooseTermOnPageStudentProgressController", urlPatterns = "/student-progress-choose")
public class ChooseTermOnPageStudentProgressController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = req.getParameter("selectTerm");

        String idStudent = req.getParameter("studentIdProgress");
        Student idSelected = Database.getStudentById(Integer.parseInt(idStudent));
        req.setAttribute("student", idSelected);

        List<Term> termsList = Database.getAllTerms();
        Term selectedterm = Database.getTermById(idTerm);
        List<Mark> marks = Database.getMarks(Integer.parseInt(idStudent), selectedterm.getId());
        double totalMark = 0;
        if (marks.size() == 0) {
            double average = 0;
            req.setAttribute("average", average);
        } else {
            for (Mark currentmark : marks) {
                totalMark = totalMark + currentmark.getMark();
            }
            double average = totalMark / marks.size();
            req.setAttribute("average", average);
        }

        req.setAttribute("terms", termsList);
        req.setAttribute("selectedTerm", selectedterm);
        req.setAttribute("marks", marks);
        req.getRequestDispatcher("WEB-INF/jsp/student-progress.jsp").forward(req, resp);

    }
}
