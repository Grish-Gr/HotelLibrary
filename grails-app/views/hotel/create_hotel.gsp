<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Добавить отель</title>
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
        <g:if test="${countries.size() > 0}">
            <g:form controller="hotel" action="createHotel" method="post">
                <g:hiddenField name="id"/>
                <div class="form-group">
                    <label for="hotelName">Название отеля</label>
                    <g:textField name="hotelName" required="" placeholder="Название отеля"/>
                </div>
                <div class="form-group">
                    <label for="linkToWebsite">Ссылка на сайт</label>
                    <input type="url" name="linkToWebsite"
                           id="linkToWebsite" placeholder="https://your-hotel.com"/>
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
        </g:if>
        <g:else>
            <h4 class="text-danger">Невозможно добавить отель, отсутствуют доступные страны</h4>
            <g:link controller="country" action="country">
                <button class="btn btn-outline-primary">Добавить в базу страну</button>
            </g:link>
        </g:else>
    </div>
</div>
</body>
</html>