<#ftl encoding="utf-8"/>
<!doctype html>
<html lang="ru">

<head>
    <meta charset="utf-8">
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <title>Компания</title>
</head>

<body>
    <a href="/news">Новости</a>
    <#if login??><a href="/logout">Выйти</a>
    <#else><a href="/login">Войти</a></#if>
    <hr/>
    <@content/>
    <hr/>
    <footer class="footer">
        <p>&copy; 2016 Компания</p>
    </footer>
</body>

</html>