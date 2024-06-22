package gov.fws.ecos;

public class Vertex {
	long id;
	
	Vertex() {
		
	}
	
	Vertex(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String toString() {
		return Long.toString(id);
	}
}
