const tileSize = 20;
const rows = 100, cols = 100;
const canvas = document.getElementById("mapCanvas");
const ctx = canvas.getContext("2d");

// Define terrain colors
const terrainColors = {
    "grass": "#4CAF50",    // Green
    "water": "#1E90FF",    // Blue
    "mountain": "#8B4513"  // Brown
};

// Fetch map data from backend
async function fetchMap() {
    const response = await fetch("/api/map");
    const mapData = await response.json();
    drawMap(mapData);
}

// Draw the map
function drawMap(mapData) {
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            const terrain = mapData[row][col];
            ctx.fillStyle = terrainColors[terrain] || "#000"; // Default to black if unknown
            ctx.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
            ctx.strokeStyle = "#000";
            ctx.strokeRect(col * tileSize, row * tileSize, tileSize, tileSize);
        }
    }
}

fetchMap(); // Call API to load map dynamically
