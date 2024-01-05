const playersTo = [];
const playersFrom = [];

let players = document.getElementById("numPlayers").innerHTML;
const playersNum = parseInt(players);

for(let i = 1; i <= playersNum; i++) {
	const playerFrom = document.getElementById("player" + i + "from").innerHTML;
	playersFrom.push(playerFrom);
	
	const playerTo = document.getElementById("player" + i + "to").innerHTML;
	playersTo.push(playerTo);
	
}

function highlightPlayer() {
	// set alle til hvit
	const playerTurn = document.getElementById("playersTurn").innerHTML;
	const playerToChange = document.getElementById("player" + playerTurn + "label");	
	playerToChange.style.color = "red";
	
}

highlightPlayer();

function movePlayer() {
	console.log("Move runs");
	
	for(let i = 1; i <= playersNum; i++) {
		
		const playerFrom = document.getElementById("player" + i + "from");
		const playerTo = document.getElementById("player" + i + "to");
				
		const fromPlacement = document.getElementById(playerFrom.innerHTML);
		const toPlacement = document.getElementById(playerTo.innerHTML);
		
		toPlacement.innerHTML = "P" + i;
		
	}
	
}

movePlayer();



