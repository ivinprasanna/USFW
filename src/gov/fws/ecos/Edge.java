package gov.fws.ecos;

public class Edge {
Vertex from;
Vertex to;
int weight;


Edge() {
	
}

Edge(Vertex from, Vertex to, int weight) {
	this.from = from;
	this.to = to;
	this.weight = weight;
}

public Vertex getFrom() {
	return from;
}

public Vertex getTo() {
	return to;
}

public void setFrom(Vertex from) {
	this.from = from;
}

public void setTo(Vertex to) {
	this.to = to;
}

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

@Override
public String toString() {
    return from.getId() + " " + to.getId() + " " + weight;
}
}
