package graphs;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphViewer {
	public static void viewGraph(GraphMatrix g) { 
		Graph graph = new SingleGraph("Graph Color");
		int[][] matrix = g.getAdjancyMatrix();
		for (int i = 0; i < matrix.length; i++) { 
			graph.addNode(String.valueOf(i)).addAttribute("ui.style", "fill-color: ;");
		}
		graph.display();
		
	}

}
