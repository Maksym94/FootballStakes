<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New tournament </title>
</head>
<body>
<h3>Creating new tournament</h3><br>
<form:form action="${contextPath}/new-tournament" method="POST" 
modelAttribute="tournament" >
<table>
<tr>
<td><form:label path="tournamentName">Tournament name</form:label></td>
<td><form:input path="tournamentName"/></td>
</tr>
<tr>
<td><form:label path="yearOfPlaying">Year of playing</form:label></td>
<td><form:input path="yearOfPlaying"/></td>
</tr>
<tr>
<td><form:label path="maxAmountOfCommands">Maximum amount of commands</form:label></td>
<td><form:select path="maxAmountOfCommands">
<form:option value="8" label="small 8 commands"></form:option>
<form:option value="16" label="medium 16 commands"></form:option>
<form:option value="32" label="large 32 commands"></form:option>
</form:select></td>
</tr>
</table>
</form:form>
</body>
</html>
