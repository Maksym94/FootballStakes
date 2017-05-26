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
<title>Show about regular command</title>
</head>
<body>
<h3>${regularCommand.commandName}</h3><br>
<table>
<tr>
<td>
<img alt="regularCommand" src="${contextPath}/${regularCommand.photoPath}" height="128" width="128">
</td>
</tr>
<tr>
<td>History: </td><td>${regularCommand.history}</td>
</tr>
<tr>
<td>Trainer name: </td><td>${regularCommand.trainerName}</td>
</tr>
<tr>
<td>Country of origin: </td><td>${regularCommand.countryOfOrigin}</td>
</tr>
<tr>
<td>Won games: </td><td>${regularCommand.wonGames}</td>
</tr>
<tr>
<td>Lose games: </td> <td>${regularCommand.loseGames}</td>
</tr>
<tr>
<td>Draw games: </td><td>${regularCommand.drawGames}</td>
</tr>
<tr>
<td>Goals scored: </td> <td>${regularCommand.goalsScored}</td> 
</tr>
<tr>
<td>Year of foundation: </td> <td>${regularCommand.yearFoundation}</td> 
</tr>
<tr><td>
<form action="${contextPath}/edit-regular-command/${regularCommand.idRegularCommand}">
<input  type="submit" value="Edit command" >
</form></td>
 <td><form action="${contextPath}/delete-regular-command/${regularCommand.idRegularCommand}" >
<input  type="submit" value="Delete command" >
</form>
</td> 
</tr>
</table>
</body>
</html>