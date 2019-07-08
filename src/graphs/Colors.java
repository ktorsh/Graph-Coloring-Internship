package graphs;

public enum Colors {
	BLACK (-1, 0, 0, 0),
	RED (0, 255, 0, 0), 
	GREEN (1, 0, 255, 0), 
	BLUE (2, 0, 0, 255), 
	PURPLE (3, 153, 0, 153), 
	PINK (4, 255, 51, 153), 
	YELLOW (5, 255, 255, 51), 
	BROWN (6, 153, 76, 0), 
	ORANGE (7, 255, 128, 0);
	
	private int n; 
	private int r; 
	private int g; 
	private int b;
	
	
	Colors(int n,int r, int g, int b) { 
		this.n = n;
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
	public int getN() { 
		return n;
	}
	public static Colors getNColor(int n) { 
		return Colors.values()[n];
	}


}
