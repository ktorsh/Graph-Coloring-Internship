package algorithms;

import graphs.GraphMatrix;
import graphs.GraphViewer;

public class Test {

	public static void main(String[] args) {
		GraphMatrix g = new GraphMatrix();
//		g.addNode();
//		g.addNode();
//		g.addNode();
//		g.addNode();
//		g.addNode();
//		g.addNode();
//		g.addNode();
//		g.addNode();
//		g.addNode();
//		g.addConnection(0, 1);
//		g.addConnection(0, 2);
//		g.addConnection(0, 3);
//		g.addConnection(0, 4);
//		g.addConnection(0, 5);
//		g.addConnection(1, 6);
//		g.addConnection(6, 7);
//		g.addConnection(7, 3);
//		g.addConnection(2, 8);
//		g.addConnection(8, 7);
//		g.addConnection(8, 6);
		for (int i = 0; i < 51; i++) { 
			g.addNode(); 
		}
		for (int i = 0; i < 51; i++) { 
			g.addConnection(i, (i+1)%51);
		}
		for (int i = 0; i < 51; i++) { 
			g.addConnection(i, (i+2)%51);
		}
		for (int i = 1; i < 51; i = i + 2) { 
			g.addConnection(0, i);
		}
		SixColorRecursive s = new SixColorRecursive(g); 
		s.color();
		GraphViewer.viewGraph(g);

	}

}
