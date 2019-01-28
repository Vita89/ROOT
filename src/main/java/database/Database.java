package database;

import constants.Constants;
import entities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Database {

    public static void main(String[] args) {
        Database database = new Database();
        // Student student = new Student();
        int[] disID = {2, 5, 3};
        // database.createTermDisciplineRelation(2, disID);
        int[] idTerms = {3};
        Database.deleteTerm(idTerms);


    }

    public static List<Student> getAllActiveStudent() {

        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE status = '1'");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setSurname(resultSet.getString("surname"));
                student.setName(resultSet.getString("name"));
                student.setGroup(resultSet.getString("group"));
                student.setDate(resultSet.getDate("entrance_date"));
                student.setStatus(resultSet.getInt("status"));
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static Student getStudentById(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student where id ='" + id + "' ");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setSurname(resultSet.getString("surname"));
                student.setName(resultSet.getString("name"));
                student.setGroup(resultSet.getString("group"));
                student.setDate(resultSet.getDate("entrance_date"));
                student.setStatus(resultSet.getInt("status"));
                return student;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createStudent(String surname, String name, String group, String entranceDate) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            statement.execute("INSERT INTO `student` (`surname`, `name`, `group`, `entrance_date`) VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + entranceDate + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Discipline> getAllDiscipline() {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM discipline where status='1'");
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getInt("id"));
                discipline.setName(resultSet.getString("name"));
                discipline.setStatus(1);
                disciplines.add(discipline);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void createDiscipline(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            statement.execute("INSERT INTO `discipline` (`name`) VALUES ('" + name + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Discipline getDisciplineById(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM discipline where id ='" + id + "' ");
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(id);
                discipline.setName(resultSet.getString("name"));
                return discipline;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void rewriteDiscipline(String name, int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            statement.executeUpdate("UPDATE `discipline` SET `name` = '" + name + "' WHERE ( `id` = '" + id + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyStudent(String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            statement.executeUpdate("UPDATE `student` SET `surname` = '" + surname + "', `name` = '" + name + "', `group` = '" + group + "', `entrance_date` = '" + date + "' WHERE (`id` = '1')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<Term> getAllTerms() {
        ArrayList<Term> terms = new ArrayList<Term>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM term where status='1'");
            while (resultSet.next()) {
                Term term = new Term();
                term.setId(resultSet.getInt("id"));
                term.setName(resultSet.getString("name"));
                term.setDuration(resultSet.getString("duration"));
                term.setStatus(1);
                terms.add(term);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    public static int createTerm(String duration) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM term ORDER BY id DESC limit 1 ");
            String lastNameSemestr = null;
            while (resultSet.next()) {
                lastNameSemestr = resultSet.getString("name");
            }
            String[] lastNameParts = lastNameSemestr.split(" ");
            int numberLastSemestr = Integer.parseInt(lastNameParts[1]);
            numberLastSemestr++;
            String newName = lastNameParts[0] + " " + numberLastSemestr;
            statement.execute("INSERT INTO `term` (`name`, `duration`) VALUES ('" + newName + "', '" + duration + "') ");
            resultSet = statement.executeQuery("SELECT MAX(id) as id FROM term");
            while (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void createTermDisciplineRelation(int termId, String[] disciplinesId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            for (String disciplineId : disciplinesId) {
                statement.execute("INSERT INTO `term_discipline` (`id_term`,`id_discipline`) VALUES ('" + termId + "', '" + disciplineId + "')");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Mark> getMarks(int idStudent, int idTerm) {
        List<Mark> marks = new ArrayList<Mark>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mark\n" +
                    "left join term_discipline as td on id_term_discipline = td.id\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where id_student = " + idStudent + " and td.id_term = " + idTerm + " and d.status = '1'");
            while (resultSet.next()) {
                Mark mark = new Mark();
                mark.setMark(resultSet.getInt("mark"));
                Discipline discipline = new Discipline();
                discipline.setName(resultSet.getString("name"));
                discipline.setId(resultSet.getInt("id_discipline"));
                mark.setDiscipline(discipline);
                marks.add(mark);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }

    public static Term getTermById(String idTerm) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM term where id ='" + idTerm + "'");
            while (resultSet.next()) {
                Term term = new Term();
                term.setId(Integer.parseInt(idTerm));
                term.setName(resultSet.getString("name"));
                term.setDuration(resultSet.getString("duration"));
                return term;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Discipline> getAllDisciplineByTermId(String idTerm) {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM discipline as d left join term_discipline as td on td.id_discipline = d.id where td.id_term = '"+idTerm+"' and td.status = '1' ");
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(Integer.parseInt(idTerm));
                discipline.setName(resultSet.getString("name"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void updateTerm(String idTerm, String duration) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            statement.executeUpdate("UPDATE term\n" +
                    "SET duration = '" + duration + "'\n" +
                    "where id='" + idTerm + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateTermDiscipline(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            statement.execute("UPDATE `term_discipline` SET `status` = '0' WHERE (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int[] idsStudent) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            for (int idSt : idsStudent) {
                statement.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '" + idSt + "');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDiscipline(int[] idDis) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            for (int idD : idDis) {
                statement.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '" + idD + "');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTerm(int[] idTerms) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            for (int idTerm : idTerms) {
                statement.execute("UPDATE `term` SET `status` = '0' WHERE (`id` = '" + idTerm + "');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Role> getRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM role");
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                roles.add(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;

    }

    public static Account getAccount(String login, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account where login = '" + login + "' and passwod = '" + password + "';");
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("passwod"));
                return account;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void deleteDesciplinesFromTerm(String termID) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            statement.execute("UPDATE `term_discipline` SET `status` = '0' WHERE (`id_term` = '"+ termID+"')");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean canAccountLoginWithThisRole(int idAccount, int idRole){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = getConnection(Constants.DATABASE_URL);
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM role_account where id_role='"+ idRole+"' and id_account='"+idAccount +"' ");
            while (resultSet.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
