package algorithms;

import java.util.ArrayList;
import java.util.Stack;

import graphs.Colors;
import graphs.GraphMatrix;

public class SixColorLowDegree {
	GraphMatrix graph;
	int[][] adjMatrix; 
	public SixColorLowDegree(GraphMatrix g) { 
		graph = g; 
		adjMatrix = g.getAdjacencyMatrix();
	}
	public void color() { 
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> connectedNodes = new ArrayList<Integer>(adjMatrix.length); //which nodes are in play
		for (int i = 0; i < adjMatrix.length; i++) { 
			connectedNodes.add(i);
		}
		for (int j = 0; j < adjMatrix.length; j++) { //find node with least edges
			int minNode = connectedNodes.get(0); 
			for (int i = 1; i < connectedNodes.size(); i++) {
				if (graph.getVertexDegree(connectedNodes.get(i)) < graph.getVertexDegree(minNode)) { 
					minNode = connectedNodes.get(i);
				}
			}
			connectedNodes.remove(Integer.valueOf(minNode));
			stack.push(minNode);
		}
		while (!stack.empty()) { 
			int node = stack.pop();
			boolean hasColor = false;
			int currentColor = -1; 
			while (!hasColor) {
				currentColor++;
				hasColor = true;
				for (int i = 0; i < adjMatrix.length; i++) { //colors with the "least" available color
					if (adjMatrix[node][i] == 1 && currentColor == graph.getNodeColor(i).getN()) { 
						hasColor = false;				
					}
				}
			}
			graph.setNodeColor(node, Colors.values()[currentColor+1]);
		}
	}

}
