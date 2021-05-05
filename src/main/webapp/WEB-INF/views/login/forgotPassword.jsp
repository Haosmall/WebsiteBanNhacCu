<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot password</title>
</head>
<body>
	<!-- <form action="" method="Post">
		<input type="text" name="email" /> <input type="password"
			name="password" /> <input type="submit" value="Login" />
	</form> -->
	<div id="logreg-forms">
		<form action="forgot-password" method="post">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Forgot password</h1>
			<input name="email" type="email" id="resetEmail" class="form-control"
				placeholder="Email address" required="" autofocus="">
			<button class="btn btn-primary btn-block" type="submit">Reset
				Password</button>
			<a href="login" id="cancel_reset"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
		<br>

	</div>

</body>
</html>