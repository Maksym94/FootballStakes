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
<title>Edit tournament</title>
</head>
<body>
<h3>Edit tournament</h3><br>
<form:form action="${contextPath}/edit-tournament" method="POST"   
modelAttribute="tournament">
<table>
<tr>
<td><form:label path="tournamentName">Name</form:label></td>
<td><form:input path="tournamentName"/></td>
</tr>
<tr>
<td><form:label path="yearOfPlaying">Year of playing</form:label></td>
<td><form:input path="yearOfPlaying"/></td>
</tr>
</table>
<c:if test="${tournament.tournamentStages!=null&& fn:length(tournament.tournamentStages) gt 0}">
<c:forEach items="${tournament.tournamentStages}" var="tournamentStage">
<input type="hidden" name="existedStages" value="${tournamentStage.idTournamentStage}">
</c:forEach>
</c:if>
<table>
<tr>
<td><form:label path="maxAmountOfCommands">Size of tournament:</form:label> 
<input type="hidden" name="prevAmountCommands" value="${tournament.maxAmountOfCommands}"> 
</td>

<td><form:select path="maxAmountOfCommands">
<form:option value="8" label="small 8 commands"></form:option>
<form:option value="16" label="medium 16 commands"></form:option>
<form:option value="32" label="large 32 commands"></form:option>
</form:select></td>
</tr>
</table>
<input type="hidden" name="tournamentIdRedirect" value="${tournament.idTournament}">
<form:hidden path="idTournament"/>
<form:hidden path="finishedTournament"/>
<form:hidden path="active"/>
<form:hidden path="maxAmountOfStages"/>
<input type="submit" value="Edit tournament"/>
</form:form>
<br>
<table border="1">
<tr><th>Stages</th> </tr>
<c:choose>
<c:when test="${tournament.tournamentStages!=null && fn:length(tournament.tournamentStages)gt 0}">
<c:forEach items="${tournament.tournamentStages}" var="tournamentStage">
<tr>
<td>1/${Math.round(1/tournamentStage.stage)}</td>
<td><form action="${contextPath}/delete-inTournament-stage/${tournamentStage.idTournamentStage}">
<input type="hidden" name="redirectTournament" value="${tournament.idTournament}">
<input type="submit" value="Delete tournament stage">
</form>

</td>
</tr>
</c:forEach>
</c:when>
<c:otherwise> <tr><td>No stages </td> </tr> </c:otherwise>
</c:choose>
</table>
</body>
</html>
