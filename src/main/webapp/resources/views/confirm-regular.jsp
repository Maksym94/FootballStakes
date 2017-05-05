<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get result of new command</title>
</head>
<body>
<h3>Created regular command</h3><br>
<img src="${regularCommand.photoPath}"><br>
Command name: ${regularCommand.commandName}<br>
History: ${regularCommand.history}<br>
Trainer name: ${regularCommand.trainerName}<br>
Won games: ${regularCommand.wonGames}<br>
Lose games: ${regularCommand.loseGames}<br>
Draw games: ${regularCommand.drawGames}<br>
Photo path: ${regularCommand.photoPath}<br>
Year of foundation: ${regularCommand.yearFoundation}<br>
</body>
</html>
