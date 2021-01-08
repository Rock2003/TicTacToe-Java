<<<<<<< HEAD
// Tic Tac Toe console game that implements a Minimax Algorithm
// Part of the BC Tech Club 2nd project to see here: https://github.com/BC-Tech-Club
// Console only-No GUI implemented yet

import java.util.Scanner;

public class TicTacToe {
	
	// Tic Tac Toe board state: "X" for player 1 and "O" for player 2
	static String[] moves = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	static boolean game = true;
	
	// Launches the game
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Enter 0 to play against a player");
			System.out.println("Or, enter 1 to play against a bot");
			System.out.print("Enter any other key to quit.");
			int input = -1;
			try {
				input = scan.nextInt();
			} catch(Exception e) {};
			if(input == 0) {
				String player = "X";
				game = true;
				while(game) {
					if(player == "X") {
						while(true) {
							print();
							System.out.print("Player 1: choose postion: ");
							int position = scan.nextInt();
							System.out.println();
							int decision = move("X", position);
							if(decision == -1) {
								System.out.println("Error: Position taken");
							} else if(decision == 0) {
								System.out.println("Error: Position out of index. Select between 0 and 8");
							} else {
								break;
							}
						}
						player = "O";
					} else {
						while(true) {
							print();
							System.out.print("Player 2: choose postion: ");
							int position = scan.nextInt();
							System.out.println();
							int decision = move("O", position);
							if(decision == -1) {
								System.out.println("Error: Position taken");
							} else if(decision == 0) {
								System.out.println("Error: Position out of index. Select between 0 and 8");
							} else {
								break;
							}
						}
						player = "X";
					}
				}
			} else if (input == 1) {
				String player = "X";
				game = true;
				while(game) {
					if(player == "X") {
						while(true) {
							print();
							System.out.print("Player 1: choose postion: ");
							int position = scan.nextInt();
							System.out.println();
							int decision = move("X", position);
							if(decision == -1) {
								System.out.println("Error: Position taken");
							} else if(decision == 0) {
								System.out.println("Error: Position out of index. Select between 0 and 8");
							} else {
								break;
							}
						}
						player = "O";
					} else {
						minimax();
						player = "X";
					}
				}	
			} else {
				break;
			}
			moves = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
		}
		System.out.println("\nThank you for playing this game!");
	}

	// copies a String array
	public static String[] helper(String[] copy) {
		String[] copyCat = new String[9];
		for(int i = 0 ; i < 9; i++) {
			copyCat[i] = copy[i];
		}
		return copyCat;
	}
	
	// The minimax algorithm starts here, where it launches multiple recursions
	// to find the best moves to make in the game.
	public static void minimax() {
		boolean first = true;
		int bestMove = -999;
		int bestMoveScore = -999999;
		for(int i = 0; i < 8; i++) {
			if(moves[i].equals(" ")) {
				String[] movesCopy = helper(moves);
				movesCopy[i] = "O";
				int currentScore = recursion(movesCopy, "O");
				if(first) {
					bestMove = i;
					bestMoveScore = currentScore;
					first = false;
				} else {
					if(currentScore > bestMoveScore) {
						bestMove = i;
						bestMoveScore = currentScore;
					}
				}
			}
		}
		move("O", bestMove);
	}
	// helps continuing the recursion for the Minimax algorithm.
	public static int recursion(String[] movesCopy, String player) {
		if(win(player, movesCopy)) {
			if(player == "O") {
				return 1;
			}
			return -1;
		}
		String newPlayer;
		if(player == "O") {
			newPlayer = "X";
		} else {
			newPlayer = "O";
		}
		int score = 0;
		for(int i = 0; i < movesCopy.length; i++) {
			if(movesCopy[i].equals(" ")) {
				String[] newMovesCopy = helper(movesCopy);
				newMovesCopy[i] = newPlayer;
				score += recursion(newMovesCopy, newPlayer);
			}
		}
		return score;
	}
	
	// Moves player to the position stated
	public static int move(String player, int position) {
		if(!moves[position].equals(" ")) {
			return -1;
		}
		if(position < 0 || position > 8) {
			return 0;
		}
		moves[position] = player;
		if(win(player, moves)) {
			System.out.println(player + " won");
			print();
			game = false;
			return 3;
		}
		boolean test = true;
		for(int i =0 ; i< 9; i++) {
			if(moves[i] == " ") {
				return 1;
			}
		}
		if(test) {
			System.out.println("Tie!");
			print();
			game = false;
			return 2;
		}
		return -9;
	}
	
	// Checks if the game has been won by the player in the parameters.
	public static boolean win(String player, String[] gameMoves) {
		if(gameMoves[0] == player && gameMoves[1] == player && gameMoves[2] == player) {
			return true;
		} else if(gameMoves[3] == player && gameMoves[4] == player && gameMoves[5] == player) {
			return true;
		} else if(gameMoves[6] == player && gameMoves[7] == player && gameMoves[8] == player) {
			return true;
		} else if( gameMoves[0] == player && gameMoves[3] == player && gameMoves[6] == player) {
			return true;
		} else if( gameMoves[1] == player && gameMoves[4] == player && gameMoves[7] == player) {
			return true;
		} else if( gameMoves[2] == player && gameMoves[5] == player && gameMoves[8] == player) {
			return true;
		} else if( gameMoves[0] == player && gameMoves[4] == player && gameMoves[8] == player) {
			return true;
		} else if( gameMoves[2] == player && gameMoves[4] == player && gameMoves[6] == player) {
			return true;
		} else {
			return false;
		}		
	}
	
	// prints the current state of the board
	public static void print() {
		System.out.println(moves[0] + " | " + moves[1] + " | " + moves[2]);
		System.out.println("---------");
		System.out.println(moves[3] + " | " + moves[4] + " | " + moves[5]);
		System.out.println("---------");
		System.out.println(moves[6] + " | " + moves[7] + " | " + moves[8]);
		System.out.println();
	}
}
=======
// Tic Tac Toe console game that implements a Minimax Algorithm
// Part of the BC Tech Club 2nd project to see here: https://github.com/BC-Tech-Club
// Console only-No GUI implemented yet

import java.util.Scanner;

public class TicTacToe {
	
	// Tic Tac Toe board state: "X" for player 1 and "O" for player 2
	static String[] moves = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	static boolean game = true;
	
	// Launches the game
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String player = "player 1";
		while(game) {
			if(player == "player 1") {
				print();
				System.out.print("choose postion: ");
				int position = scan.nextInt();
				System.out.println();
				move("X", position, moves);
				player = "player 2";
			} else {
				minimax();
				player = "player 1";
			}
		}
	}

	// copies a String array
	public static String[] helper(String[] copy) {
		String[] copyCat = new String[9];
		for(int i = 0 ; i < 9; i++) {
			copyCat[i] = copy[i];
		}
		return copyCat;
	}
	
	// The minimax algorithm starts here, where it launches multiple recursions
	// to find the best moves to make in the game.
	public static void minimax() {
		boolean first = true;
		int bestMove = -999;
		int bestMoveScore = -999999;
		for(int i = 0; i < 8; i++) {
			if(moves[i].equals(" ")) {
				String[] movesCopy = helper(moves);
				movesCopy[i] = "O";
				int currentScore = recursion(movesCopy, "O");
				if(first) {
					bestMove = i;
					bestMoveScore = currentScore;
					first = false;
				} else {
					if(currentScore > bestMoveScore) {
						bestMove = i;
						bestMoveScore = currentScore;
					}
				}
			}
		}
		move("O", bestMove, moves);
	}
	// helps continuing the recursion for the Minimax algorithm.
	public static int recursion(String[] movesCopy, String player) {
		if(win(player, movesCopy)) {
			if(player == "O") {
				return 1;
			}
			return -1;
		}
		String newPlayer;
		if(player == "O") {
			newPlayer = "X";
		} else {
			newPlayer = "O";
		}
		int score = 0;
		for(int i = 0; i < movesCopy.length; i++) {
			if(movesCopy[i].equals(" ")) {
				String[] newMovesCopy = helper(movesCopy);
				newMovesCopy[i] = newPlayer;
				score += recursion(newMovesCopy, newPlayer);
			}
		}
		return score;
	}
	
	// Moves player to the position stated
	public static void move(String player, int position, String[] moves) {
		moves[position] = player;
		if(win(player, moves)) {
			System.out.println(player + " won");
			game = false;
			return;
		}
		boolean test = true;
		for(int i =0 ; i< 9; i++) {
			if(moves[i] == " ") {
				return;
			}
		}
		if(test) {
			System.out.println("Tie!");
			game = false;
		}
	}
	
	// Checks if the game has been won by the player in the parameters.
	public static boolean win(String player, String[] gameMoves) {
		if(gameMoves[0] == player && gameMoves[1] == player && gameMoves[2] == player) {
			return true;
		} else if(gameMoves[3] == player && gameMoves[4] == player && gameMoves[5] == player) {
			return true;
		} else if(gameMoves[6] == player && gameMoves[7] == player && gameMoves[8] == player) {
			return true;
		} else if( gameMoves[0] == player && gameMoves[3] == player && gameMoves[6] == player) {
			return true;
		} else if( gameMoves[1] == player && gameMoves[4] == player && gameMoves[7] == player) {
			return true;
		} else if( gameMoves[2] == player && gameMoves[5] == player && gameMoves[8] == player) {
			return true;
		} else if( gameMoves[0] == player && gameMoves[4] == player && gameMoves[8] == player) {
			return true;
		} else if( gameMoves[2] == player && gameMoves[4] == player && gameMoves[6] == player) {
			return true;
		} else {
			return false;
		}		
	}
	
	// prints the current state of the board
	public static void print() {
		System.out.println(moves[0] + " | " + moves[1] + " | " + moves[2]);
		System.out.println("---------");
		System.out.println(moves[3] + " | " + moves[4] + " | " + moves[5]);
		System.out.println("---------");
		System.out.println(moves[6] + " | " + moves[7] + " | " + moves[8]);
		System.out.println();
	}
}
>>>>>>> 31a6c549f33f2c3aee37bd00c6bf4895098dcc8e
