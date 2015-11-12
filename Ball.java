public class Ball{

	/* This class is used to represent
	 * a combination of a letter (B, I, N, G, or O)
	 * and a number between 1 and 100
	 * 
	 * Used in randomly calling a letter and number
	 * every game "turn"
	 */
	
	private BingoLetter letter;
	private int number;

	public Ball(BingoLetter letter, int number){
		this.letter = letter;
		this.number = number;
	}
}