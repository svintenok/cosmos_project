<#ftl encoding="utf-8"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">

    <title>Cosmos project</title>

    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.css">

    <@style/>

    <script type="text/javascript" src="static/jquery/jquery-3.1.1.js"></script>

</head>


<body>


<header>
    <nav class="navbar navbar-fixed-top navbar-inverse">
        <div class="container">
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><img src="files/logo.jpg" style="height: 81px; width: 223px; margin-right: 40px;"/></li>
                <#if current_user??>
                    <li><a href="/profile?id=${current_user.id}"><h5>Профиль</h5></a></li>
                    <li><br><h5>|</h5></li>
                </#if>
                    <li><a href="/tours?page=1"><h5>Туры</h5></a></li>
                    <li><br><h5>|</h5></li>
                    <li><a href="/news?page=1"><h5>Новости</h5></a></li>
                    <li><br><h5>|</h5></li>
                    <li><a href="/forum"><h5>Форум</h5></a></li>
                    <li><br><h5>|</h5></li>
                    <li><a href="/about"><h5>О нас</h5></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <#if current_user??>
                    <li><a href="/logout"><h5>Выход</h5></a></li>
                <#else>
                    <li><a href="/login"><h5>Вход</h5></a></li>
                </#if>
                </ul>
            </div>
        </div>
    </nav>
</header>

<@content/>


<footer>
    <div id="footer">
        <div id="footer-logo">Copyright © 2016 Cosmos project creation</p></div>
    </div>
</footer>

</body>

<script type="text/javascript" src="static/bootstrap/js/bootstrap.js"></script>

</html>