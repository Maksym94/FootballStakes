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
<title>Edit regular game</title>
</head>
<body>
<h3><b>Edit</b> ${game.regularCommand1.commandName} VS
${game.regularCommand2.commandName}</h3><br>

<form:form action="${contextPath}/edit-regular-game" method="POST" modelAttribute="game">
<table>
<tr>
<td>
<img alt="command1" src="${contextPath}/${game.regularCommand1.photoPath}" height="128" 
width="128"></td>
<td><img alt="command2" src="${contextPath}/${game.regularCommand2.photoPath}" height="128" 
width="128"></td> 
</tr>
<tr>
<td>${game.regularCommand1.commandName}</td>
<td>${game.regularCommand2.commandName}</td>
</tr>
<tr>
<td>Score ${game.regularCommand1.commandName} </td><td>${game.scoreCommand1}</td>
</tr>
<tr>
<td>Score ${game.regularCommand2.commandName} </td><td>${game.scoreCommand2}</td>
</tr>
<tr>
<td>Coefficient ${game.regularCommand1.commandName} </td><td>${game.coefficientFirstCommand}</td>
</tr>
<tr>
<td>Coefficient ${game.regularCommand2.commandName} </td><td>${game.coefficientSecondCommand}</td>
</tr>
<tr>
<td>Start game date ${startDate}</td>
</tr>
<tr>
<td>Game finished: </td><td><c:choose>
<c:when test="${game.finishedGame}">
yes
</c:when>
<c:otherwise>no</c:otherwise>
</c:choose>
</td>
</tr>
</table>

</form:form>
</body>
</html>
