<#include "base.ftl">

<#macro content>
    <div class="container">
        <form class="form-inline" action="/login" method="POST">
            <input type="text" name="login" <#if login??> value="${login}"</#if>/>
            <input type="password" name="password"/>
            <label class="checkbox">
                <input type="checkbox" name="remember" value="remember-me"/> Запомнить меня
            </label>
            <input type="submit" value="Войти"/>
        </form>
        <a href="/registration">Регистрация</a>
        <#if err??><p>Неправильный логин или пароль</p></#if>
    </div>
</#macro>
