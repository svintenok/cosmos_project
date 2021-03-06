<#include "base.ftl">


<#macro content>
<div class="text-center" style="padding:100px 0">

    <div class="logo">Вход</div>

    <div class="login-form-1">

        <form id="login-form" class="text-left" action="/login" method="POST">

            <div class="login-form-main-message"></div>

            <div class="main-login-form">
                <div class="login-group">
                    <div class="form-group">
                        <label for="lg_username" class="sr-only">Логин</label>
                        <input type="text" class="form-control" required="" id="lg_username" name="login" placeholder="Логин" <#if login??> value="${login}"</#if>>
                    </div>
                    <div class="form-group">
                        <label for="lg_password" class="sr-only">Пароль</label>
                        <input type="password"  class="form-control" required="" id="lg_password" name="password" placeholder="Пароль">
                    </div>
                    <div class="form-group login-group-checkbox">
                        <input type="checkbox" id="lg_remember" name="remember">
                        <label for="lg_remember">Запомнить меня</label>
                    </div>
                </div>
                <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i>Go!</button>
            </div>

            <div class="etc-login-form">
                <p>Нет аккаунта? <a href="/registration">Регистрация</a></p>
                <#if err??><p style="color: red">Неправильный логин или пароль</p></#if>
            </div>

        </form>


    </div>

</div>
</#macro>


<#macro style>
<style>

    footer {
        position: absolute;
        width: 100%;
        bottom: 0;
        background: #7e7e7e;
        margin-left: -20px;
        color: #dbdbdb;
        font-size: 11px;
    }

    #footer {
        max-width: 960px;
        margin: auto;
        padding: 10px 0;
        height: 90px;
    }

    #footer-logo {
        float: right;
        margin-top: 20px;
        font-size: 12px;
        text-align: right;
    }

    h5{
        font-size: 20px;
        color: rgba(255,255,255,1);
        font-style: normal;
        font-family: "Dotum";
    }
    h5:hover{
        color: rgba(158, 152, 152, 1);
        text-shadow: 0 0 10px rgba(255,255,255,1);
    }

    html,
    body {
        height: 100%;
        background:rgba(245, 245, 245, 1);
        padding: 10px;
        font-family: 'Dotum';
    }

    a {
        color: #aaaaaa;
        transition: all ease-in-out 200ms;
    }
    a:hover {
        color: #333333;
        text-decoration: none;
    }

    .etc-login-form {
        color: #919191;
        padding: 10px 20px;
    }
    .etc-login-form p {
        margin-bottom: 5px;
    }
    .login-form-1 {
        max-width: 1000px;
        border-radius: 5px;
        display: inline-block;
    }
    .main-login-form {
        position: relative;
    }
    .login-form-1 .form-control {
        border: 0;
        box-shadow: 0 0 0;
        border-radius: 0;
        background: transparent;
        color: #555555;
        padding: 7px 0;
        font-weight: bold;
        height:75px;
        width: 377px;
        font-size: 28px;
    }

    .login-form-1 .form-control:-moz-placeholder,
    .login-form-1 .form-control::-moz-placeholder,
    .login-form-1 .form-control:-ms-input-placeholder {
        color: #999999;
    }
    .login-form-1 .form-group {
        margin-bottom: 0;
        border-bottom: 2px solid #efefef;
        padding-right: 20px;
        position: relative;
    }
    .login-form-1 .form-group:last-child {
        border-bottom: 0;
    }
    .login-group {
        background: #ffffff;
        color: #999999;
        border-radius: 8px;
        padding: 10px 20px;
    }
    .login-group-checkbox {
        padding: 5px 0;
    }

    .login-form-1 .login-button {
        position: absolute;
        right: -25px;
        top: 50%;
        background: #ffffff;
        color: #999999;
        padding: 11px 0;
        width: 50px;
        height: 50px;
        margin-top: -25px;
        border: 5px solid #efefef;
        border-radius: 50%;
        transition: all ease-in-out 500ms;
    }
    .login-form-1 .login-button:hover {
        color: #555555;
        transform: rotate(450deg);
    }

    .login-form-main-message {
        background: #ffffff;
        color: #999999;
        border-left: 3px solid transparent;
        border-radius: 3px;
        margin-bottom: 8px;
        font-weight: bold;
        height: 0;
        padding: 0 20px 0 17px;
        opacity: 0;
        transition: all ease-in-out 200ms;
    }

    [type="checkbox"]:not(:checked),
    [type="checkbox"]:checked,
    [type="radio"]:not(:checked),
    [type="radio"]:checked {
        position: absolute;
        left: -9999px;
    }
    [type="checkbox"]:not(:checked) + label,
    [type="checkbox"]:checked + label,
    [type="radio"]:not(:checked) + label,
    [type="radio"]:checked + label {
        position: relative;
        padding-left: 25px;
        padding-top: 1px;
        cursor: pointer;
    }

    [type="checkbox"]:not(:checked) + label:before,
    [type="checkbox"]:checked + label:before,
    [type="radio"]:not(:checked) + label:before,
    [type="radio"]:checked + label:before {
        content: '';
        position: absolute;
        left: 0;
        top: 2px;
        width: 17px;
        height: 17px;
        border: 0px solid #aaa;
        background: #f0f0f0;
        border-radius: 3px;
        box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3);
    }
    [type="checkbox"]:not(:checked) + label:after,
    [type="checkbox"]:checked + label:after,
    [type="radio"]:not(:checked) + label:after,
    [type="radio"]:checked + label:after {
        position: absolute;
        color: #555555;
        transition: all .2s;
    }

    [type="checkbox"]:not(:checked) + label:after,
    [type="radio"]:not(:checked) + label:after {
        opacity: 0;
        transform: scale(0);
    }
    [type="checkbox"]:checked + label:after,
    [type="radio"]:checked + label:after {
        opacity: 1;
        transform: scale(1);
    }
    [type="checkbox"]:disabled:not(:checked) + label:before,
    [type="checkbox"]:disabled:checked + label:before,
    [type="radio"]:disabled:not(:checked) + label:before,
    [type="radio"]:disabled:checked + label:before {
        box-shadow: none;
        border-color: #8c8c8c;
        background-color: #878787;
    }
    [type="checkbox"]:disabled:checked + label:after,
    [type="radio"]:disabled:checked + label:after {
        color: #555555;
    }
    [type="checkbox"]:disabled + label,
    [type="radio"]:disabled + label {
        color: #8c8c8c;
    }

    [type="checkbox"]:checked:focus + label:before,
    [type="checkbox"]:not(:checked):focus + label:before,
    [type="checkbox"]:checked:focus + label:before,
    [type="checkbox"]:not(:checked):focus + label:before {
        border: 1px dotted #f6f6f6;
    }

    label:hover:before {
        border: 1px solid #f6f6f6 !important;
    }

    [type="checkbox"]:not(:checked) + label:before,
    [type="checkbox"]:checked + label:before {
        border-radius: 3px;
    }

    [type="checkbox"]:not(:checked) + label:after,
    [type="checkbox"]:checked + label:after {
        content: '✔';
        top: 0;
        left: 2px;
        font-size: 14px;
    }

    .logo {
        padding: 15px 0;
        font-size: 50px;
        color: rgba(0, 0, 0, 1);
        font-weight: bold;
    }
</style>
</#macro>