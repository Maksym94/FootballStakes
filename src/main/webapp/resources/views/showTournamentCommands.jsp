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
<title>Tournament commands, admin panel</title>
</head>
<body>
<h3>Show all tournament commands</h3><br>
<table>
<tr><th>Id</th>
<th>Name of command</th>
</tr>
<tr>
<c:if test="${tournamentCommands!=null && fn:length(tournamentCommands) gt 0}">
<c:forEach items="${tournamentCommands}" var="tournamentCommand">
<tr> <td>${tournamentCommand.idTournamentCommand}</td>
<td><a href="${contextPath}/show-tournament-command/${tournamentCommand.idTournamentCommand}">
${tournamentCommand.commandName}</a></td>
</tr>
</c:forEach>
</c:if>
<td></td>
</tr>
</table>
</body>
</html>
