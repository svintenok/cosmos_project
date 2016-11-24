<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
<div class="container">

    <div class="row" style="padding-top: 40px">
        <div class="col-md-1">
            <form action="/forum">
                <button type="submit" class="btn btn-exit "><span class="glyphicon glyphicon-arrow-left"></span></button>
            </form>
        </div>
        <div class="col-md-6">
            <div>
                <h3 style="text-align: center">${topic.name}</h3>
            </div>
            <br/>
        </div>
        <div class="col-md-5">
            <ul class="pager" style="float: right;">
                <li <#if (!page?? || page=1)>class="disabled" </#if> >
                    <a  <#if page?? && (page>1)><a href="/forum?id=${topic.id}&page=${page - 1}"</#if> style="font-size: 18px;">&larr; Предыдущая</a>
                </li>
                <li <#if (topic.messages?size<limit)>class="disabled"</#if> >
                    <a <#if (topic.messages?size=limit) > <a href="/forum?id=${topic.id}&page=${page + 1}"</#if> style="font-size: 18px;">Следующая &rarr;</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <ul class ="list-group">
                <#list topic.messages as message>
                <li class ="list-group-item">
                    <div class="row">
                        <div class="col-md-8">
                            <#if message.user.role.role='admin'>
                                <a style="font-size: 20px; color:red;">администратор</a>
                            <#else>
                                <a href="/profile?id=${message.userId}" style="font-size: 20px">${message.user.login}</a>
                            </#if>
                        </div>
                        <div class="col-md-4">
                            <#if current_user??><#if current_user.role.role='admin' || current_user.id=message.userId>
                            <form action="/forum?id=${topic.id}" method="POST">
                                <input type="hidden" name="messageId" class="form-control" value="${message.id}"></input>
                                <button type="submit" class="btn btn-close btn-sm"><span class="glyphicon glyphicon-remove"></span></button>
                            </form>
                            </#if></#if>
                        </div>
                    </div>
                    <br/>
                    <h style="white-space: pre-wrap;">${message.text}</h>
                    <p align="right" style="color: gray">${message.date}</p>
                </li>
                </#list>
            </ul>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">

            <#if current_user??>
            <form action="/forum?id=${topic.id}" method="POST">
            <#else>
            <form action="/login" method="GET">
            </#if>

             <div class="row">

                <div class="col-md-9" style="padding-bottom: 40px">
                    <textarea name="message" class="form-control input-contrast comment-form-textarea field" style="max-height: 233px; height: 100px;"  required=""
                              <#if current_user??>placeholder="Введите сообщение"<#else>placeholder="Войдите, чтобы оставить cообщение"</#if>
                              <#if !current_user??>disabled</#if>></textarea>
                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-success btn-block">Отправить сообщение</button>
                </div>
             </div>

            </form>
        </div>
    </div>

</div>

</#macro>




<#macro style>
<style>

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
        margin-left: -20px;
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

    H1{
        font: 39px Tahoma, sans-serif;
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

    a{
        font-size: 18px;
    }
    a:hover{
        color:grey;
    }

    .gg{
        font-size: 20px;
    }
    .btn-close{
        border: none;
        color:grey;
        background-color: white;
        float: right;
    }

    .btn-exit{
        border-width: 0.5px;
        border-color: silver;
        color:black;
        background-color: white;
        margin-top: 20px;
    }

</style>
</#macro>