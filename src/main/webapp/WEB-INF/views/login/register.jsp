<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<!-- <form action="" method="Post">
		<input type="text" name="email" /> <input type="password"
			name="password" /> <input type="submit" value="Login" />
	</form> -->
	<div id="logreg-forms">

		<form:form action="register" method="post" modelAttribute="user">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Register</h1>
			<!-- <div class="social-login">
				<button class="btn facebook-btn social-btn" type="button">
					<span><i class="fab fa-facebook-f"></i> Sign up with
						Facebook</span>
				</button>
			</div>
			<div class="social-login">
				<button class="btn google-btn social-btn" type="button">
					<span><i class="fab fa-google-plus-g"></i> Sign up with
						Google+</span>
				</button>
			</div>

			<p style="text-align: center">OR</p> -->
			
			<form:hidden path="userId"/>
			<form:input path="fullName" type="text" class="form-control" placeholder="Full name"
				required="" autofocus=""/>
			<form:errors cssStyle="color:red" path="fullName"/>

			<form:input path="email" type="email" class="form-control" placeholder="Email address" required="" autofocus=""/>
			<form:errors cssStyle="color:red"  path="email"/>
			
			<form:input path="phone" type="text" class="form-control" placeholder="Phone" required="" autofocus=""/>
			<form:errors cssStyle="color:red"  path="phone"/>
			
			<form:input path="password" type="password" class="form-control" placeholder="Password" required="" autofocus=""/> 
			<form:errors cssStyle="color:red"  path="password"/>
			
			<form:input path="passwordConf"
				type="password" class="form-control" placeholder="Repeat Password"
				required="" autofocus=""/>
			<form:errors cssStyle="color:red"  path="passwordConf"/>

			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Sign Up
			</button>
			<a href="login" id="cancel_signup"><i class="fas fa-angle-left"></i>
				Back</a>
		</form:form>
		<br>

	</div>
</body>
</html>