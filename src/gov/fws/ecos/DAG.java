package gov.fws.ecos;

import java.util.LinkedList;
import java.util.List;

public class DAG {
	List<Vertex> v;
	
	List<Edge> e;
	
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
	
	
	
	
	
}
