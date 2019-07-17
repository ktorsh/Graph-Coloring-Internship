package ui;

import java.io.File;

import algorithms.SixColorRecursive;
import graphs.GraphMatrix;
import graphs.GraphViewer;

public class Test {
	public static void main(String[] args) { 
//		GraphMatrix g = new GraphMatrix();
//		for (int i = 0; i < 51; i++) { 
//			g.addNode(); 
//		}
//		for (int i = 0; i < 51; i++) { 
//			g.addConnection(i, (i+1)%51);
//		}
//		for (int i = 0; i < 51; i++) { 
//			g.addConnection(i, (i+2)%51);
//		}
//		for (int i = 1; i < 51; i = i + 2) { 
//			g.addConnection(0, i);
//		}
//		SixColorRecursive s = new SixColorRecursive(g); 
//		s.color();
//		File f = new File("test.txt");
//		GraphSerializer.writeGraph(g, f);
		GraphMatrix g = GraphSerializer.readGraph(new File("test.txt"));
		GraphViewer.viewGraph(g);

	}

}
