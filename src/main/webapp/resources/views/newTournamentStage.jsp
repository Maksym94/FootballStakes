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
<title>New tournament stage</title>
</head>
<body>
<h3>Creating new tournament stage</h3><br>
<form:form action="${contextPath}/new-tournament-stage" method="POST"   
modelAttribute="tournamentStage">
<table>
<tr>
<td><form:label path="stage">Choose stage</form:label></td>
<td><form:select path="stage" title="Choose stage">
<form:option value="1" label="Final"></form:option>
<form:option value="0.5" label="1/2"></form:option>
<form:option value="0.25" label="1/4"></form:option>
<form:option value="0.125" label="1/8"></form:option>
<form:option value="0.0625" label="1/16"></form:option>
</form:select>
</td>
</tr>
<tr>
<td><form:label path="tournament">Choose tournament</form:label></td>
<td>
<select name="idTournament">
<c:forEach items="${tournaments}" var="tournament">
<option value="${tournament.idTournament}">${tournament.tournamentName}</option>
</c:forEach>
</select></td>
</tr>
<tr>
<td><form:label path="tournamentGames">Tournament games</form:label></td>
</tr>
<c:forEach items="${tournamentGames}" varStatus="status" var="tournamentGame">
<tr>
<td>${tournamentGame.tournamentCommand1.commandName}:${tournamentGame.tournamentCommand2
.commandName}</td>
<td><input name="selectedGames" type="checkbox" value="${tournamentGame.idTournamentGame}"> </td>
</tr>
</c:forEach>
<tr>
<td><form:label path="active">Is active:</form:label>  </td>
<td><form:select path="active">
<form:option value="false" label="no"></form:option>
<form:option value="true" label="yes"></form:option>
</form:select> </td>
</tr>
<form:hidden path="finishedStage"/>
</table>
<input type="submit" value="Create stage"/>
</form:form>
</body>
</html>
