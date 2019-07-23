package generators;

import graphs.GraphMatrix;

public class RandomGen {
	/**
	 * 
	 * @param n
	 * @param d - the "density of the connections"
	 */
	public static GraphMatrix randomGen(int n, double d) { 
		int[] connections = new int[n*(n-1)/2];
		for (int i = 0; i < connections.length; i++) { 
			connections[i] = (int) (Math.random() + d); 
		}
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				if (i == j) { //if its along the diagonal 
					matrix[i][j] = 0; //nodes dont connect to themselves
				}
				else { 
					if (i < j) { 
						matrix[i][j] = connections[i*(2*n-i-1)/2 + (j-i-1)];
					}
					else { 
						matrix[i][j] = connections[j*(2*n-j-1)/2 + (i-j-1)];
					}
				}
			}
		}
		return new GraphMatrix(matrix, false);
	}

}
