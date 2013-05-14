<%-- 
    Document   : login
    Created on : Mar 3, 2013, 9:05:11 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Includes/header.jsp"%>
    <!-- forma login -->
	<div class="row">
		<div class="large-8 large-centered columns">
			<form action="Login" method="post">
				<fieldset>
					<legend>Login</legend>
						<div class="row">
							<div class="large-12 columns">
								<label>Email</label>
								<input type="text" placeholder="Tu email" name="email">
							</div>
						</div>
						<div class="row">
							<div class="large-12 columns">
								<label>Password</label>
								<input type="password" placeholder="Tu password" name="password">
							</div>
						</div>
						<div class="row">
							<div class="large-offset-9 columns">
								<input class="small button" type="submit" value="Login">
							</div>
						</div>
				</fieldset>
			</form>
		</div>
	</div>
    <!-- termina forma login -->
    <!-- otras opciones -->
    <div class="row">
        <div class="large-8 large-centered columns">
            <div class="large-6 columns text-center">
                <a class="button small secondary" href="CreaUsuario">¿No estas registrado?</a>
            </div>
            <div class="large-6 columns text-center">
                <a class="button small secondary" href="RecuperaCuenta">¿Olvidaste tus datos?</a>
            </div>
        </div>
    </div>
	<!-- termina forma login -->
<%@include file="/WEB-INF/Includes/footer.jsp" %>