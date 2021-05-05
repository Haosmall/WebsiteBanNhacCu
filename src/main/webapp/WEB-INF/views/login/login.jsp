<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- <form action="" method="Post">
		<input type="text" name="email" /> <input type="password"
			name="password" /> <input type="submit" value="Login" />
	</form> -->
	<div id="logreg-forms">
		<form class="form-signin" action="" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Sign in</h1>
			<!-- <div class="social-login">
				<button class="btn facebook-btn social-btn" type="button">
					<span><i class="fab fa-facebook-f"></i> Sign in with
						Facebook</span>
				</button>
				<button class="btn google-btn social-btn" type="button">
					<span><i class="fab fa-google-plus-g"></i> Sign in with
						Google+</span>
				</button>
			</div> 
			<p style="text-align: center">OR</p>-->
			<input type="text" id="inputEmail" class="form-control"
				placeholder="Email address" required="" autofocus="" name="email"> 
				<input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="" name="password">

			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Sign in
			</button>
			<a href='forgot-password' id="forgot_pswd">Forgot password?</a>
			<hr>
			<!-- <p>Don't have an account!</p>  -->
			
		</form>
		<form class="form-signin" action="register">
			<button class="btn btn-primary btn-block" type="submit"
				id="btn-signup">
				<i class="fas fa-user-plus"></i> Sign up New Account
			</button>
		</form>

	</div>
</body>
</html>