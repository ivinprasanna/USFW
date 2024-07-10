package gov.fws.ecos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DAG {
	List<Vertex> v;
	
	List<Edge> e;
	//Temporary List that we use to add vertex till the end of the path
	static List<Vertex> list = new ArrayList<>();
	//Final list of vertex after all iterations to store a full path
	static List<List<Vertex>> fin = new ArrayList<>();
	//Adds up the total weight across a path
	static int pathWeight = 0;
	//Using this to map the the path and the total weight
	static Map<List<Vertex>, Integer> finalMap = new HashMap<>();
	
	DAG() {
		
	}
	
	DAG(List<Vertex> v, List<Edge> e) {
		this.v = v;
		this.e = e;
	}
	
	public List<Vertex> getV() {
		return v;
	}

	public void setV(List<Vertex> v) {
		this.v = v;
	}

	public List<Edge> getE() {
		return e;
	}

	public void setE(List<Edge> e) {
		this.e = e;
	}

	@Override
	public String toString() {
		String str = "";
		for(Vertex val: v) {
			str = str + "Vertex Id:" + val.getId() + "\n";
		}
		for(Edge val: e) {
			str = str + "Edge:" +val.getFrom().getId() + " " + val.getTo().getId() + " " + val.getWeight() + "\n";
		}
		
		return str;
	}
	
	public static String longestDirectedPath(DAG g, Vertex v) {
		int path = 0;
		String str = "";
		//Checking for empty graph
		if(g.getE().isEmpty()) 
			return "Empty Graph";
		
		//Choosing the edge that has the highest weight and adding the vertex to a temp list 
		List<Vertex> temp = new LinkedList<>();
		for(Edge edg: g.getE()) {
			if(edg.getFrom().getId() == v.getId()) {
				if(edg.getWeight() > path) {
					temp.add(0, edg.getTo());
					path = edg.getWeight();
				}
			}
		}
		//Adding the vertex to a string to return 
		//Calling this method again to traverse through the graph
		if(!temp.isEmpty()) {
			v = temp.get(0);
			str = Long.toString(v.getId());
			str = str + " " + DAG.longestDirectedPath(g, v);
		}
		//Checking for the end
		if(str.isBlank())
			str = "End of Path";
		
		return str;
		
	}
	
	public static void longestPathDAG(DAG g, Vertex v) {
		list.add(v);
		List<Vertex> temp = new ArrayList<>();
		if(g.getE().isEmpty())
			System.out.println("Empty Graph");
		
		//Doing Recursive operation until we reach the end of the path.
		//We add each element along the path to the list
		for(Edge edg: g.getE()) {
			if(edg.getFrom().getId() == v.getId()) {
				pathWeight = pathWeight + edg.getWeight();
				if(!list.contains(edg.getFrom())) {
					list.add(v);
				}
				temp.add(0, edg.getTo());
				longestPathDAG(g, temp.get(0));	
			}
		}
		//final list that holds a path
		fin.add(list);
		//Check to only add elements when they exist
		if(list.size() > 0 && pathWeight > 0) 
			finalMap.put(list, pathWeight);
		//Restarting for a new path
		pathWeight = 0;
		list = new ArrayList<>();
	}
	
	public static void printLongestPath() {
		int longest = 0;
		//This loop will find the longest path in the map
		for(Entry<List<Vertex>, Integer> e: finalMap.entrySet()) {
			if(e.getValue() > longest)
				longest = e.getValue();
		}
		//This loop with fetch the List of Vertices that the contributed to the total weight
		for(Entry<List<Vertex>, Integer> e: finalMap.entrySet()) {
			if(e.getValue() == longest)
				System.out.println(e.getKey());
		}
	}
		
}
