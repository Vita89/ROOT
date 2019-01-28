<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Модификация учётной записи студента</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
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
<a href="/students" class="back-link links">Назад</a>

<h3>Для модификации, введите новые значения и нажмите кнопку "Применить".</h3>

<div class="container" id="student-create-page">
    <form action="/student-modify" method="post">
        <input type="hidden" value="${student.id}" name="studentId">

    <div>
        <label>Фамилия</label>
        <input type="text" value="${student.surname}" name="studentSurname">
    </div>

    <div>
        <label>Имя</label>
        <input type="text" value="${student.name}" name="studentName">
    </div>

    <div>
        <label>Группа</label>
        <input type="text" value="${student.group}" name="studentGroup">
    </div>

    <div>
        <label>Дата поступления</label>
        <input type="text" value="<fmt:formatDate pattern = "dd/MM/yyyy"
                                value = "${student.date}" />" name="studentEntranceDate" id="datepicker">
    </div>

    <div>
        <input type="submit" value="Создать">
    </div>
    </form>
</div>
</body>
</html>
