<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Главная</title>
    <asset:stylesheet src="main.css"/>
    <asset:stylesheet src="bootstrap.css"/>
</head>

<body>
<nav class="navigation_block">
    <ul>
        <g:link controller="home" action="home">Главная</g:link>
        <g:link controller="hotel" action="hotels">Отели</g:link>
        <g:link controller="country" action="countries">Страны</g:link>
    </ul>
</nav>
<div class="main">
    <div style="margin: 16px">
        <g:form controller="country" action="createCountry" method="post">
            <div class="form-group">
                <label for="countryName">Название страны</label>
                <g:textField name="countryName" required="" placeholder="Название страны"/>
            </div>
            <div class="form-group">
                <label for="capitalName">Столица</label>
                <g:textField name="capitalName" required="" placeholder="Название столицы"/>
            </div>
            <div class="btn-group">
                <g:submitButton name="createCountry" value="Добавить страну" class="btn btn-outline-success"/>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>