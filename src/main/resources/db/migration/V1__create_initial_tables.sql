CREATE TABLE GAMESTATE (
    id SERIAL PRIMARY KEY,                     -- Unique game state identifier
    gameId INT NOT NULL,                       -- Unique game identifier for each match
    currentTurn INT NOT NULL,                  -- Current turn number
    player1Id INT,                             -- Foreign key to player 1 (could be NULL if AI)
    player2Id INT,                             -- Foreign key to player 2 (could be NULL if AI)
    aiPlayer BOOLEAN DEFAULT FALSE,            -- Flag to indicate if AI is playing
    gameStatus VARCHAR(20) DEFAULT 'ACTIVE',   -- Game status: ACTIVE, FINISHED, etc.
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    endDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE PLAYER (
    id SERIAL PRIMARY KEY,                     -- Unique player identifier
    userName VARCHAR(100) NOT NULL,            -- Player's username
    email VARCHAR(255),                        -- Player's email (optional)
    avatar VARCHAR(255),                       -- Link to player's avatar (optional)
    totalWins INT DEFAULT 0,                   -- Total wins across games
    totalLosses INT DEFAULT 0,                -- Total losses across games
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE GAMEMOVES (
    id SERIAL PRIMARY KEY,                     -- Unique move identifier
    gameId INT NOT NULL,                       -- Foreign key to `GAMESTATE`
    playerId INT NOT NULL,                     -- Foreign key to `PLAYERS`
    moveDescription TEXT NOT NULL,             -- Description of the move (coordinates, action)
    moveType VARCHAR(50),                      -- Type of move (e.g., "attack", "defend", etc.)
    moveResult VARCHAR(100),                   -- Outcome of the move (e.g., "hit", "miss", etc.)
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);