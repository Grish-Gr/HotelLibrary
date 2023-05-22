<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменить страну</title>
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
        <g:form controller="country" action="editCountry" method="put">
            <g:hiddenField name="id" value="${country.id}"/>
            <div class="form-group">
                <label for="countryName">Название страны</label>
                <g:textField name="countryName" required="" placeholder="Название страны" value="${country.name}"/>
            </div>
            <div class="form-group">
                <label for="capitalName">Название столицы</label>
                <g:textField name="capitalName" required="" placeholder="Название столицы" value="${country.capital}"/>
            </div>
            <div class="btn-group">
                <g:submitButton name="editCountry" value="Сохранить изменения" class="btn btn-outline-success"/>
            </div>
        </g:form>
        <g:form controller="country" action="deleteCountry" method="delete">
            <g:hiddenField name="id" value="${country.id}"/>
            <g:submitButton name="deleteHotel" value="Удалить страну (${country.name})" class="btn btn-outline-warning"/>
        </g:form>
    </div>
</div>
</body>
</html>