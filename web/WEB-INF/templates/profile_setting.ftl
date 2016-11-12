<#include "base.ftl">


<#macro content>

<div id="heading"></div>
<aside></aside>
<section></section>



<div class="row">
    <div class="col-md-3 col-xs-1 col-sm-2" ></div>
    <div class="col-md-6 col-xs-10 col-sm-8">

        <form action="" id="f1" method="post" >
            <h3>Мой профиль</h3>
            <h3>Изменить Имя</h3>
            <input type="text" name="name" id="name" class="form-control" <#if current_user.name??>placeholder="${current_user.name}"</#if> style="color: black"/>
            <h3>Изменить логин</h3>
            <input type="text" name="login"  id="login" class="form-control" placeholder="${current_user.login}"  style="color: black"/>
            <h3>Новый Пароль</h3>
            <input type="password" name="password" id="password" class="form-control" style="color: black"/>
            <h3>Подтвердите новый пароль</h3>
            <input type="password" name="password_conf"  id="password_conf" class="form-control" style="color: black"/>
            <h3>Изменить Mail</h3>
            <input type="text" name="mail" id="mail" class="form-control" placeholder="${current_user.email}" style="color: black"/>
            <h3>Изменить Страну</h3>
            <input type="text" name="country" id="country" class="form-control" <#if current_user.country??>placeholder="${current_user.country}"</#if>  style="color: black"/>

            <h3>Изменить фотографию</h3>
            <input type="file"  name="my-pic" id="file-field" multiple="" class="image" style="color: black"/>
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
            <input type="submit" name="reg" id="reg" value="Сохранить" class="btn btn-primary custom-btn-primary" value=""/>
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

</style>
</#macro>