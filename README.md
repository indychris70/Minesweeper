# Minesweeper

## Link
https://hyperskill.org/projects/77?track=1

## About
You played this game when the Internet cut off, didn’t you? It is time to remember the good old days. In this project, you will create your own "Minesweeper" game.

## Learning outcomes
This project will teach you how to work with multidimensional arrays in Java. You will be dealing with algorithms for generating the playfield and processing player moves. You will also find out what collections and stacks are.

## This project is a part of the following track
Java Developer

## Requirements

### Stage #1: Lay the groundwork
Link: https://hyperskill.org/projects/77/stages/426/implement

Print minefield of any size, with the spaces that contain mines distinguishable from spaces that do not contain mines by use of different characters.

### Stage #2: Flexible mines
Link: https://hyperskill.org/projects/77/stages/427/implement

- Generate a random configuration of mines each time the program runs.
- Get input from player for the number of mines to add to the field.

### Stage #3: Look around you
Link: https://hyperskill.org/projects/77/stages/428/implement

- Show the number of mines around empty cells when the field is printed.

### Stage #4: Prepare for battle
Link: https://hyperskill.org/projects/77/stages/429/implement

- When the board is printed it should include column numbers, row numbers, and a border around the field.
- After initializing the field, all the numbers are shown to the player, but not the positions of the mines.
- Player is prompted to enter coordinates to flag where they think mines are located.
  - This toggles the flag (set flag if not already flagged, unflag if flagged).
  - Player cannot flag a coordinate that shows a number, since those are guaranteed to not have a mine.
- Updated field is printed when the player successfully flag/unflags a coordinate.
- Repeat these steps until the game is finished.
  - The game is finished when the player marks all mines correctly without marking empty cells.
  