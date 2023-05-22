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
        <g:form controller="hotel" action="createHotel" method="post">
            <g:hiddenField name="id"/>
            <div class="form-group">
                <label for="hotelName">Название отеля</label>
                <g:textField name="hotelName" required="" placeholder="Название отеля"/>
            </div>
            <div class="form-group">
                <label for="linkToWebsite">Столица</label>
                <g:textField type="url" name="linkToWebsite" required="false" placeholder="Ссылка на сайт"/>
            </div>
            <div class="form-group">
                <label for="rating">Рейтинг</label>
                <g:select name="rating" from="[1, 2, 3, 4, 5]"/>
            </div>
            <div class="form-group">
                <label for="country">Название страны</label>
                <g:select name="country" from="${countries}"/>
            </div>
            <div class="btn-group">
                <g:submitButton name="editHotel" value="Добавить отель" class="btn btn-outline-success"/>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>