document.getElementById('start-game').addEventListener('click', () => {
    fetch('/startGame', { method: 'POST' })
        .then(response => response.json())
        .then(data => {
            console.log("Game started:", data);
            displayGameCode(data.gameCode);
            renderBattleMap(data.map);
        })
        .catch(error => console.error('Error starting game:', error));
});

document.getElementById("register-player").addEventListener("click", function() {
    window.open("/register.html", "Register Player", "width=500,height=500");
});

function displayGameCode(gameCode) {
    let gameInfo = document.getElementById('gameInfo');
    gameInfo.innerHTML = `<h2>Game Code: ${gameCode}</h2>`;
}

function renderBattleMap(map) {
    const tileSize = 20; // Tile size in pixels
    const canvas = document.createElement('canvas');
    canvas.width = map[0].length * tileSize;
    canvas.height = map.length * tileSize;

    document.body.innerHTML = ''; // Clear previous content
    document.body.appendChild(canvas);

    const ctx = canvas.getContext('2d');

    const images = {
        plain: "assets/grass.png",
        hill: "assets/hill.png",
        mountain: "assets/mountain.png",
        river: "assets/river.png"
    };

    function drawTile(imageSrc, x, y) {
        const img = new Image();
        img.src = imageSrc;
        img.onload = () => ctx.drawImage(img, x * tileSize, y * tileSize, tileSize, tileSize);
    }

    for (let y = 0; y < map.length; y++) {
        for (let x = 0; x < map[0].length; x++) {
            const tile = map[y][x];
            drawTile(images[tile.type], x, y);
        }
    }
}
