const startGameButton = document.getElementById('start-game');
const joinGameButton = document.getElementById('join-game');
const joinGameInput = document.getElementById('join-game-input');

startGameButton.addEventListener('click', () => {
    fetch('/startGame', { method: 'POST' })
        .then(response => response.json())
        .then(data => {
            console.log("Game started:", data);
            // Example: window.location.href = "/game/" + data.gameId;
        });
});

joinGameButton.addEventListener('click', () => {
    const gameCode = joinGameInput.value;
    if (gameCode) {
        fetch('/joinGame', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ gameCode: gameCode })
        })
        .then(response => response.json())
        .then(data => {
            console.log("Joined game:", data);
            // Example: window.location.href = "/game/" + gameId;
        });
    } else {
        alert("Please enter a Game ID.");
    }
});