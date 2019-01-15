<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Прогресс студента</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>
<a href="/logout" class="logout-link">Logout</a>
<a href="/" class="links main-link">На главную</a>
<a href="/students" class="links back-link">Назад</a>
<h3>Отображена успеваемость следующего студента</h3>
<div class="container" id="student-progress-page">

    <table class="main-info-table short-table">
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
        </tr>

        <tr>
            <td>${student.surname}</td>
            <td>${student.name}</td>
            <td>${student.group}</td>
            <td><fmt:formatDate pattern="dd/MM/yyyy"
                                value="${student.date}"/></td>
        </tr>

    </table>


    <div class="marks-table-with-semestrs">
        <table class="main-info-table narrow-table">
            <tr>
                <th class="th-width80">Наименование дисциплины</th>
                <th>Оценка</th>
            </tr>
            <c:forEach items="${marks}" var="mark">
                <tr>
                    <td>${mark.discipline.name}</td>
                    <td>${mark.mark}</td>
                </tr>

            </c:forEach>


        </table>
        <div class="select-semestr">
            <label>Выбрать семестр</label>
            <form action="/student-progress-choose" method="post">
                <select name="selectTerm">
                    <c:forEach items="${terms}" var="term">
                        <c:choose>
                            <c:when test="${term.id == selectedTerm.id}">
                                <option value="${term.id}" selected>${term.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${term.id}">${term.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <input type="submit" value="Выбрать">
                <p>Средняя оценка за семестр: ${average} балла</p>
                <input type="hidden" name="studentIdProgress" value="${student.id}">
            </form>
        </div>
    </div>


</div>

</body>
</html>
