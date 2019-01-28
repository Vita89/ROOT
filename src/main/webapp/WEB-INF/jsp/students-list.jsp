<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список студентов</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
    <script src="../../resources/js/functions.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>
<c:choose>
    <c:when test="${login=='true'}">
        <a href="/logout" class="logout-link">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="/registration-form" class="logout-link">Login</a>
    </c:otherwise>
</c:choose>
<a href="/" class="main-link links">На главную</a>
<div id="student-list-buttons">
    <div class="display-flex">
        <input type="submit" value="Просмотреть успеваемость студентов" class="big-button" onclick="studentProgress()">

        <form action="/student-create" method="get">
            <c:if test="${role == '1'}">
                <input type="submit" value="Создать студента..." class="small-button">
            </c:if>
        </form>

    </div>
    <div class="display-flex">
        <c:if test="${role == '1'}">
            <input type="submit" value="Модифицировать выбранного студента" class="big-button"
                   onclick="modifyStudent()">
        </c:if>

        <form action="/student-modify" method="get" id="student-modify-form">
            <input type="hidden" , name="studentIdHidden" , id="studentIdHidden">
        </form>

        <form action="/student-progress" method="get" id="student-progress-form">
            <input type="hidden" id="studentIdProgress" name="studentIdProgress">
        </form>

        <c:if test="${role == '1'}">
            <input type="submit" value="Удалить выбранных студентов" class="small-button" onclick="deleteStudents()">
        </c:if>
        <form action="/delete-student" method="post" id="delete-student-form">
            <input type="hidden" name="studentDelete" id="studentDelete">
        </form>
    </div>
</div>

<div id="student-list-table">
    <p>Список студентов</p>
    <table class="main-info-table">
        <tr>

            <th class="checkbox-narrow"></th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>

        </tr>

        <c:forEach items="${students}" var="student">
            <tr>

                <td class="aling-right"><input type="checkbox" id="${student.id}"></td>

                <td>${student.surname}</td>
                <td>${student.name}</td>
                <td>${student.group}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy"
                                    value="${student.date}"/></td>
            </tr>
        </c:forEach>


    </table>
</div>


</body>
</html>