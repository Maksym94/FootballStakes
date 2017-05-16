<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get result of new regular game</title>
</head>
<body>
<h3>Created regular game</h3><br>
 ${regularGameModel.regularCommand1.commandName} VS 
 ${regularGameModel.regularCommand2.commandName}<br>
Score: ${regularGameModel.scoreCommand1}:${regularGameModel.scoreCommand2}<br>
Coefficient  ${regularGameModel.regularCommand1.commandName}: 
${regularGameModel.coefficientFirstCommand}<br>
Coefficient  ${regularGameModel.regularCommand2.commandName}: 
${regularGameModel.coefficientSecondCommand}<br>
Start game date: ${regularGameModel.startGameDate}<br>
Game finished: <c:choose>
<c:when test="${regularGameModel.finishedGame}">
yes
</c:when>
<c:otherwise>
no
</c:otherwise>
</c:choose><br>
<c:if test="${regularGameModel.finishedGame}">
Result of game: <c:choose>
<c:when test="${regularGameModel.resultOfGame==-1}">
Win  ${regularGameModel.regularCommand1.commandName}
</c:when>
<c:when test="${regularGameModel.resultOfGame==0}">Draw</c:when>
<c:otherwise>Win  ${regularGameModel.regularCommand2.commandName}</c:otherwise>
</c:choose>
</c:if><br>
</body>
</html>
