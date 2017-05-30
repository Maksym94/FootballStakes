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
<title>New regular game</title>
</head>
<body>
<h3>Creating new regular game</h3><br>
<form:form action="${contextPath}/new-regular-game" method="POST"  
modelAttribute="regularGameModel">
<table>
<tr>
<td><form:select path="idCommand1" title="Choose first command">
<form:options items="${allCommands}" itemLabel="commandName" itemValue="idRegularCommand"/>
</form:select></td>
<td><form:select path="idCommand2" title="Choose second command">
<form:options items="${allCommands}" itemLabel="commandName" itemValue="idRegularCommand"/>
</form:select></td>
<form:hidden path="scoreCommand1"/><form:hidden path="scoreCommand2"/>
</tr>
<tr>
<td><form:label path="coefficientFirstCommand">Coefficient first command</form:label></td>
<td><form:input path="coefficientFirstCommand"/></td>
</tr>
<tr>
<td><form:label path="coefficientSecondCommand">Coefficient second command</form:label></td>
<td><form:input path="coefficientSecondCommand" /></td>
</tr>
<tr>
<td><form:label path="startGameDate">Start game date</form:label></td>
<td>    <input id="datetime24" data-format="DD-MM-YYYY HH:mm" 
data-template="DD / MM / YYYY     HH : mm" name="datetime" value="21-12-2012 20:30" type="text">
   </td>
<form:hidden path="finishedGame"/>
<form:hidden path="resultOfGame"/>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Submit"/>    
</td>
</tr>
</table>

</form:form>
</body>
</html>
