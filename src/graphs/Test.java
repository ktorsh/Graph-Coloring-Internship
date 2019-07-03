package graphs;
import java.awt.Color;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class Test {

	public static void main(String[] args) {
//		Graph graph = new SingleGraph("Tutorial 1");
//		graph.addNode("0").addAttribute("ui.fill-color", Color.RED);
//		graph.addNode("1");
//		graph.addNode("2");
//		graph.addEdge("01", "0", "1");
////		graph.addEdge("BA", "B", "A");
////		graph.addEdge("BC", "B", "C");
////		graph.addEdge("CA", "C", "A");
//		graph.display();
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
		GraphMatrix.printMatrix(g.getAdjacencyMatrix());
		GraphViewer.viewGraph(g);

	}

}
