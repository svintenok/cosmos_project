<#macro carusel>
<div id="myCarousel" class="carousel slide" data-interval="5000" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>

    </ol>
    <div class="carousel-inner" style="height: 250px">
        <div class="active item">
            <img src="files/space1.jpg">
        </div>
        <div class="item">
            <img src="files/space2.jpg">
        </div>
        <div class="item">
            <img src="files/space3.jpg">
        </div>
        <div class="item">
            <img src="files/space4.jpg">
        </div>
    </div>
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>
</#macro>