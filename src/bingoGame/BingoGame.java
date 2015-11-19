package bingoGame;

import java.util.Scanner;

import java.util.Random;
import java.util.ArrayList;
import bingoGui.BingoGui;

public class BingoGame{
	/* CODE EXPLANATION:
	 * 
	 * This class simply creates the objects
	 * needed to test the basic functionality
	 * of the bingo board and tiles,
	 * and runs a simple mock game loop.
	 * 
	 * The Board class is the most important
	 * component to this design as it contains
	 * all the tiles the player can mark,
	 * provides methods to read from and write to
	 * each tile, and has a method to check if
	 * any new row or column has been filled.
	 */
	

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		ArrayList<Ball> uncalledBalls = new ArrayList<Ball>();	// 75 random Ball instances should
																// be taken from this ArrayList as
																// the game goes on, each one will
																// contain the letter and number to
																// call out every game "turn".
		
		/*
		// fill uncalledBalls with balls of every
		// combination of letters and numbers
		// (B 1 to B 100, I 1 to I 100, etc)
		// NOTE: this ArrayList is not actually used right now
		for(BingoLetter letter : BingoLetter.values()){
			for(int i = 1; i <= 100; i++){
				uncalledBalls.add(new Ball(letter, i));
			}
		}

		// test rendering and game loop.
		// simple text parsing is used to
		// mark individual tiles by index
		String choice = "";
		while(!choice.equals("exit")){
			Tile tempTile;
			
			// render tiles by printing
			for(int y = 0; y < 5; y++){
				for(int x = 0; x < 5; x++){
					tempTile = board.getTileAt(x, y);
					System.out.printf("%3s:%1s ",
							tempTile.getText(), 
							tempTile.isFilled() ? "T" : "F");
					if (x == 4){
						System.out.println();
					}
				}
			}
			
			// marks a tile or exits the program
			choice = input.nextLine();
			String[] choiceSplit = choice.split(" ");
			if (choiceSplit[0].equals("fill")){
				board.fillTileAt(Integer.parseInt(choiceSplit[1]), Integer.parseInt(choiceSplit[2]));
				if(board.hasNewBingo()){	// checks for any new bingos (also updates filledColumns, filledRows, and filledDiagonals)
					System.out.println("NEW BINGO!!");
				}
				else{
					System.out.println("No new Bingos...");
				}
			}
		}
		input.close();
		*/
	}
}