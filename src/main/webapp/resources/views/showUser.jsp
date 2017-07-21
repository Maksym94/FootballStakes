<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show about user</title>
<style>
table {
	width: 90%;
	border-top: 1px solid #e5eff8;
	border-right: 1px solid #e5eff8;
	margin: 1em auto;
	border-collapse: collapse;
}

td {
	color: #678197;
	border-bottom: 1px solid #e5eff8;
	border-left: 1px solid #e5eff8;
	padding: .3em 1em;
	text-align: center;
}

tr.odd td {
	background: #f7fbff
}

tr.odd .column1 {
	background: #f4f9fe;
}

.column1 {
	background: #f9fcfe;
}
.moneyAdd {
	color: #00b300;
}
.moneyGet {
	color: #ff1a1a;
}

</style>
 <script src="${contextPath}/resources/js/show_hide.js"></script>
</head>
<body>

<h3 align="center">View profile <b>${user.username}</b></h3><br>

<table align="center" class="table">
<tr class="column1">
<td>Avatar</td>
<td><img alt="user picture" src="${contextPath}/uploads/user/defaultUser.jpg" 
height="64" width="64"></td>
</tr>
<tr>
<td>Balance</td>
<td><c:if test="${user.balance==null}">0.00</c:if>${user.balance} $</td>
</tr>
<tr >
<td>Stakes won</td>
<td>${user.stakesWon}</td>
</tr>
<tr>
<td>Stakes lose</td>
<td>${user.stakesLose}</td>
</tr>
<tr>
<td >Money won</td>
<td ><c:if test="${user.moneyWon==null}">0.00</c:if>${user.moneyWon}</td>
</tr>
<tr>
<td>Money lose</td>
<td><c:if test="${user.moneyLose==null}">0.00</c:if>${user.moneyLose}</td>
</tr>
<tr>
<td>Received gift money</td>
<td><c:if test="${user.receivedGiftMoney==null}">0.00</c:if>${user.receivedGiftMoney}</td>
</tr>
<tr>
<td>Sent gift money</td>
<td><c:if test="${user.sentGiftMoney==null}">0.00</c:if>${user.sentGiftMoney}</td>
</tr>
<tr>
<td>Operations</td>
<td>
<c:choose>
<c:when test="${user.operations!=null&& fn:length(user.operations) gt 0}">
<a href="javascript: show_hide('s1')">
<img src="${contextPath}/resources/pictures/plus.gif" id="pics1" title="Show" border="0">
</a>
<div id="ss1" style="display: none;"> 
<table>
<tr class="column1" > 
<th>Id</th>
<th>Date</th>
<th>Amount</th>
<th>Current balance</th>
</tr>
<c:forEach items="${user.operations}" var="operation">
<tr>
<td>${operation.idOperation}</td>
<td>${operation.date}</td>
<td> 
<c:choose>
<c:when test="${operation.amount gt 0}">
<label class="moneyAdd">
+ <fmt:formatNumber value="${operation.amount}" maxFractionDigits="2"/>
</label>
</c:when>
<c:otherwise>
<label class="moneyGet"><fmt:formatNumber value="${operation.amount}" maxFractionDigits="2"/>
</label>
</c:otherwise>
</c:choose>
</td>
<td><fmt:formatNumber value="${operation.currentBalance}" maxFractionDigits="2"/></td>
</tr>
</c:forEach>
</table>
</div>
<script>

</script>
</c:when>
<c:otherwise>
<h4>No operations is available</h4>
</c:otherwise>
</c:choose>

</td>
</tr>
<tr>
<td><form action="${contextPath}/add-money" method="GET">
<input type="submit" value="Add money">
</form> </td> 
<td><form action="${contextPath}/get-money" method="GET">
<input type="submit" value="Get money">
</form> </td> 
</tr>
</table>
</body>
</html>
