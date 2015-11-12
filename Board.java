import java.util.Random;
import java.util.ArrayList;

public class Board{
	
	/* Contains all tiles the player can mark.
	 * Allows reading tiles by index as well as
	 * marking tiles by index.
	 * 
	 * Once tiles have been generated,
	 * their text values cannot be changed
	 */
	
	private Random rand;
	private Tile[][] tiles;	// the x axis of this array represents the different letters
							// in BINGO.
							// the y axis is the distance from the top of the board.
	
	private ArrayList<Integer> filledRows; // stores the y axis value of each filled row
	private ArrayList<Integer> filledColumns; // stores the x axis value of each filled column
	private boolean[] filledDiagonals;	// element 0 is the / diagonal "row"
										// element 1 is the \ diagonal "row"

	public Board(Random rand){
		this.rand = rand;
		filledRows = new ArrayList<>();
		filledColumns = new ArrayList<>();
		filledDiagonals = new boolean[] {false, false};
		initTiles();
	}

	public Tile getTileAt(int x, int y){
		return tiles[x][y];
	}

	public void fillTileAt(int x, int y){
		tiles[x][y].fill();
	}

	private void initTiles(){
		ArrayList<Integer> usedValues = new ArrayList<>();
		int number = 0;

		this.tiles = new Tile[5][5];
		for(int y = 0; y < 5; y++){
			for(int x = 0; x < 5; x++){
				while(usedValues.contains(number)){
					number = rand.nextInt(100) + 1;
				}
				usedValues.add(number);
				tiles[x][y] = new Tile(Integer.toString(number));
			}
		}
	}

	public boolean hasNewBingo(){
		// the single OR operator is used because
		// filledRows, filledColumns, and filledDiagonals
		// all need to be updated
		return checkRows() | checkColumns() | checkDiagonals();
	}

	private boolean checkRows(){
		for(int y = 0; y < 5; y++){
			if (!filledRows.contains(y)){
				for(int x = 0; x < 5; x++){
					if (tiles[x][y].isFilled()){
						if(x == 4){
							filledRows.add(y);
							return true;
						}
					}
					else{
						break;
					}
				}
			}
		}
		return false;
	}

	private boolean checkColumns(){
		for(int x = 0; x < 5; x++){
			if (!filledColumns.contains(x)){
				for(int y = 0; y < 5; y++){
					if (tiles[x][y].isFilled()){
						if (y == 4){
							filledColumns.add(x);
							return true;
						}
					}
					else{
						break;
					}
				}
			}
		}
		return false;
	}

	private boolean checkDiagonals(){
		boolean hasNew = false;
		if(!filledDiagonals[0]){
			for(int i = 0; i < 5; i++){
				if(tiles[i][i].isFilled()){
					if(i == 4){
						filledDiagonals[0] = true;
						hasNew = true;
					}
				}
				else{
					break;
				}
			}
		}
		if(!filledDiagonals[1]){
			for(int i = 0; i < 5; i++){
				if(tiles[i][4 - i].isFilled()){
					if(i == 4){
						filledDiagonals[1] = true;
						hasNew = true;
					}
				}
				else{
					break;
				}
			}
		}
		return hasNew;
	}
}