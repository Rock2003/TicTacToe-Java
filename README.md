# 2-Tic Tac Toe with Minimax in Java

Tic Tac Toe

Project Details:


This project is a Tic Tac Toe game that will implement a Minimax algorithm in Java This project is divided in 3 parts: The Minimax algorithm, result interpretation, and result output.


Common information:


To facilitate the work between the different parts of this project, I used a String array to reference the players’ position. Make sure to call out a String array of length 9 in your program named “moves”. The array starts with empty positions (all spaces). The player 1 can cast an “X”, while player 2 will be casting an “O” on the array. Tic Tac Toe positions will be called with the following Tic Tac Toe board with the array indexes:

0	1	2

3	4	5

6	7	8


Team A:


You will be working on the Minimax algorithm. Your goal is to make a method/function that calculates the best move to take by using the String array “moves” and/or the win(String player, String[] positionMoves) from Team B. After calculating the best move, you will call the move(String player, int position) with the player set as “O” and the position as the best move your calculated.


Help resources:[The Coding Train](https://www.youtube.com/watch?v=trKjYdBASyQ&t)


Team B:


You will be working on the Result Interpretation part. Your goal is to write a win(String player, String[] positionMoves) boolean method that returns if the game has been won by the player (knowing that the player can either be “X” or “O”) on the positionMoves plate (it could be the “move” array or a replica). You will also need to create a move(String player, int position) which will place the player on the “move” array at the parameters’ index.


Team C:


You will be working on the Result Output part. Your goal is to create a print() method that uses the indexes positions to print a board with the current positions. You will also on the main method which prompt the user to start a game, choose the user’s position and launch the minimax algorithm until the game is won by one of the players.
