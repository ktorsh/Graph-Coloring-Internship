package graphs;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class GraphMatrix implements Serializable{
	int numNodes; 
	ArrayList<VertexMatrix> nodes; 
	int numColors;
	int[][] matrixF;
	boolean useFMatrix = false;
	public GraphMatrix() { 
		numNodes = 0; 
		nodes = new ArrayList<VertexMatrix>();
	}
	public GraphMatrix(int[][] adjMatrix, boolean decompose) {
		numNodes = 0; 
		nodes = new ArrayList<VertexMatrix>();
		if (decompose) { 
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
		else { 
			for (int i = 0; i < adjMatrix.length; i++) { 
				addNode();
			}
			matrixF = adjMatrix;
			useFMatrix = true; 
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
		if (!useFMatrix) {
			int[][] matrix = new int[nodes.size()][nodes.size()]; 
			for (int i = 0; i < nodes.size(); i++) { 
				matrix[i] = nodes.get(i).getConnectionArray();
			}
			return matrix;
		} 
		else { 
			return matrixF;
		}
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
		Colors[] l = getAllNodeColors();
		HashSet<Colors> hs = new HashSet<Colors>();
		for (int i = 0; i < l.length; i++) { 
			hs.add(l[i]);
		}
		return hs.size();
	}
	public void setNumColors(int numColors) {
		this.numColors = numColors;
	}
	

}
