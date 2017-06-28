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
<title>Edit tournament stage</title>
</head>
<body>
<h3>Edit tournament stage</h3><br>
<form:form action="${contextPath}/edit-tournament-stage" method="POST"   
modelAttribute="tournamentStage">
<table>
<tr>
<td><form:label path="stage">Stage</form:label></td>
<td>
<input type="text" value="1/${Math.round(1/tournamentStage.stage)}" disabled="disabled">
<form:hidden path="stage"/>
</td>
</tr>
<tr>
<td><form:label path="tournament">Id tournament</form:label></td>
<td><input type="text" disabled="disabled" value="${tournamentStage.tournament.idTournament}">
<input type="hidden" name="idTournament" value="${tournamentStage.tournament.idTournament}">
</td>
</tr>
<tr>
<td><form:label path="tournamentGames">Already existed games</form:label></td>
</tr>
<c:forEach items="${tournamentStage.tournamentGames}" varStatus="status" var="tournamentGame">
<tr>
<td>${tournamentGame.tournamentCommand1.commandName}:${tournamentGame.tournamentCommand2
.commandName}</td>
<td><input name="selectedGames" checked="checked" type="checkbox" 
value="${tournamentGame.idTournamentGame}"> </td>
</tr>
</c:forEach>
<c:if test="${tournamentGames!=null && fn:length(tournamentGames)gt 0}">
<tr> <td>Available games</td> </tr>
<c:forEach items="${tournamentGames}" var="newGame">
<tr>
<td>${newGame.tournamentCommand1.commandName}:${newGame.tournamentCommand2
.commandName}</td>
<td><input name="selectedGames" type="checkbox" value="${newGame.idTournamentGame}"></td>
</tr>
</c:forEach>
</c:if>
<tr>
<td><form:label path="active">Is active:</form:label>  </td>
<td><form:select path="active">
<form:option value="false" label="no"></form:option>
<form:option value="true" label="yes"></form:option>
</form:select> </td>
</tr>
<tr>
<td><form:label path="finishedStage">Is finished stage:</form:label></td>
<td><form:select path="finishedStage">
<form:option value="false" label="no"></form:option>
<form:option value="true" label="yes"></form:option>
</form:select> </td>
</tr>
</table>
<form:hidden path="idTournamentStage"/>
<input type="submit" value="Edit stage"/>
</form:form>
</body>
</html>
