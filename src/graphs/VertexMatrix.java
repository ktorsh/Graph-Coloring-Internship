package graphs;

import java.awt.Color;
import java.util.ArrayList;

public class VertexMatrix {
	int num; 
	ArrayList<Integer> connections; 
	Colors color; 
	
	public VertexMatrix() { 
		num = 0; 
		connections = new ArrayList<Integer>(); 
		color = Colors.BLACK;
	}
	public VertexMatrix(int n, int size) { 
		num = n; 
		connections = new ArrayList<Integer>();
		increaseNodeSize(size);
		color = Colors.BLACK;
	}
	public VertexMatrix(int n, ArrayList<Integer> c) { 
		num = n; 
		connections = new ArrayList<Integer>(c); 
		color = Colors.BLACK;
	}
	public void addConnection(int wantedVertex) { 
		if (connections.size() < wantedVertex + 1) { 
			increaseNodeSize(wantedVertex - connections.size() + 1); 
		}
		connections.set(wantedVertex, 1);	
	}
	/** 
	 * 
	 * @param wantedVertex
	 * @return
	 * Returns whether or not there was a connection to begin with
	 */
	public int removeConnection(int wantedVertex) {
		if (wantedVertex >= connections.size()) { 
			return 0;
		}
		int temp = connections.get(wantedVertex);
		connections.set(wantedVertex, 0); 
		return temp; 
		
	}
	public ArrayList<Integer> removeAllConnections(){ 
		ArrayList<Integer> temp = new ArrayList<Integer>(connections); 
		for (int i = 0; i < connections.size(); i++) { 
			connections.set(i, 0);
		}
		return temp;
	}
	public void increaseNodeSize(int n) { 
		for (int i =0; i< n; i++) {
			connections.add(0);
		}
	}
	
	public int[] getConnectionArray() { 
		int[] row = new int[connections.size()]; 
		for (int i = 0; i < connections.size(); i++) { 
			row[i] = connections.get(i);
		}
		return row;
	}
	public int getDegree() { 
		int count = 0;
		for (int i = 0; i < connections.size(); i++) {  
			if (connections.get(i) == 1) { 
				count++;      
			}
		}
		return count;
	}
	public int getDegree(ArrayList<Integer> connectedNodes) { 
		int count = 0;
		for (int i = 0; i < connections.size(); i++) {  
			if (connections.get(i) == 1 && connectedNodes.contains(i)) { 
				count++;      
			}
		}
		return count;
	}
	public int getDegree(int[] connectedNodes) { 
		int count = 0;
		for (int i = 0; i < connections.size(); i++) {  
			if (connections.get(i) == 1 && contains(connectedNodes, i)) { 
				count++;      
			}
		}
		return count;
	}
	public Colors getColor() {
		return color;
	}
	public void setColor(Colors color) {
		this.color = color;
	}
	private boolean contains(int[] arr, int n) { 
		for (int i = 0; i < arr.length; i++) { 
			if (arr[i] == n) { 
				return true;
			}
		}
		return false;
	}
//	public LinkedList<Integer> getAdjList(){ 
//		
//	}


}
