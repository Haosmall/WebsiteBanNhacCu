<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify password</title>
</head>
<body>
	<div id="logreg-forms">
		<c:url
			value="/forgot-password/enter-password?email=${email}&token=${token}"
			var="url" />
		<form action="${url}" method="post">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Change password</h1>

			<input name="password" type="password" class="form-control"
				placeholder="Password" required="" autofocus="" />
			<input
				type="password" class="form-control" placeholder="Repeat Password"
				required="" autofocus="" />

			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i>Change password
			</button>
		</form>

		<p class="mt-3 mb-1">
			<a href='<c:url value="/login"  />'>Đăng nhập</a>
		</p>
	</div>
</body>
</html>