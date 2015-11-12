public class Tile{
	private String text;
	private boolean filled;

	public Tile(String text){
		this.text = text;
		filled = false;
	}

	public void fill(){
		filled = true;
	}

	public String getText(){
		return text;
	}

	public boolean isFilled(){
		return filled;
	}
}