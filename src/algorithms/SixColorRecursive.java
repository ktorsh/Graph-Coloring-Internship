package algorithms;

import graphs.Colors;
import graphs.GraphMatrix;

public class SixColorRecursive implements ColoringAlgo{
	GraphMatrix graph;
	int[][] adjMatrix;
	public SixColorRecursive(GraphMatrix g) { 
		graph = g; 
		adjMatrix = g.getAdjacencyMatrix();
	}
	public void color() { 
		int[] conNodes = new int[adjMatrix.length]; 
		for (int i = 0; i < adjMatrix.length; i++) { 
			conNodes[i] = i;
		}
		color(conNodes);
	}
	private void color(int[] connectedNodes) { 
		if (connectedNodes.length == 1) { 
			graph.setNodeColor(connectedNodes[0], Colors.RED);
			return; 
		}
		int minNode = connectedNodes[0]; 
		for (int i = 1; i < connectedNodes.length; i++) {
			if (graph.getVertexDegree(connectedNodes[i], connectedNodes) < graph.getVertexDegree(minNode, connectedNodes)) { 
				minNode = connectedNodes[i];
			}
		}
		int[] newCon = new int[connectedNodes.length - 1];
		int counter = 0;
		for (int j = 0; j < connectedNodes.length; j++) {
			System.out.print(connectedNodes[j]+" ");
		}
		System.out.println();
		System.out.println(minNode);
		for (int i = 0; i < connectedNodes.length; i++) { 
			if (connectedNodes[i] != minNode) { 
				newCon[counter] = connectedNodes[i]; 
				counter++;
			}
		}
		color(newCon); 
		boolean hasColor = false;
		int currentColor = -1; 
		while (!hasColor) {
			currentColor++;
			hasColor = true;
			for (int i = 0; i < adjMatrix.length; i++) { 
				if (adjMatrix[minNode][i] == 1 && currentColor == graph.getNodeColor(i).getN()) { 
					hasColor = false;				
					if (currentColor  > graph.getNumColors()) { 
						graph.setNumColors(currentColor + 2);
					}
				}
			}
		}
		graph.setNodeColor(minNode, Colors.values()[currentColor+1]);
	}

}
