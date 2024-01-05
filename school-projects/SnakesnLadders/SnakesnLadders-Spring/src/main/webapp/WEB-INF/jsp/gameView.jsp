<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>Andrew Tate's LadderGame</title>
    <link rel="stylesheet" href="../css/laddergame.css" />
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script> 
</head>
<body>
	
	<p hidden="hidden" id="playersTurn">${playersTurn}</p>
	<p hidden="hidden" id="numPlayers">${numPlayers}</p>

	<p hidden="hidden" id="player1from">${player1from}</p>
	<p hidden="hidden" id="player2from">${player2from}</p>
	<p hidden="hidden" id="player3from">${player3from}</p>
	<p hidden="hidden" id="player4from">${player4from}</p>
	
	<p hidden="hidden" id="player1to">${player1to}</p>
	<p hidden="hidden" id="player2to">${player2to}</p>
	<p hidden="hidden" id="player3to">${player3to}</p>
	<p hidden="hidden" id="player4to">${player4to}</p>

	
	<!-- NAVBAR -->
	<nav>
		<input type="checkbox" id="check"> <label for="check"
			class="checkbtn"> <i class="fas fa-bars"></i>
		</label> <label class="logo">Tate´s Snakes n Ladders</label>
		<ul>
			<li><a href="home" class="active">home</a></li>
			<li><a href="rules">rules</a></li>
			<li><a href="about">about us</a></li>
		</ul>
	</nav>

	<!-- GRID -->
	<div class="grid-container">
		<!-- PLAYERS GRID -->
		<div class="player-grid">
			<ul>
				<c:forEach var="p" items="${playersInPlay}">
					<li id="${p.playerLabel}">${p.playerInfo}</li>
				</c:forEach>	
			</ul>
		</div>

		<!-- BOARD GRID -->
		<div class="board-grid">

			<div class="board-item" id="100"></div>
			<div class="board-item" id="99"></div>
			<div class="board-item" id="98"></div>
			<div class="board-item" id="97"></div>
			<div class="board-item" id="96"></div>
			<div class="board-item" id="95"></div>
			<div class="board-item" id="94"></div>
			<div class="board-item" id="93"></div>
			<div class="board-item" id="92"></div>
			<div class="board-item" id="91"></div>

			<div class="board-item" id="81"></div>
			<div class="board-item" id="82"></div>
			<div class="board-item" id="83"></div>
			<div class="board-item" id="84"></div>
			<div class="board-item" id="85"></div>
			<div class="board-item" id="86"></div>
			<div class="board-item" id="87"></div>
			<div class="board-item" id="88"></div>
			<div class="board-item" id="89"></div>
			<div class="board-item" id="90"></div>

			<div class="board-item" id="80"></div>
			<div class="board-item" id="79"></div>
			<div class="board-item" id="78"></div>
			<div class="board-item" id="77"></div>
			<div class="board-item" id="76"></div>
			<div class="board-item" id="75"></div>
			<div class="board-item" id="74"></div>
			<div class="board-item" id="73"></div>
			<div class="board-item" id="72"></div>
			<div class="board-item" id="71"></div>

			<div class="board-item" id="61"></div>
			<div class="board-item" id="62"></div>
			<div class="board-item" id="63"></div>
			<div class="board-item" id="64"></div>
			<div class="board-item" id="65"></div>
			<div class="board-item" id="66"></div>
			<div class="board-item" id="67"></div>
			<div class="board-item" id="68"></div>
			<div class="board-item" id="69"></div>
			<div class="board-item" id="70"></div>

			<div class="board-item" id="60"></div>
			<div class="board-item" id="59"></div>
			<div class="board-item" id="58"></div>
			<div class="board-item" id="57"></div>
			<div class="board-item" id="56"></div>
			<div class="board-item" id="55"></div>
			<div class="board-item" id="54"></div>
			<div class="board-item" id="53"></div>
			<div class="board-item" id="52"></div>
			<div class="board-item" id="51"></div>

			<div class="board-item" id="41"></div>
			<div class="board-item" id="42"></div>
			<div class="board-item" id="43"></div>
			<div class="board-item" id="44"></div>
			<div class="board-item" id="45"></div>
			<div class="board-item" id="46"></div>
			<div class="board-item" id="47"></div>
			<div class="board-item" id="48"></div>
			<div class="board-item" id="49"></div>
			<div class="board-item" id="50"></div>

			<div class="board-item" id="40"></div>
			<div class="board-item" id="39"></div>
			<div class="board-item" id="38"></div>
			<div class="board-item" id="37"></div>
			<div class="board-item" id="36"></div>
			<div class="board-item" id="35"></div>
			<div class="board-item" id="34"></div>
			<div class="board-item" id="33"></div>
			<div class="board-item" id="32"></div>
			<div class="board-item" id="31"></div>
			
			<div class="board-item" id="21"></div>
			<div class="board-item" id="22"></div>
			<div class="board-item" id="23"></div>
			<div class="board-item" id="24"></div>
			<div class="board-item" id="25"></div>
			<div class="board-item" id="26"></div>
			<div class="board-item" id="27"></div>
			<div class="board-item" id="28"></div>
			<div class="board-item" id="29"></div>
			<div class="board-item" id="30"></div>

			<div class="board-item" id="20"></div>
			<div class="board-item" id="19"></div>
			<div class="board-item" id="18"></div>
			<div class="board-item" id="17"></div>
			<div class="board-item" id="16"></div>
			<div class="board-item" id="15"></div>
			<div class="board-item" id="14"></div>
			<div class="board-item" id="13"></div>
			<div class="board-item" id="12"></div>
			<div class="board-item" id="11"></div>

			<div class="board-item" id="1"></div>
			<div class="board-item" id="2"></div>
			<div class="board-item" id="3"></div>
			<div class="board-item" id="4"></div>
			<div class="board-item" id="5"></div>
			<div class="board-item" id="6"></div>
			<div class="board-item" id="7"></div>
			<div class="board-item" id="8"></div>
			<div class="board-item" id="9"></div>
			<div class="board-item" id="10"></div>

		</div>

		<!-- DICE GRID -->
		<div class="dice-grid">
			Dice

			<form action="game" method="post">
				<input type="submit" value="Roll dice" />
			</form>

			<p id="diceVal">${dice}</p>
		</div>

	</div>

	<!-- FOOTER -->
	<div class="footer"></div>

</body>
<script src="../../js/gameFunc.js"></script>
</html>