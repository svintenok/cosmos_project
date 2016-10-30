<#include "base.ftl">


<#macro content>

<div id="wrapper">

<div id="heading"></div>
<aside></aside>
<section></section>

<div class="row">
    <div class="col-md-3 col-xs-1 col-sm-2" ></div>
    <div class="col-md-6 col-xs-10 col-sm-8">


        <form action="/registration" id="f1" method="POST" >
            <h3>Регистрация</h3>
            <h3>Имя</h3>
            <input type="text" name="name" id="name" class="form-control" placeholder="Ваше имя" style="color: black" <#if name??> value="${name}"</#if>/>
            <h3>Логин&nbsp;*</h3>
            <input type="text" name="login" required="" id="login" class="form-control" placeholder="Ваш логин" style="color: black" <#if login??> value="${login}"</#if>/>
        <#if err??><#if err=="existing_login">
            <p style="color: red; margin: 0px; padding: 0px;">Данный логин уже существует</p>
        </#if></#if>
            <h3>Пароль&nbsp;*</h3>
            <input type="password" name="password" required="" id="password" class="form-control" placeholder="••••••••" style="color: black"/>
            <h3>Подтвердите пароль&nbsp;*</h3>
            <input type="password" name="password_conf" required="" id="password_conf" class="form-control" placeholder="••••••••" style="color: black"/>
            <h3>Mail&nbsp;*</h3>
            <input type="text" name="email" id="mail" required="" class="form-control" placeholder="Ваша электронная почта" style="color: black" <#if email??> value="${email}"</#if>/>
            <h3>Страна</h3>
            <input type="text" name="country" id="country" class="form-control" placeholder="Ваша страна" style="color: black" <#if country??> value="${country}"</#if>/>
            <h3>Фотография</h3>
            <input type="file"  name="profile_photo" id="file-field" class="image" style="color: black"/>
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

            <br>
            *&nbsp;Обязательно для заполнения
            <br>
            <input type="submit" name="reg" id="reg" value="Регистрация" class="btn btn-primary custom-btn-primary" value=""/>
            <br>
            <p id="out"></p>
        </form>
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

    p{
        padding-top: 30px;
        margin-top: 50px;
    }
    #f1{
        margin-top: 80px;
    }
    H1{
        font: 39px Tahoma, sans-serif;
    }
    h3{
        font: 20px Tahoma, sans-serif;
        margin-top: 20px;
    }
    .custom-btn-primary{
        font: 17px Tahoma, sans-serif;
        border-color: #8f8f8f;
        background: #8f8f8f;
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

</style>
</#macro>