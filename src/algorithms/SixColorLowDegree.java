package algorithms;

import graphs.Colors;
import graphs.GraphMatrix;

public class SixColorLowDegree {
	GraphMatrix graph;
	public SixColorLowDegree(GraphMatrix g) { 
		graph = g; 
	}
	public void color() { 
		int[] degs = graph.getVertexDegrees(); 
		int[][] matrix = graph.getAdjacencyMatrix();
		int[] orderDegs = new int[degs.length]; //order of indicies from degree
		Colors[] colors = new Colors[degs.length];
		int minIndex = 0; 
		for (int i = 0; i < degs.length; i++) { 
			if (degs[i] < degs[minIndex] && degs[i] != -1) { 
				minIndex = i;
			}
		}
		degs[minIndex] = -1; 
		
	}

}
