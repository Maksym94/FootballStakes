<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
    .error {
        color: red; font-weight:lighter; 
    }
</style>
</head>
<body>
<h3 align="center">Registration new user</h3>
<form:form action="${contextPath}/registration" modelAttribute="credentials" method="POST">
<table align="center">
<tr>
<td><form:label path="login">Login</form:label></td>
<td><form:input path="login"/></td>
<td><form:errors path="login" cssClass="error"></form:errors></td>
</tr>
<tr>
<td><form:label path="password">Password</form:label></td>
<td><form:password  path="password"/></td>
<td><form:errors path="password"  cssClass="error"></form:errors></td>
</tr>
<tr>
<td><form:label path="confirmPassword">Confirm password</form:label></td>
<td><form:password path="confirmPassword"/></td>
<td><form:errors path="confirmPassword" cssClass="error"></form:errors></td>
</tr>
<tr>
<td><input type="submit" value="Create"></td>
</tr>
</table>
</form:form>

</body>
</html>