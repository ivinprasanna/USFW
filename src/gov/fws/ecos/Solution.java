package gov.fws.ecos;

import java.util.ArrayList;
import java.util.List;

public class Solution extends DAG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating a few Vertices.
		Vertex v = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		
		//Creating a few Edges that contains from, to and the weight of the edge.
		Edge e = new Edge(v,v1,18);
		Edge e1 = new Edge(v,v3,5);
		Edge e2 = new Edge(v2,v5,16);
		Edge e3 = new Edge(v2,v4,8);
		Edge e4 = new Edge(v3,v6,18);
		Edge e5 = new Edge(v4,v6,19);
		Edge e6 = new Edge(v5,v6,3);
		
		//Adding the vertices to a list
		List<Vertex> ver = new ArrayList<Vertex>();
		ver.add(v);
		ver.add(v1);
		ver.add(v2);
		ver.add(v3);
		ver.add(v4);
		ver.add(v5);
		ver.add(v6);
		
		//Adding the edges to a list
		List<Edge> edge = new ArrayList<Edge>();
		edge.add(e);
		edge.add(e1);
		edge.add(e2);
		edge.add(e3);
		edge.add(e4);
		edge.add(e5);
		edge.add(e6);
		
		//Creating a graph that consists of lists of Edges and Vertices
		DAG g = new DAG(ver, edge);
		
		//Calling the method to find the longest directed path.
		String str = DAG.longestDirectedPath(g,v2);
		
		//Printing the path
		System.out.println("Longest Path: " +str);
		
	}
	

}
