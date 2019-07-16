package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import graphs.GraphMatrix;

public class GraphSerializer {
	
	public static void writeGraph(GraphMatrix g, File f) { 
		try {
			FileOutputStream s = new FileOutputStream(f);
			ObjectOutputStream o = new ObjectOutputStream(s);
			o.writeObject(g);
			
			o.close();
			s.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		
	}
	
	public GraphMatrix readGraph(File f) { 
		GraphMatrix g = null;
		try { 
			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			g = (GraphMatrix) oi.readObject();
			oi.close();
			fi.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			System.out.println("Error initializing stream");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return g;
	}
	public static String nameFile(GraphMatrix g) { 
		return null;
	}

}
