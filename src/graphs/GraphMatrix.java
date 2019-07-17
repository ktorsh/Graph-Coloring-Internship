package graphs;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class GraphMatrix implements Serializable{
	int numNodes; 
	ArrayList<VertexMatrix> nodes; 
	int numColors;
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
		VertexMatrix m = new VertexMatrix(nodes.size(), nodes.size());
		nodes.add(m);
		for (int i = 0; i < nodes.size(); i++) { 
			nodes.get(i).increaseNodeSize(1);
		}
	}
	public void addConnection(int first, int second) { 
		nodes.get(first).addConnection(second);
		nodes.get(second).addConnection(first);
	}
	public int[][] getAdjacencyMatrix(){ 
		int[][] matrix = new int[nodes.size()][nodes.size()]; 
		for (int i = 0; i < nodes.size(); i++) { 
			matrix[i] = nodes.get(i).getConnectionArray();
		}
		return matrix;
	}
	public Colors[] getAllNodeColors() { 
		Colors[] list = new Colors[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) { 
			list[i] = nodes.get(i).getColor();
		}
		return list; 
	}
	public void setNodeColor(int n, Colors c) { 
		nodes.get(n).setColor(c);
	}
	public Colors getNodeColor(int n) { 
		return nodes.get(n).getColor();
	}
	public int[] getVertexDegrees(){ 
		int[] deg = new int[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) { 
			deg[i]= nodes.get(i).getDegree();
		}
		return deg;
	}
	public int getVertexDegree(int n) { 
		return nodes.get(n).getDegree();
	}
	public int getVertexDegree(int n, ArrayList<Integer> connectedNodes) { 
		return nodes.get(n).getDegree(connectedNodes);
	}
	public int getVertexDegree(int n, int[] connectedNodes) { 
		return nodes.get(n).getDegree(connectedNodes);
	}
	public static void printMatrix(int[][] m) { 
		for (int i = 0; i < m.length; i++) { 
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	public int getNumColors() {
		return numColors;
	}
	public void setNumColors(int numColors) {
		this.numColors = numColors;
	}
	

}
