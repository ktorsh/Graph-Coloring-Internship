package graphs;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphViewer {
	Graph graph;
	public GraphViewer(GraphMatrix g) { 
		graph = new SingleGraph("Graph Color");
	}

}
