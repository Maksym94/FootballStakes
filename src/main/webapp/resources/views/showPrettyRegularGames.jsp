<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Regular games</title>
<style>

.main {
	display: flex;
	background-color: white;
	margin: 20px 0 20px 0;
}

.separate {
	margin: auto;
	  border: solid 1px black; 
}

.elementInsideHorisontal {
	float: left;
	text-align: center;
	margin: auto;
	/*  border: solid 1px black;  */
}
.scoreHorisontal {
	float: left;
	text-align: center;
	text-align:justify;
	margin: 50px 0 50px 0;
	margin-left: 30px;
	margin-right: 30px;
	/* margin: auto; */
}

.linkVertical {
	text-align: center;
	margin: auto;
	/* border: solid 1px black; */
}
</style>
</head>
<body>
<h3 align="center">Regular games playing</h3><br>

<c:if test="${regularGames!=null && fn:length(regularGames) gt 0}">
<c:forEach items="${regularGames}" var="regularGame">
<div class="main">
<div class="separate">
<div class="elementInsideHorisontal">
<img alt="regular command1" src="${contextPath}/${regularGame.regularCommand1.photoPath}" 
height="128" width="128"></div>
<div class="scoreHorisontal">${regularGame.scoreCommand1} : ${regularGame.scoreCommand2}</div>
<div class="elementInsideHorisontal">
<img alt="regular command2" src="${contextPath}/${regularGame.regularCommand2.photoPath}" 
height="128" width="128"></div>

<div class="linkVertical">
<a href="${contextPath}/show-regular-game/${regularGame.idRegularGame}">${regularGame
.regularCommand1.commandName} : ${regularGame.regularCommand2.commandName}</a></div>
</div>
</div>
</c:forEach>
</c:if>


<%-- <table>
<tr><th>Id</th>
<th>Name of game</th>
</tr>
<tr>
<c:if test="${regularGames!=null && fn:length(regularGames) gt 0}">
<c:forEach items="${regularGames}" var="regularGame">
<tr> <td> ${regularGame.idRegularGame}</td>
<td><a href="${contextPath}/show-regular-game/${regularGame.idRegularGame}">
${regularGame.regularCommand1.commandName} VS ${regularGame.regularCommand2.commandName}</a></td>
</tr>
</c:forEach>
</c:if>
<td></td>
</tr>
</table> --%>


</body>
</html>
