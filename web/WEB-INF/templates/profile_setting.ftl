<#include "base.ftl">


<#macro content>

<div id="heading"></div>
<aside></aside>
<section></section>



<div class="row" style="margin-bottom: 30px;">
    <div class="col-md-3 col-xs-1 col-sm-2" ></div>
    <div class="col-md-6 col-xs-10 col-sm-8">

        <form action="/settings" id="f1" method="post" enctype="multipart/form-data">
            <h3 align="center">Мой профиль</h3>

            <#if error??>
                <div class="alert alert-danger">
                    <#if error='wrong_email'>
                        <p>Некорректный e-mail!</p>
                    </#if>
                </div>
            </#if>

            <h3>Изменить имя</h3>
            <input type="text" name="name" id="name" class="form-control" <#if current_user.name??>value="${current_user.name}"</#if> style="color: black"/>
            <h3>Изменить почту</h3>
            <input type="text" name="email" id="mail" class="form-control" required="" value="${current_user.email}" style="color: black"/>
            <h3>Изменить страну</h3>
            <input type="text" name="country" id="country" class="form-control" <#if current_user.country??>value="${current_user.country}"</#if>  style="color: black"/>

            <h3>Изменить фотографию</h3>
            <input type="file" name="profile_photo" id="file-field" class="image" style="color: black"/>
            <br>
            <div id="photo_copy"></div>

            <script>
                $(function(){
                    $(".image").change(showPreviewImage_click);
                })
                function showPreviewImage_click(e) {
                    var $input = $(this);
                    var inputFiles = this.files;
                    if(inputFiles == undefined || inputFiles.length == 0) return;
                    var inputFile = inputFiles[0];
                    var img = $('<img/>',{'class':'preview'});
                    $('#photo_copy img').remove();
                    img.appendTo($('#photo_copy'));
                    var reader = new FileReader();
                    reader.onload = function(event) {
                        img.attr("src", event.target.result);
                    };
                    reader.onerror = function(event) {
                        alert("I AM ERROR: " + event.target.error.code);
                    };
                    reader.readAsDataURL(inputFile);
                }
            </script>
            <button type="submit" style="margin-left: 0px;" class="btn btn-primary custom-btn-primary">Сохранить</button>
        </form>

        <form action="/settings?password_change=true" id="f1" method="post" >
        <h3 align="center">Изменение пароля</h3>
            <#if password_error??>
                <div class="alert alert-danger">
                    <#if password_error='wrong_old_password'>
                        <p>Неправильный старый пароль!</p>
                    <#elseif password_error='wrong_password'>
                        <p>Некорректный пароль! Пароль должен состоять только из латинских букв, цифр и быть не короче шести символов</p>
                    <#elseif password_error='wrong_conf_password'>
                        <p>Пароли не совпадают!</p>
                    </#if>
                </div>
            </#if>
            <h3>Cтарый пароль</h3>
            <input type="password" name="old_password" required="" id="password" class="form-control" style="color: black"/>
            <h3>Новый пароль</h3>
            <input type="password" name="password" required="" id="password" class="form-control" style="color: black"/>
            <h3>Подтвердите новый пароль</h3>
            <input type="password" name="password_conf" required="" id="password_conf" class="form-control" style="color: black"/>

            <button type="submit"  style="margin-left: 0px;" class="btn btn-primary custom-btn-primary"/>Изменить пароль</button>
        </form>

        <p id="out"></p>
    </div>
    <div class="col-md-3 col-xs-1 col-sm-2"></div>
</div>
</div>


</#macro>

<#macro style>

<style type="text/css">
    .preview{
        max-height: 300px;
        max-width: 450px;
    }
    .min {
        width: 45px;
    }

</style>

<style>
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

    #wrapper {
        max-width: 960px;
        margin: auto;
    }
    header {
        padding: 20px 0;
    }
    footer {
        position: absolute;
        width: 100%;
        background: #7e7e7e;
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

    #f1{
        margin-top: 80px;
    }
    H1{
        font: 39px Tahoma, sans-serif;
    }
    .custom-btn-primary{
        font: 17px Tahoma, sans-serif;
        border-color: #8f8f8f;
        background: #8f8f8f;
        margin-left: -20px;
        margin-top: 20px;
    }
    .custom-btn-primary:hover{
        border-color: #777777;
        background: #777777;
    }
    .radio{
        margin-top: 20px;
        font: 14px Tahoma, sans-serif;
    }
    .rbElem{
        margin-right: 20px;
    }

    h3{
        font-size: 25px;
        color: rgba(0,0,0,1);
        font-family: "Batang";
    }

</style>
</#macro>