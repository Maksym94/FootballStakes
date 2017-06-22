<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show about tournament game</title>
</head>
<body>
<h3> ${tournamentGame.tournamentCommand1.commandName} national team VS
${tournamentGame.tournamentCommand2.commandName} national team</h3><br>

<table>
<tr>
<td>
<img alt="command1" src="${contextPath}/${tournamentGame.tournamentCommand1.photoPath}" height="128" width="128">
</td>
<td><img alt="command2" src="${contextPath}/${tournamentGame.tournamentCommand2.photoPath}" height="128" width="128">
</td> 
</tr>
<tr>
<td><a href="${contextPath}/show-tournament-command/${tournamentGame.tournamentCommand1
.idTournamentCommand}">${tournamentGame.tournamentCommand1.commandName} national team</a></td>
<td><a href="${contextPath}/show-tournament-command/${tournamentGame.tournamentCommand2
.idTournamentCommand}">${tournamentGame.tournamentCommand2.commandName} national team</a></td>
<%-- <td>${tournamentGame.tournamentCommand2.commandName} national team</td> --%>
</tr>
<tr>
<td>Score ${tournamentGame.tournamentCommand1.commandName} </td><td>${tournamentGame.scoreCommand1}</td>
</tr>
<tr>
<td>Score ${tournamentGame.tournamentCommand2.commandName} </td><td>${tournamentGame.scoreCommand2}</td>
</tr>
<tr>
<td>Coefficient ${tournamentGame.tournamentCommand1.commandName} </td><td>${tournamentGame.coefficientFirstCommand}</td>
</tr>
<tr>
<td>Coefficient ${tournamentGame.tournamentCommand2.commandName} </td><td>${tournamentGame.coefficientSecondCommand}</td>
</tr>
<tr>
<td>Start game date ${startDate}</td>
</tr>
<tr>
<td>Game finished: </td><td><c:choose>
<c:when test="${tournamentGame.finishedGame}">
yes
</c:when>
<c:otherwise>no</c:otherwise>
</c:choose>
</td>
</tr>
<tr><td>
<form action="${contextPath}/edit-tournament-game/${tournamentGame.idTournamentGame}">
<input  type="submit" value="Edit game" onmouseup="buttonColor(this)">
</form></td>
 <td><form action="${contextPath}/delete-tournament-game/${tournamentGame.idTournamentGame}" >
<input  type="submit" value="Delete game" onmouseup="buttonColor(this)">
</form>
</td> 
</tr>
</table>

<script>
function buttonColor(x) {
    x.style.background = "pink";
}
</script>
</body>
</html>
