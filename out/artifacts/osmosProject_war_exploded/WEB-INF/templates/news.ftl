<#include "base.ftl">

<#macro content>

<div class="container">

    <div class="row">

        <div class="row" style="padding-top: 20px">
            <div class="col-md-12" style="padding-top: 20px; margin-bottom: 40px">
                <p><h1>${news.title}</h1></p>
                <p style="font-size: 20px"><img src="http://localhost:8080/files/news_photo/${news.id}.jpg" width="45%" style="float: right; margin: 20px;">${news.text}</p>
            </div>

        </div>

        <form action="/news?id=${news.id}" method="POST">
            <div class="col-md-12"  style="margin-bottom: 40px">
                <div class="col-md-4">
                    <p class="gg" style="text-align: center">Дата публикации: ${news.date}</p>
                </div>

                <div class="col-md-6">
                    <textarea name="comment" id="comment" required=""
                            <#if current_user??>placeholder="Ваш комментарий"
                            <#else>placeholder="Войдите, чтобы оставить комментарий"</#if>
                             class="form-control input-contrast comment-form-textarea field" style="max-height: 233px; height: 100px;"
                             <#if !current_user??>disabled</#if>></textarea>
                </div>

                <div class="col-md-2">
                    <button type="submit" class="btn btn-success">Прокомментировать</button>
                </div>
            </div>
        </form>

        <div class="col-md-12">
            <ul class ="list-group">
            <#list comments as comment>
                <li class ="list-group-item">
                    <p><b> ${comment.user.login}:</b></p>
                    <h>${comment.text}</h>
                    <p style="color: #737373" align="right">${comment.date}</p>
                </li>
            </#list>
            </ul>
        </div>

    </div>

</div>
</#macro>


<#macro style>
<style type="text/css">
    .text{
        font-family: "Gabriola";
        font-size: 20px;
        font-style: italic;
        color: white;
        text-shadow:0 0 10px black;
    }
    .item{
        background: #333;
        text-align: center;
        height: 350px !important;
    }
    .carousel{
        margin-top: 50px;
        margin-left: 41px;
    }
</style>


<style>

    .gg{
        font-size: 30px;
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

</style>
</#macro>