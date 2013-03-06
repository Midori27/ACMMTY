
// funcion de validación de forma de Registro//
		function validateRegistro(form) {
		  var nombre = form.nombre.value;
		  var apellidoP = form.apellidoP.value;
		  var apellidoM = form.apellidoM.value;
		  var fechaNacimiento = form.fechaNacimiento.value;
		  var telefono = form.telefono.value;
		  var ciudad = form.ciudad.value;
		  var estado = form.estado.value;
		  var universidad = form.universidad.value;
		  var campus = form.campus.value;
		  var carrera = form.carrera.value;



		  var nombreUsuario = form.nombreUsuario.value;
		  var email = form.email.value;
		  var password = form.password.value;
		  
		  //regex para la validacion del registro
		
		  var nameRegex = /^[a-zA-Z]+(([\'\,\.\- ][a-zA-Z ])?[a-zA-Z]*)*$/;
		  var emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
		  var dateRegex = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
		  var phoneRegex = /^[a-zA-Z0-9\-().\s]{10,15}$/;
		  var usernameRegex = /^[A-Za-z0-9_]{3,20}$/;
		  
		  
		  if(nombre == "") {
		    inlineMsg('nombre','Porfavor introduce tu nombre.',2);
		    return false;
		  }
		  if(!nombre.match(nameRegex)) {
		    inlineMsg('nombre','Porfavor introduce un nombre válido',2);
		    return false;
		  }
		  
		  if(apellidoP == "") {
		    inlineMsg('apellidoP','Porfavor introduce tu apellido',2);
		    return false;
		  }
		  if(!apellidoP.match(nameRegex)) {
		    inlineMsg('apellidoP','Porfavor introduce un nombre válido.',2);
		    return false;
		  }
		  
		  
		  if(apellidoM == "") {
		    inlineMsg('apellidoM','Porfavor introduce tu apellido',2);
		    return false;
		  }
		  if(!apellidoM.match(nameRegex)) {
		    inlineMsg('apellidoM','Porfavor introduce un apellido válido.',2);
		    return false;
		  }
		  
		  
	//	  if(fechaNacimiento == "") {
	//	    inlineMsg('fechaNacimiento','Porfavor introduce tu fecha de nacimiento formato DD-MM-AAAA',2);
	//	    return false;
	//	  }
	//	  if(!fechaNacimiento.match(dateRegex)) {
	//	    inlineMsg('fechaNacimiento','Porfavor introduce tu fecha de nacimiento formato DD-MM-AAAA',2);
	//	    return false;
	//	  }
		  
		  if(telefono == "") {
		    inlineMsg('telefono','Porfavor introduce tu telefono.',2);
		    return false;
		  }
		  if(!telefono.match(phoneRegex)) {
		    inlineMsg('telefono','Porfavor introduce un telefono válido',2);
		    return false;
		  }
		  
		  if(ciudad == "nada") {
		    inlineMsg('ciudad','Porfavor elije tu ciudad.',2);
		    return false;
		  }
		  
		  if(estado == "nada") {
		    inlineMsg('estado','Porfavor elije tu estado.',2);
		    return false;
		  }

		  if(universidad == "nada") {
		    inlineMsg('universidad','Porfavor elije tu universidad.',2);
		    return false;
		  }
		  
		  if(campus == "nada") {
		    inlineMsg('campus','Porfavor elije tu campus.',2);
		    return false;
		  }
		  
		  if(carrera == "nada") {
		    inlineMsg('carrera','Porfavor elije tu carrera.',2);
		    return false;
		  }

		  
		  
		  if(nombreUsuario == "") {
		    inlineMsg('nombreUsuario','Porfavor introduce tu nombre de usuario.',2);
		    return false;
		  }
		  if(!nombreUsuario.match(usernameRegex)) {
		    inlineMsg('nombreUsuario','Porfavor introduce un nombre de usuario válido (Minimo 3 letras, puede contener "_" y números',2);
		    return false;
		  }
		  
		  if(email == "") {
		    inlineMsg('email','<strong>Error</strong><br />Porfavor introduce tu correo.',2);
		    return false;
		  }
		  
		  if(!email.match(emailRegex)) {
		    inlineMsg('email','<strong>Error</strong><br />Introduce un correo válido.',2);
		    return false;
		  }
		  
		  if(password == "") {
		    inlineMsg('password','Porfavor introduce tu nueva contraseña',2);
		    return false;
		  }
		  
		  
		
		  return true;
		}
		
		// Javascript para mostrar errores de escritura //
		
		var MSGTIMER = 20;
		var MSGSPEED = 5;
		var MSGOFFSET = 3;
		var MSGHIDE = 3;
		
		// build out the divs, set attributes and call the fade function //
		function inlineMsg(target,string,autohide) {
		  var msg;
		  var msgcontent;
		  if(!document.getElementById('msg')) {
		    msg = document.createElement('div');
		    msg.id = 'msg';
		    msgcontent = document.createElement('div');
		    msgcontent.id = 'msgcontent';
		    document.body.appendChild(msg);
		    msg.appendChild(msgcontent);
		    msg.style.filter = 'alpha(opacity=0)';
		    msg.style.opacity = 0;
		    msg.alpha = 0;
		  } else {
		    msg = document.getElementById('msg');
		    msgcontent = document.getElementById('msgcontent');
		  }
		  msgcontent.innerHTML = string;
		  msg.style.display = 'block';
		  var msgheight = msg.offsetHeight;
		  var targetdiv = document.getElementById(target);
		  targetdiv.focus();
		  var targetheight = targetdiv.offsetHeight;
		  var targetwidth = targetdiv.offsetWidth;
		  var topposition = topPosition(targetdiv) - ((msgheight - targetheight) / 2);
		  var leftposition = leftPosition(targetdiv) + targetwidth + MSGOFFSET;
		  msg.style.top = topposition + 'px';
		  msg.style.left = leftposition + 'px';
		  clearInterval(msg.timer);
		  msg.timer = setInterval("fadeMsg(1)", MSGTIMER);
		  if(!autohide) {
		    autohide = MSGHIDE;  
		  }
		  window.setTimeout("hideMsg()", (autohide * 1000));
		}
		
		// hide the form alert //
		function hideMsg(msg) {
		  var msg = document.getElementById('msg');
		  if(!msg.timer) {
		    msg.timer = setInterval("fadeMsg(0)", MSGTIMER);
		  }
		}
		
		// face the message box //
		function fadeMsg(flag) {
		  if(flag == null) {
		    flag = 1;
		  }
		  var msg = document.getElementById('msg');
		  var value;
		  if(flag == 1) {
		    value = msg.alpha + MSGSPEED;
		  } else {
		    value = msg.alpha - MSGSPEED;
		  }
		  msg.alpha = value;
		  msg.style.opacity = (value / 100);
		  msg.style.filter = 'alpha(opacity=' + value + ')';
		  if(value >= 99) {
		    clearInterval(msg.timer);
		    msg.timer = null;
		  } else if(value <= 1) {
		    msg.style.display = "none";
		    clearInterval(msg.timer);
		  }
		}
		
		// calculate the position of the element in relation to the left of the browser //
		function leftPosition(target) {
		  var left = 0;
		  if(target.offsetParent) {
		    while(1) {
		      left += target.offsetLeft;
		      if(!target.offsetParent) {
		        break;
		      }
		      target = target.offsetParent;
		    }
		  } else if(target.x) {
		    left += target.x;
		  }
		  return left;
		}
		
		// calculate the position of the element in relation to the top of the browser window //
		function topPosition(target) {
		  var top = 0;
		  if(target.offsetParent) {
		    while(1) {
		      top += target.offsetTop;
		      if(!target.offsetParent) {
		        break;
		      }
		      target = target.offsetParent;
		    }
		  } else if(target.y) {
		    top += target.y;
		  }
		  return top;
		}
		
		// preload the arrow //
		if(document.images) {
		  arrow = new Image(7,80); 
		  arrow.src = "images/msg_arrow.gif"; 
		}
		
