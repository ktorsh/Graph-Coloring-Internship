package graphs;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class Test {

	public static void main(String[] args) {
		Graph graph = new SingleGraph("Tutorial 1");
		graph.addNode("0");
		graph.addNode("1");
		graph.addNode("2");
		graph.addEdge("AC", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		graph.display();

	}

}
