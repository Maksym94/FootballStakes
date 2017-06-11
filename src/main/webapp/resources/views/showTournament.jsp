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
<title>Show about tournament</title>
<style>
div.check{speak: Hi. I am Maksym. I would like to check it:1234567890 
}
.parent {
    display: flex;
    height: 300px; 
    background-color: white;
}
.child {
    width: 100px;  
    height: 100px; 
    margin: auto; 
}
.baby {
    width: 100px;  
    height: 100px; 
    margin: auto; 
}
</style>
</head>
<body>

<h3 align="center">${tournament.tournamentName}</h3><br>

<c:forEach begin="0" end="${tournament.maxAmountOfStages}" varStatus="indexStages">
<div class="parent">
<c:forEach begin="0" end="${Math.pow(2,indexStages)}" varStatus="indexGames">
<div class="child">
<c:choose>
<c:when test="${tournament.tournamentStages!=null}">
<div class="baby">
<img alt="tournament command1" src="${contextPath}/${tournament.tournamentStages[indexStages]
.tournamentGames[indexGames].tournamentCommand1.photoPath}">
</div>
<div class="baby">:</div>
<div class="baby">
<img alt="tournament command2" src="${contextPath}/${tournament.tournamentStages[indexStages]
.tournamentGames[indexGames].tournamentCommand2.photoPath}">
</div>
<a href="${contextPath}/show-tournament-game/${tournament.tournamentStages[indexStages]
.tournamentGames[indexGames].idTournamentGame}">${tournament.tournamentStages[indexStages]
.tournamentGames[indexGames].tournamentCommand1.commandName} VS ${tournament
.tournamentStages[indexStages].tournamentGames[indexGames].tournamentCommand2.commandName}</a>
</c:when>
<c:otherwise>
<div class="baby">
<img alt="tournament command1" src="${contextPath}/uploads/tournament/tournamentDefault.jpg">
</div>
<div class="baby">:</div>
<div class="baby">
<img alt="tournament command2" src="${contextPath}/uploads/tournament/tournamentDefault.jpg">
</div>
</c:otherwise>
</c:choose>
</div>
</c:forEach>
</div>
</c:forEach>



</body>
</html>

<!-- tournamentDefault name of picture -->
<%-- <c:forEach begin="0" end="10" varStatus="loop">
    Index: ${loop.index}<br/>
</c:forEach> --%>