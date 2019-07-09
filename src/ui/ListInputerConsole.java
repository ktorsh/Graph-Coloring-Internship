package ui;

import java.util.Scanner;

import algorithms.SixColorRecursive;
import graphs.GraphMatrix;
import graphs.GraphViewer;

public class ListInputerConsole {
	public static GraphMatrix input() { 
		GraphMatrix g = new GraphMatrix();
		Scanner s = new Scanner(System.in);
		System.out.print("How many nodes: ");
		int n = s.nextInt();
		for (int i = 0; i < n; i++) { 
			g.addNode();
		}
		System.out.println();
		boolean keepDoing = true; 
		while (keepDoing) { 
			System.out.print("Node 1: ");
			int one = s.nextInt();
			if (one < 0 || one >= n) { 
				keepDoing = false;
			}
			if (keepDoing) {
				System.out.print("Node 2: ");
				int two = s.nextInt();
				g.addConnection(one, two);
			}
			System.out.println();
		}
		return g;	
	}
	
	public static void main(String[] args) { 
		GraphMatrix g = input();
		SixColorRecursive alg = new SixColorRecursive(g); 
		alg.color();
		GraphViewer.viewGraph(g);
		
	}

}
