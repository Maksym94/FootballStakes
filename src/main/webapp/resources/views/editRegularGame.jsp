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
<form:input path="idRegularGame" readonly="true" disabled="true"   /><form:hidden 
path="idRegularGame"/> </td>
</tr>
<tr>
<td><form:label path="scoreCommand1">Score ${game.regularCommand1.commandName}</form:label> </td>
<td><form:input path="scoreCommand1"/>  </td>
</tr>
<tr>
<td><form:label path="scoreCommand2">Score ${game.regularCommand2.commandName}</form:label> </td>
<td><form:input path="scoreCommand2"/>  </td>
</tr>
<tr>
<td><form:label path="coefficientFirstCommand">Coefficient of ${game.regularCommand1.commandName}
</form:label>  </td>
<td><form:input path="coefficientFirstCommand"/>  </td>
</tr>
<tr>
<td><form:label path="coefficientSecondCommand">Coefficient of ${game.regularCommand2.commandName}
</form:label>  </td>
<td><form:input path="coefficientSecondCommand"/>  </td>
</tr>
<tr>
<td>    <input id="datetime24" data-format="DD-MM-YYYY HH:mm" 
data-template="DD / MM / YYYY     HH : mm" name="datetime" value="${startDate}" type="text">
   </td>
</tr>
<tr>
<td><form:label path="finishedGame">Game finished:</form:label>  </td>
<td><form:select path="finishedGame">
<form:option value="false" label="no"></form:option>
<form:option value="true" label="yes"></form:option>
</form:select> </td>
</tr>
<tr>
<td><form:label path="resultOfGame">Result of game</form:label>  </td>
<td> <form:select path="resultOfGame">
<form:option value="-1" label="Won ${game.regularCommand1.commandName}"></form:option>
<form:option value="1" label="Won ${game.regularCommand2.commandName}"></form:option>
<form:option value="2" label="Draw"></form:option>
</form:select> </td>
</tr>
<form:hidden path="idCommand1"/>
<form:hidden path="idCommand2"/>
<tr><td><input type="submit" value="Confirm"></td>
</tr>
</table>
</form:form>
</body>
</html>

