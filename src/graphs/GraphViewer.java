package graphs;
import java.util.Map;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class GraphViewer {
	public static void viewGraph(GraphMatrix g) { 
		Graph graph = new SingleGraph("Graph Color");
		int[][] matrix = g.getAdjacencyMatrix();
		Colors[] c = g.getAllNodeColors();
		for (int i = 0; i < matrix.length; i++) { 
			Node n = graph.addNode(String.valueOf(i));
			n.addAttribute("ui.style", "fill-color:rgb("+c[i].getR()+","+c[i].getG()+","+c[i].getB()+");");
			n.addAttribute("ui.label", String.valueOf(i));
		}
		for (int i = 0; i < matrix.length; i++) { 
			for (int j = i; j < matrix.length; j++) { 
				if (matrix[i][j] == 1) {
					graph.addEdge(String.valueOf(i) + String.valueOf(j), String.valueOf(i), String.valueOf(j));
				}
			}
		}
		graph.display();
	}

}
