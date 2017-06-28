<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show about tournament</title>
<style>

.parent {
	display: flex;
	background-color: white;
	margin: 20px 0 20px 0;
}

.teach {
	margin: auto;
	/* border: solid 2px red; */
}

.child {
	float: left;
	text-align: center;
	margin: auto;
	 border: solid 1px black; 
}

.link {
	text-align: center;
	margin: auto;
	/* border: solid 1px black; */
}
</style>
</head>
<body>
<c:choose><c:when test="${tournament.tournamentName!=null}">
	<h3 align="center">${tournament.tournamentName}</h3>

	<div class="parent">
		<div class="teach">
			<c:choose>
				<c:when test="${tournament.winnerCommand!=null}">
					<div class="child">
						<img alt="tournament command1"
							src="${contextPath}/${tournament.winnerCommand.photoPath}">
					</div>
					<div class="child">commandName</div>
					<div class="link">
						<a
							href="${contextPath}/show-tournament-command/
						${tournament.winnerCommand.idTournamentCommand}">
							${tournament.winnerCommand.commandName}</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="child">
						<img alt="tournament command1"
							src="${contextPath}/uploads/tournament/tournamentDefault.jpg"
							width="64" height="64">
					</div>
					<div class="link">Link</div>
				</c:otherwise>

			</c:choose>
		</div>
	</div>

	<c:set var="realAmountStages"
		value="${fn:length(tournament.tournamentStages)}"></c:set>

	<c:forEach begin="0" end="${tournament.maxAmountOfStages-1}"
		varStatus="indexStages">
		<c:set var="descIndexList" value="${tournament.maxAmountOfStages-1-indexStages.index}">
		</c:set>
		<div class="parent">
			<c:forEach begin="0" end="${Math.pow(2,indexStages.index)-1}"
				varStatus="indexGames" >

				<c:choose>
					<c:when test="${tournament.tournamentStages!=null&& realAmountStages gt 0 
&&realAmountStages-1 >= descIndexList}">

						<div class="teach">
							<div class="child">
								<img alt="tournament command1"
									src="${contextPath}/${tournament.tournamentStages
[descIndexList].tournamentGames[indexGames.index].tournamentCommand1.photoPath}" width="64" 
height="64">
							</div>
							<div class="child">
								<img alt="tournament command2"
									src="${contextPath}/${tournament.tournamentStages
[descIndexList].tournamentGames[indexGames.index].tournamentCommand2.photoPath}" width="64" 
height="64">
							</div>

							<div class="link">
								<a
									href="${contextPath}/show-tournament-game/${tournament
									.tournamentStages[descIndexList]
.tournamentGames[indexGames.index].idTournamentGame}">${tournament
.tournamentStages[descIndexList].tournamentGames[indexGames.index].tournamentCommand1
.commandName}<c:if test="${tournament.maxAmountOfCommands ge 32}"><br></c:if> 
: <c:if test="${tournament.maxAmountOfCommands ge 32}"><br></c:if> 
									${tournament.tournamentStages[descIndexList]
									.tournamentGames[indexGames
.index].tournamentCommand2.commandName}</a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="teach">
							<div class="child">
								<img alt="tournament command1"
									src="${contextPath}/uploads/tournament/tournamentDefault.jpg"
									width="64" height="64">
							</div>
							<div class="child">
								<img alt="tournament command2"
									src="${contextPath}/uploads/tournament/tournamentDefault.jpg"
									width="64" height="64">
							</div>
							<div class="link">Some link</div>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</c:forEach>
<br>
<table align="center">
<tr>
<td><form action="${contextPath}/edit-tournament/${tournament.idTournament}">
<input type="submit" value="Edit tournament">
</form></td>
<td><form action="${contextPath}/delete-tournament/${tournament.idTournament}">
<input type="submit" value="Delete tournament">
</form></td>
</tr>
</table>
</c:when>
<c:otherwise><h3 align="center">No tournaments is available now</h3></c:otherwise>
</c:choose>
</body>
</html>