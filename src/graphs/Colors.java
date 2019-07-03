package graphs;

public enum Colors {
	BLACK (0, 0, 0),
	RED (255, 0, 0), 
	GREEN (0, 255, 0), 
	BLUE (0, 0, 255), 
	PURPLE (153, 0, 153), 
	PINK (255, 51, 153), 
	YELLOW (255, 255, 51), 
	BROWN (153, 76, 0), 
	ORANGE (255, 128, 0);
	
	private int r; 
	private int g; 
	private int b;
	
	Colors(int r, int g, int b) { 
		this.r = r; 
		this.g = g; 
		this.b = b; 
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}
}
