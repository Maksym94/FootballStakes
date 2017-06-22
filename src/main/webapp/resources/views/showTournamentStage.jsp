<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show about tournament stage</title>
</head>
<body>
<h3> <c:choose>
<c:when test="${tournamentStage.stage==1}">final</c:when>
<c:when test="${tournamentStage.stage==0.5}">1/2</c:when>
<c:when test="${tournamentStage.stage==0.25}">1/4</c:when>
<c:when test="${tournamentStage.stage==0.125}">1/8</c:when>
<c:when test="${tournamentStage.stage==0.0625}">1/16</c:when>
</c:choose> stage in ${tournamentStage.tournament.tournamentName}</h3><br>

<table>
<c:if test="${fn:length(tournamentStage.tournamentGames) gt 0}">
<c:forEach items="${tournamentStage.tournamentGames}" var="tournamentGame">
<tr>
<td><img alt="command1" src="${contextPath}/${tournamentGame.tournamentCommand1.photoPath}" 
height="64" width="64"></td>
<td><img alt="command2" src="${contextPath}/${tournamentGame.tournamentCommand2.photoPath}" 
height="64" width="64"></td>
</tr>
<tr>
<td>${tournamentGame.tournamentCommand1.commandName}</td>
<td>${tournamentGame.tournamentCommand2.commandName}</td>
</tr>
</c:forEach>
</c:if>
</table>
<form action="${contextPath}/edit-tournament-stage/${tournamentStage.idTournamentStage}">
<input type="submit" value="Edit stage">
</form>

</body>
</html>
