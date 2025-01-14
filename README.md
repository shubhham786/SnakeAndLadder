# Snake and Ladder Game

A Java implementation of the classic Snake and Ladder board game. This project provides a clean, object-oriented design for a customizable game where players can roll dice and navigate through a board filled with snakes and ladders.

## Features

- Customizable board size (default 10x10)
- Configurable number of snakes and ladders
- Support for multiple players
- Customizable dice (number of dice and face values)
- Random placement of snakes and ladders
- Turn-based gameplay with special rules for consecutive sixes

## Project Structure

The project consists of the following core classes:

- `Board.java`: Manages the game board and initializes snakes and ladders
- `Cell.java`: Represents individual squares on the board
- `Jump.java`: Handles snake and ladder logic
- `Dice.java`: Manages dice rolling mechanics
- `Player.java`: Maintains player state and position
- `Game.java`: Orchestrates the game flow
- `Client.java`: Entry point of the application

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
```

2. Navigate to the project directory:
```bash
cd snake-and-ladder
```

3. Compile the Java files:
```bash
javac *.java
```

4. Run the game:
```bash
java Client
```

## Game Rules

1. The game is played on a square board of customizable dimensions (default 10x10).
2. Players start from position 0 (outside the board).
3. Players take turns rolling a dice to move forward.
4. If a player lands on a cell with a snake's head, they move down to the snake's tail.
5. If a player lands on a cell with a ladder's bottom, they climb up to the ladder's top.
6. If a player rolls a 6, they get another turn (up to 3 consecutive turns).
7. The first player to reach the final cell (position 99 in a 10x10 board) wins.

## Configuration

You can customize various game parameters by modifying the Game constructor:

```java
// Create a custom game
int dimension = 10;            // Board size
int numberOfSnakes = 10;       // Number of snakes
int numberOfLadders = 6;       // Number of ladders
int diceCount = 1;            // Number of dice

Game game = new Game(dimension, numberOfSnakes, numberOfLadders, diceCount);
```

## Class Diagram

```
┌──────────┐     ┌──────────┐     ┌──────────┐
│  Client  │─────│   Game   │─────│  Board   │
└──────────┘     └──────────┘     └──────────┘
                      │ │               │
                      │ │           ┌──────────┐
                      │ │           │   Cell   │
                      │ │           └──────────┘
                      │ │               │
                ┌─────┘ └─────┐    ┌──────────┐
                │             │    │   Jump   │
           ┌──────────┐  ┌──────────┐└──────────┘
           │  Player  │  │   Dice   │
           └──────────┘  └──────────┘
```

## Future Improvements

1. Add input validation for game parameters
2. Implement game state persistence
3. Add support for custom snake and ladder positions
4. Include game statistics tracking
5. Add undo/redo functionality
6. Implement a graphical user interface
7. Add network multiplayer support

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



## Authors

- Shubham- *Initial work*

## Acknowledgments

- Inspired by the classic Snake and Ladder board game
- Thanks to all contributors who have helped with the project
