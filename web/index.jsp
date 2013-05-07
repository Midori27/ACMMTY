<%-- 
    Document   : index
    Created on : Feb 27, 2013, 10:39:17 AM
    Author     : juanjo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- Fonts de google -->
	<link href='http://fonts.googleapis.com/css?family=Numans' rel='stylesheet' type='text/css'/>
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<title>ACM MTY</title>
	<meta name="Description" content="Olìmpo - Portfolio minimal per web designers e non solo" />
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/scrollto.js"></script>
	
	<!--Librerias Slider-->
	
	<link rel="stylesheet" href="js/slider/css/royalslider.css" />
    <link rel="stylesheet" href="js/slider/css/royalslider-skins/default/default.css" />
    <link rel="stylesheet" href="js/slider/css/royalslider-skins/iskin/iskin.css" /> 
    <link rel="stylesheet" href="js/slider/css/royalslider-preview.css" />
    
   
    
    <script src="js/slider/js/jquery-1.6.2.min.js"></script>      
	<script src="js/slider/js/jquery.easing.1.3.min.js"></script> 
    <script src="js/slider/js/royal-slider-8.1.min.js"></script>
   
    <!--Fin del Slider-->
	
	
</head>

<body>

	<!-- Barra fija -->
	<div id="topbar">
		<!-- Logo ACM -->
		<img src="images/logo.png" class="logo" alt="ACM MTY" />
		<%@include file="/WEB-INF/Includes/navegacion.jsp"%>
	</div>
	<!-- FINAL barra fija -->


	<div class="container">

		
		<br>
		<br>
		<br>
		<br>
	
			
			<div id="main-body">		
			<div id="slider-ajax-container">
				<div id="banner-rotator" class="royalSlider default">    
	    <ul class="royalSlidesContainer">
	
	        <li class="royalSlide"> 
	        	<img class="royalImage" src="js/slider/img/1150x400/4.jpg" width="1150" height="400"/>
	            <div class="royalCaption" style="left:40%; top:130px; width:300px; color: #eaeaed;">
	                <div class="royalCaptionItem " data-show-effect="fade moveleft"  data-move-offset="30" style="left: -320px;">Muestra Slider</div>
	                <div class="royalCaptionItem sgMidText" data-show-effect="fade moveright" data-move-offset="20" style="left: -200px; top: 30px;">Texto editable.</div>
	            </div>      	
	        </li>
	        <li class="royalSlide">          
	           <img class="royalImage" src="js/slider/img/1150x400/5.jpg" width="1150" height="400"/>        
	           <div class="royalCaption" style="left:40%; top:120px; width:400px; color: #000000; text-align:center;" >
	                <div class="royalCaptionItem " data-show-effect="fade movetop"  data-move-offset="10" style="left: -320px; width: 100%;">Texto en grande</div>
	                <div class="royalCaptionItem sgMidText" data-show-effect="fade movebottom" data-delay="400" data-move-offset="5"  style="left: -320px; top: 35px; width: 100%;" >Vista</div>
	            </div>                               	
	        </li>
	        <li class="royalSlide">                     
	        	<img class="royalImage" src="js/slider/img/1150x400/1.jpg" width="1150" height="400"/>
	            <div class="royalCaption" style="left:58%; text-align:center; color:#ffffff; width:315px; top: 110px;">
	                <div class="royalCaptionItem" data-show-effect="fade movetop"  data-move-offset="15" style="width: 100%;">ACM MONTERREY</div>
	                <div class="royalCaptionItem sgMidText" data-show-effect="fade movetop"  data-move-offset="8" style="top:35px; width: 100%;"></div>
	                <div class="royalCaptionItem sgSmallText " data-show-effect="fade movetop" data-move-offset="8" data-delay="600" style="top:70px; left: 96px;"><a class="tintButton non-draggable" href="www.facebook.com">Ver mas información</a></div>
	            </div>      	
	        </li>
	        <li class="royalSlide"> 
	        	<img class="royalImage" src="js/slider/img/1150x400/2.jpg" width="1150" height="400"/>
	            <div class="royalCaption" style="left:57%; top:300px; color:#ffffff;">
	                <div class="royalCaptionItem" data-show-effect="moveleft fade" data-move-offset="30" style="width: 280px;">¡Regístrate!</div>
	                <div class="royalCaptionItem sgMidText" data-show-effect="moveleft fade" style="left: 120px; top:35px; width: 200px;" data-move-offset="30">¿Éstas listo?</div>
	            </div> 
	        </li> 
	    </ul>  
	</div>
			</div>		
		</div>
	
		<script>     	
		jQuery(document).ready(function($) {		
			$('#banner-rotator').royalSlider({			
		   		imageAlignCenter:true,
		   		hideArrowOnLastSlide:true,
		   		slideSpacing:20
		    });		
		});
	    </script>		
			<div id="contenth2">

				<!-- Noticias-->
				<p><a name="noticias"></a></p> 
				<div class="group">
					
					
					<h3>Noticias Febrero 2013</h3>
					
					<p>
						El <strong>hackaton</strong> de este año fue ttalmente un exito.
					</p>
					
					<div class="ventana">
						<img src="images/ACM/hackaton.jpg" alt="" />
					</div>
				</div>
				<!-- Fin de noticias -->
				
				
				<div id="footer">
					<p>
						ACM MTY 2013
					</p>
				</div>
			</div>
		</div>
		<!-- Final del Contenido -->
		
		<div id="clearer"></div>

	</div>
</body>
</html>

