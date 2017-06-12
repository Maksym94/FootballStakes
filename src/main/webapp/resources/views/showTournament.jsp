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
<title>Show about tournament</title>
<style>
div.check{speak: Hi. I am Maksym. I would like to check it:1234567890 
}
.parent {
    display: flex;
    /* height: 300px;  */
    background-color: white;
     margin: 20px 0 20px 0; 
}
.teach {
    /* width: 100px;  
    height: 100px; */ 
    margin: auto; 
  border: solid 2px red; 
}
.child {
float:left;
    text-align:center;
    margin: auto; 
  border: solid 1px black; 
}
.link {
    text-align:center;
    margin: auto; 
  border: solid 1px black; 
}

</style>
</head>
<body>

<h3 align="center">${tournament.tournamentName}</h3><br>

<c:forEach begin="0" end="${tournament.maxAmountOfStages-1}" varStatus="indexStages">
<div class="parent">
<c:forEach begin="0" end="${Math.pow(2,indexStages.index)-1}" varStatus="indexGames">

<c:choose>
<c:when test="${tournament.tournamentStages!=null&& fn:length(tournament.tournamentStages) gt 0}">
<!-- <div class="baby"> -->
<div class="child">
<img alt="tournament command1" src="${contextPath}/${tournament.tournamentStages[indexStages.index]
.tournamentGames[indexGames.index].tournamentCommand1.photoPath}">
</div> 
<div class="child">
:
</div>
<div></div>

<div class="child">
<img alt="tournament command2" src="${contextPath}/${tournament.tournamentStages[indexStages.index]
.tournamentGames[indexGames.index].tournamentCommand2.photoPath}">
</div>

<div class="child">
<a href="${contextPath}/show-tournament-game/${tournament.tournamentStages[indexStages.index]
.tournamentGames[indexGames.index].idTournamentGame}">${tournament
.tournamentStages[indexStages.index].tournamentGames[indexGames.index].tournamentCommand1
.commandName} VS ${tournament.tournamentStages[indexStages.index].tournamentGames[indexGames.index]
.tournamentCommand2.commandName}</a>
</div>
</c:when>
<c:otherwise>
<div class="teach">
<div class="child">
<img alt="tournament command1" src="${contextPath}/uploads/tournament/tournamentDefault.jpg"
width="64" height="64">
</div>
<div class="child">
:
</div>

<div class="child">
<img alt="tournament command2" src="${contextPath}/uploads/tournament/tournamentDefault.jpg"
width="64" height="64">
</div>
<div class="link"> Some link</div>
</div>
</c:otherwise>
</c:choose>

</c:forEach>
</div>
</c:forEach>

</body>
</html>

<!-- tournamentDefault name of picture -->
<%-- <c:forEach begin="0" end="10" varStatus="loop">
    Index: ${loop.index}<br/>
</c:forEach> --%>