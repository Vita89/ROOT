package controllers;

import database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DisciplineDeleteController", urlPatterns = "/discipline-delete")
public class DisciplineDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idS = req.getParameter("idDelete");
        String [] idDiscipline = idS.split(",");
        int [] disciplinesId = new int[idDiscipline.length];
               for (int i = 0; i<idDiscipline.length; i++) {
            disciplinesId[i] = Integer.parseInt(idDiscipline[i]);
        }

        Database.deleteDiscipline(disciplinesId);
        resp.sendRedirect("/disciplines");
    }
}
