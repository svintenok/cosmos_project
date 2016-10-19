<#include "base.ftl">

<#macro content>
    <div class="container">
        <form class="form-inline"" action="/login" method="POST">
            <input type="text" name="username" <#if login??> value="${login}"</#if>/>
            <input type="password" name="password"/>
            <label class="checkbox">
                <input type="checkbox" name="remember" value="remember-me"/> Remember me
            </label>
            <input type="submit" value="Login"/>
        </form>
        <#if err??><p>Sorry, wrong username or password</p></#if>
    </div>
</#macro>
