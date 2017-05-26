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
<title>Show about tournament command</title>
</head>
<body>
<h3>${tournamentCommand.commandName}</h3><br>
<table>
<tr>
<td>
<img alt="regularCommand" src="${contextPath}/${tournamentCommand.photoPath}" height="128" 
width="128">
</td>
</tr>
<tr>
<td>History: </td><td>${tournamentCommand.history}</td>
</tr>
<tr>
<td>Trainer name: </td><td>${tournamentCommand.trainerName}</td>
</tr>
<tr>
<td>Won games: </td><td>${tournamentCommand.wonGames}</td>
</tr>
<tr>
<td>Lose games: </td> <td>${tournamentCommand.loseGames}</td>
</tr>
<tr>
<td>Goals scored: </td> <td>${tournamentCommand.goalsScored}</td> 
</tr>
<tr>
<td>Year of foundation: </td> <td>${tournamentCommand.yearFoundation}</td> 
</tr>
<tr>
<td>Winning cups: </td> <td>${tournamentCommand.winningCups}</td> 
</tr>
<tr><td>
<form action="${contextPath}/edit-tournament-command/${tournamentCommand.idRegularCommand}">
<input  type="submit" value="Edit command" >
</form></td>
 <td><form action="${contextPath}/delete-tournament-command/${tournamentCommand.idRegularCommand}">
<input  type="submit" value="Delete command" >
</form>
</td> 
</tr>
</table>
</body>
</html>

<%-- h3>Created tournament command</h3><br>
<img src="${tournamentCommand.photoPath}" height="128" width="128"><br>
Command name: ${tournamentCommand.commandName}<br>
History: ${tournamentCommand.history}<br>
Trainer name: ${tournamentCommand.trainerName}<br>
Year of foundation: ${tournamentCommand.yearFoundation}<br>
Won games: ${tournamentCommand.wonGames}<br>
Lose games: ${tournamentCommand.loseGames}<br>
Goals scored: ${tournamentCommand.goalsScored}<br>
Winning cups: ${tournamentCommand.winningCups}<br>
Photo path: ${tournamentCommand.photoPath}<br> --%>