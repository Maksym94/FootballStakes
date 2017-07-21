<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Football stakes</title>
<style>
.error {
	color: red;
	font-weight: lighter;
}

#big {
	width: 30em;
	height: 6em;
}

.parent {
	display: flex;
	background-color: white;
	margin: 20px 0 20px 0;
}

.teach {
	margin: auto;
	/* border: solid 2px red; */
}

.child {
	float: left;
	text-align: center;
	margin: auto;
	border: solid 1px black;
}
</style>

</head>
<body>
<h3 align="center" style="color:#3385ff">Football stakes</h3>
<sec:authorize access="isAuthenticated()">
<img alt="default" src="${contextPath}/uploads/user/defaultUser.jpg" height="150" width="127.5">
<br>
Welcome, <a href="${contextPath}/show-user/${user.idUser}">${user.username}</a>
<form action="${contextPath}/logout" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<br><input type="submit" value="Logout">
</form>
</sec:authorize>

<sec:authorize access="isAnonymous()">
<form action="${contextPath}/index" method="POST">
<input type="text" name="login" placeholder="Username"><br>
<input type="password" name="password" placeholder="Password"><br>
<span>${error}</span><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit" value="Log in"><br><br>
Nor registered? <a href="${contextPath}/registration">Registration</a>
</form>
</sec:authorize>
<div class="parent">
<div class="child">
<form action="${contextPath}/show-tournament">
<input type="submit"  id="big" value="Show tournament">
</form>
</div>
<div class="child">
<form action="${contextPath}/show-prettyRegular-games">
<input type="submit"  id="big" value="Show regular games">
</form>
</div>
</div>
</body>
</html>