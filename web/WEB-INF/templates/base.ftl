<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <title>Document</title>
</head>

<body>
    <a href="/news">News</a>
    <#if username??><a href="/logout">Logout</a>
    <#else><a href="/login">Login</a></#if>
    <hr/>
    <@content/>
    <hr/>
    <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
    </footer>
</body>

</html>