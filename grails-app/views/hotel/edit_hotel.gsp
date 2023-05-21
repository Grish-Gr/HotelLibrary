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
        <g:link controller="country" action="index">Страны</g:link>
    </ul>
</nav>
<div class="main">
    <div style="margin: 16px">
        <g:form controller="hotel" action="editHotel" method="put">
            <g:hiddenField name="id" value="${hotelInfo.id}"/>
            <div class="form-group">
                <label for="hotelName">Название отеля</label>
                <g:textField name="hotelName" required="" placeholder="Название отеля" value="${hotelInfo.name}"/>
            </div>
            <div class="form-group">
                <label for="rating">Рейтинг</label>
                <g:select name="rating" from="[1, 2, 3, 4, 5]"
                          optionValue="" optionKey=""
                          value="${hotelInfo.rating}"/>
            </div>
            <div class="form-group">
                <label for="country">Название страны</label>
                <g:select name="country" from="${countries}"
                          optionValue="" optionKey=""
                          value="${hotelInfo.country.name}"/>
            </div>
            <div class="btn-group">
                <g:submitButton name="editHotel" value="Сохранить изменения" class="btn btn-outline-success"/>
            </div>
        </g:form>
        <g:form controller="hotel" action="deleteHotel" method="delete">
            <g:hiddenField name="id" value="${hotelInfo.id}"/>
            <g:submitButton name="deleteHotel" value="Удалить отель" class="btn btn-outline-warning"/>
        </g:form>
    </div>
</div>
</body>
</html>