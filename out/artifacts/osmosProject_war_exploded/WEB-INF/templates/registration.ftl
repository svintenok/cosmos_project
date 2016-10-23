<#include "base.ftl">

<#macro content>
<div class="container">
    <form class="form-inline" action="/registration" method="POST" accept-charset="utf-8">

        <input type="text" name="login" placeholder="логин" <#if login??> value="${login}"</#if>/>

        <input type="text" name="password" placeholder="пароль"/>

        <input type="text" name="name" placeholder="имя" <#if name??> value="${name}"</#if>/>

        <input type="text" name="email" placeholder="почта" <#if email??> value="${email}"</#if>/>

        <input type="text" name="country" placeholder="страна" <#if country??> value="${country}"</#if>/>

        <input type="submit" value="Регистрация"/>
        <#if err??><#if err=="existing_login"><p>Данный логин уже существует</p></#if></#if>
    </form>
</div>
</#macro>