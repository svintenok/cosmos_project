<#include "carusel.ftl">
<#include "base.ftl">

<#macro content>
    <@carusel/>

<div class="container">

    <div class="row" style="padding-top: 20px">
        <div class="col-md-12">

            <#if current_user??>
            <div class="btn-group">
                <button type="button" style="margin-right: 25px" class="btn btn-primary btn-lg" data-toggle="modal"  data-target="#TopicCreatingModal">
                    <span class="glyphicon glyphicon-pencil" style="margin-right: 7px"></span>
                    Создать тему
                </button>
            </div>
            </#if>

            <!-- Modal -->
            <div class="modal fade" id="TopicCreatingModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="ModalLabel">Создание темы</h4>
                        </div>

                        <form action="/forum" method="POST">

                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-12" style="margin-top: 20px">
                                         <input type="text" name="name" class="form-control" placeholder="Введите название темы" required></input>
                                    </div>

                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Сохранить</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>

            <h3>Обратная связь</h3>

            <div style="padding-top: 20px">
                <ul class ="list-group">
                    <#list admin_forum_topics as topic>
                    <li class ="list-group-item">
                        <div class="row">
                            <div class="col-md-11">
                                 <h3><a href="/forum?id=${topic.id}&page=${topic.pagesCount}" style="color: black;">${topic.name}</a></h3>
                                <p style="color: gray">Cообщений: ${topic.messagesCount}
                                    <#if topic.lastMessage??>
                                        , последнее сообщение: ${topic.lastMessage.date} от
                                        <#if topic.lastMessage.user.role.role='admin'>
                                            <a style="color:red;">администратор</a>
                                        <#else>
                                            <a href="/profile?id=${topic.lastMessage.userId}">${topic.lastMessage.user.login}</a>
                                        </#if>
                                    </#if></p>
                            </div>
                            <div class="col-md-1">
                                <#if current_user?? && current_user.role.role='admin'>
                                    <form action="/forum" method="POST">
                                        <input type="hidden" name="topicId" class="form-control" value="${topic.id}"></input>
                                        <button type="submit" class="btn btn-close btn-sm"><span class="glyphicon glyphicon-remove"></span></button>
                                    </form>
                                </#if>
                            </div>
                        </div>
                    </li>
                    </#list>
                </ul>
            </div>

            <h3>Ваши темы</h3>


            <div style="padding-top: 20px">
                <ul class ="list-group">
                    <#list users_forum_topics as topic>
                        <li class ="list-group-item">
                            <div class="row">
                                <div class="col-md-10">
                                    <h3><a href="/forum?id=${topic.id}&page=${topic.pagesCount}" style="color: black;">${topic.name}</a></h3>
                                    <p>Cообщений: ${topic.messagesCount}
                                        <#if topic.lastMessage??>
                                            , последнее сообщение: ${topic.lastMessage.date} от
                                            <#if topic.lastMessage.user.role.role='admin'>
                                                <a style="color:red;">администратор</a>
                                            <#else>
                                                <a href="/profile?id=${topic.lastMessage.userId}">${topic.lastMessage.user.login}</a>
                                            </#if>
                                        </#if></p>
                                </div>
                                <div class="col-md-2">
                                    <#if current_user??><#if current_user.role.role='admin'>
                                        <form action="/forum" method="POST">
                                            <input type="hidden" name="topicId" class="form-control" value="${topic.id}"></input>
                                            <button type="submit" class="btn btn-close btn-sm"><span class="glyphicon glyphicon-remove"></span></button>
                                        </form>
                                    </#if></#if>
                                </div>
                            </div>
                        </li>
                    </#list>
                </ul>
            </div>

        </div>
    </div>
</div>
</#macro>




<#macro style>
    <style type="text/css">
        .text{
            font-family: "Gabriola";
            font-size: 35px;
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
            margin-top: 13px;
            margin-left: -20px;
            width: 103%;
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

        a:hover{
            color:grey;
        }

        h3{
            font-size: 25px;
            color: rgba(0,0,0,1);
            font-family: "Batang";
        }

        .btn-close{
            border: none;
            color:grey;
            background-color: white;
            float: right;
        }
    </style>
</#macro>