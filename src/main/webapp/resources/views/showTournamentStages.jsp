<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tournament stages, admin panel</title>
</head>
<body>
<h3>Show all tournament stages</h3><br>
<table>
<tr><th>Id</th>
<th>Name of stage</th>
</tr>

<c:if test="${fn:length(tournamentStages) gt 0}">
<c:forEach items="${tournamentStages}" var="tournamentStage">
<tr> <td> ${tournamentStage.idTournamentStage}</td>
<td><a href="${contextPath}/show-tournament-stage/${tournamentStage.idTournamentStage}">
<c:choose>
<c:when test="${tournamentStage.stage==1}">final</c:when>
<c:when test="${tournamentStage.stage==0.5}">1/2</c:when>
<c:when test="${tournamentStage.stage==0.25}">1/4</c:when>
<c:when test="${tournamentStage.stage==0.125}">1/8</c:when>
<c:when test="${tournamentStage.stage==0.0625}">1/16</c:when>
</c:choose>
 stage in ${tournamentStage.tournament.tournamentName}
 </a></td>
</tr>
</c:forEach>
</c:if>
</table>
</body>
</html>
