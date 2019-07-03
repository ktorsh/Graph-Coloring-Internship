package graphs;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphViewer {
	public static void viewGraph(GraphMatrix g) { 
		Graph graph = new SingleGraph("Graph Color");
		int[][] matrix = g.getAdjancyMatrix();
		Colors[] c = g.getNodeColors();
		for (int i = 0; i < matrix.length; i++) { 
			graph.addNode(String.valueOf(i)).addAttribute("ui.style", "fill-color:rgb("+c[i].getR()+","+c[i].getG()+","+c[i].getB()+");");
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
