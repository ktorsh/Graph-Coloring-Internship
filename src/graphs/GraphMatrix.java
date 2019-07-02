package graphs;

import java.awt.Color;
import java.util.ArrayList;

public class GraphMatrix {
	int numNodes; 
	ArrayList<VertexMatrix> nodes; 
	public GraphMatrix() { 
		numNodes = 0; 
		nodes = new ArrayList<VertexMatrix>();
	}
	public GraphMatrix(int[][] adjMatrix) {
		for (int i = 0; i < adjMatrix.length; i++) { 
			addNode();
		}
		for (int i = 0; i < adjMatrix.length; i++) { 
			for (int j = 0; j < adjMatrix.length; j++) { 
				if (adjMatrix[i][j] == 1) { 
					addConnection(i, j);
				}
			}
		}	
	}
	public void addNode() { 
		VertexMatrix m = new VertexMatrix(nodes.size());
		nodes.add(m);
	}
	public void addConnection(int first, int second) { 
		nodes.get(first).addConnection(second);
		nodes.get(second).addConnection(first);
	}
	public int[][] getAdjancyMatrix(){ 
		int[][] matrix = new int[nodes.size()][nodes.size()]; 
		for (int i = 0; i < nodes.size(); i++) { 
			matrix[i] = nodes.get(i).getConnectionArray();
		}
		return matrix;
	}
	public Color[] getNodeColors() { 
		Color[] list = new Color[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) { 
			list[i] = nodes.get(i).getColor();
		}
		return list; 
	}

}
