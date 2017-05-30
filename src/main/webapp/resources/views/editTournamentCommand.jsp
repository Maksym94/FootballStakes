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
<title>Edit tournament command</title>
</head>
<body>
<h3>Edit tournament command</h3><br>
<form:form action="${contextPath}/edit-tournament-command" method="POST" 
modelAttribute="tournamentCommand" enctype="multipart/form-data">
<img alt="tournament command" src="${contextPath}/${tournamentCommand.photoPath}" 
height="128" width="128"><br>
<input type="file" name="tournamentCommandPicture" 
accept="image/jpeg,image/png,image/gif"><br>
<table>
<tr><td><form:input path="idTournamentCommand" readonly="true" disabled="true"   /><form:hidden 
path="idTournamentCommand"/> </td></tr>
<tr>
<td><form:label path="commandName">Command name</form:label></td>
<td><form:input path="commandName"/></td>
</tr>
<tr>
<td><form:label path="history">History</form:label></td>
<td><form:input path="history"/></td>
</tr>
<tr>
<td><form:label path="trainerName">Trainer name</form:label></td>
<td><form:input path="trainerName"/></td>
</tr>
<tr>
<td><form:label path="wonGames">Won games</form:label></td>
<td><form:input path="wonGames"/></td>
</tr>
<tr>
<td><form:label path="loseGames">Lose games</form:label></td>
<td><form:input path="loseGames"/></td>
</tr>
<tr>
<td><form:label path="goalsScored">Goals scored</form:label></td>
<td><form:input path="goalsScored"/></td>
</tr>
<tr>
<td><form:label path="winningCups">Winning cups:</form:label></td>
<td><form:input path="winningCups"/></td>
</tr>
<tr>
<td><form:label path="yearFoundation">Year of foundation</form:label></td>
<td><form:input path="yearFoundation"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Submit"/>    
</td>
</tr>
</table>
<form:hidden path="photoPath"/>
</form:form>
</body>
</html>
