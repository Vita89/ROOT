<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="../../resources/css/styles.css" type='text/css' media='all'/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>
</head>
<body>
<h1>Система управления студентами и их успеваемостью</h1>

    <div class="container" id="student-create-page">
<form action="/registration-form" method="post">
    <div>
        <label>Login</label>
        <input name="login" type="text">
    </div>

    <div>
        <label>Password</label>
        <input name="password" type="text">
    </div>

    <div>
        <label>Выбирите роль</label>
        <select name="role">
            <c:forEach items="${roles}" var="role">
                <option value="${role.id}">${role.name}</option>
            </c:forEach>
        </select>
    </div>

    <div>
        <input type="submit" value="Войти">
        <c:if test="${mm == 'qwerty'}">
            <div class="bad-writing">
                <i>Поля не должны быть пустыми!</i>
            </div>
        </c:if>
        <c:if test="${mm == 'account'}">
            <div class="bad-writing">
                <i>Такого пользователя не существует!</i>
            </div>
        </c:if>
    </div>


</form>


    </div>

</body>
</html>
