package algorithms;

import graphs.GraphMatrix;
import graphs.GraphViewer;

public class Test {

	public static void main(String[] args) {
		GraphMatrix g = new GraphMatrix();
		g.addNode();
		g.addNode();
		g.addNode();
		g.addNode();
		g.addConnection(0, 1);
		g.addConnection(0, 2);
		g.addConnection(1, 2);
		g.addConnection(1, 3);
		g.addConnection(2, 3);
		SixColorRecursive s = new SixColorRecursive(g); 
		s.color();
		GraphViewer.viewGraph(g);

	}

}
