<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${action} user money</title>
<style>
    .error {
        color: red; font-weight:lighter; 
       /*  color: #ff0000; */
	font-style: italic;
    }
</style>
</head>
<body>
<h3 align="center">${action} user money</h3>
<form:form action="${contextPath}/${fn:toLowerCase(action)}-money" modelAttribute="operation" method="POST">
<table align="center">
<tr>
<td><form:label path="rawAmount">Enter amount</form:label></td>
<td><form:input   path="rawAmount" min="0.01" step="0.01" placeholder="0.00"/></td>
<td><form:errors path="rawAmount" cssClass="error"></form:errors>
 <c:if test="${notEnough!=null}"><h4 style="error">${notEnough}</h4></c:if></td>
</tr>
<tr>
<td><input type="submit" value="${action} money"></td>
</tr>
</table>
</form:form>


</body>
</html>