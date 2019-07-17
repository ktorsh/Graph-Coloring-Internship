package algorithms;

import graphs.Colors;
import graphs.GraphMatrix;

public class GoThroughAlgo implements ColoringAlgo{
	GraphMatrix graph;
	int[][] adjMatrix; 
	public GoThroughAlgo(GraphMatrix g) { 
		graph = g; 
		adjMatrix = g.getAdjacencyMatrix();
	}
	public void color() { 
		graph.setNodeColor(0, Colors.values()[0]);
		for (int node = 1; node < adjMatrix.length; node++) {
			boolean hasColor = false;
			int currentColor = -1; 
			while (!hasColor) {
				currentColor++;
				hasColor = true;
				for (int i = 0; i < adjMatrix.length; i++) { //colors with the "least" available color
					if (adjMatrix[node][i] == 1 && currentColor == graph.getNodeColor(i).getN()) { 
						hasColor = false;	
						if (currentColor + 1 > graph.getNumColors()) { 
							graph.setNumColors(currentColor + 2);
						}
					}
				}
			}
			graph.setNodeColor(node, Colors.values()[currentColor+1]);
		}
	}
}
