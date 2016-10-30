<#include "base.ftl">


<#macro content>

<div class="container">

    <div class="row">

        <form action="" id="f1" method="post" >


            <h1 style="margin-top: 40px">Добавление новости</h1>

            <div class="row">

                <div class="col-md-6">
                    <h3>Название</h3>
                    <input type="text" name="title" id="name" required="" class="form-control"  value=""/>
                    <h3>Краткое описание</h3>
                    <textarea name="description" id="about" required="" class="form-control input-contrast comment-form-textarea field" style="max-height: 233px; height: 160px;"></textarea>
                </div>

                <div class="col-md-1"></div>

                <div class="col-md-5">

                    <h3>Фотография</h3>
                    <input type="file"  name="news_photo" id="file-field" class="image" />
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


                </div>

            </div>

            <div class="row">

                <div class="col-md-12">
                    <h3>Текст</h3>
                    <textarea name="text" id="aboutevery" required="" class="form-control input-contrast comment-form-textarea field" style="max-height: 400px; height: 400px;"></textarea>
                </div>

            </div>

            <div class="row">
                <div class="col-md-1" style="margin-bottom: 30px; margin-top: 40px">
                    <input type="submit" name="reg" id="reg" value="Создать новость" class="btn btn-primary custom-btn-primary" value=""/>
                </div>
            </div>

        </form>

    </div>

</div>

</#macro>



<#macro style>

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


<style type="text/css">*{
    margin:0;
    padding:0;
}

.slider{
    width:600px;
    position:relative;
    padding-top:400px;
    box-shadow:0 10px 20px -5px rgba(0,0,0,0.75);
    overflow:hidden;
    padding-bottom:20px;
}

.sp img{
    position:absolute;
    left:0;
    top:0;
}

.slider input[name='slide_switch']{
    display:none;
}

.slider label{
    margin:18px 0 0 18px;
    border:3px solid #999;
    float:left;
    cursor:pointer;
    transition:all 0.5s;
    opacity:0.6;
}

.slider label img{
    display:block;
    height:45px;
}

.slider input[name='slide_switch']:checked+label{
    border-color:#666;
    opacity:1;
}

.slider input[name='slide_switch']~span{
    opacity:0;
    -moz-transform:scale(1.1);
    -ms-transform:scale(1.1);
    -webkit-transform:scale(1.1);
    -o-transform:scale(1.1);
    transform:scale(1.1);
}

.slider input[name='slide_switch']:checked+label+span{
    opacity:1;
    -moz-transform:scale(1);
    -ms-transform:scale(1);
    -webkit-transform:scale(1);
    -o-transform:scale(1);
    transform:scale(1);
}

span{
    width:500px;
    position:absolute;
    left:50px;
    top:20px;
    height:370px;
    overflow:hidden;
    transition:all 0.5s;
}

.preview{
    max-height: 300px;
    max-width: 450px;
}

</style>

</#macro>