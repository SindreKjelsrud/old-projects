<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
		<link rel="stylesheet" href="../css/start.css">
	<head>
		<title>Andre Teit´s spill</title>
	</head>
	<body>
	<h2 style="color:red">${redirectMessage}</h2>
		
		<form action ="start" method="post">
	
				<h3>Number of players? (2-6)</h3>
				
				<input type="text" name="numPlayers" placeholder="number of players" class="textbox"/>
				<input type="submit" value ="Start game" class="button"/>
		</form>
	</body>
</html>