package dijkstras;

public class App {

	
	public static void main(String[] args) {
        
		Vertex v1 = new Vertex("Arad");
		Vertex v2 = new Vertex("Zerind");
		Vertex v3 = new Vertex("Oradea");
		Vertex v4 = new Vertex("Sibiu");
		Vertex v5 = new Vertex("Fagaras");
		Vertex v6 = new Vertex("Rimnicu Vilcea");
		Vertex v7 = new Vertex("Pitesti");
		Vertex v8 = new Vertex("Timisoara");
		Vertex v9 = new Vertex("Lugoj");
		Vertex v10 = new Vertex("Mehadia");
		Vertex v11 = new Vertex("Drobeta");
		Vertex v12 = new Vertex("Craiova");
		Vertex v13 = new Vertex("Bucharest");
		Vertex v14 = new Vertex("Giurgiu");

		//initialize the edges
		
		v1.addNeighbour(new Edge(74, v1, v2));
		v1.addNeighbour(new Edge(140, v1, v4));
		v1.addNeighbour(new Edge(118, v1, v8));

		v2.addNeighbour(new Edge(75, v2, v1));
		v2.addNeighbour(new Edge(71, v2, v3));

		v3.addNeighbour(new Edge(71, v3, v2));
		v3.addNeighbour(new Edge(151, v3, v4));

		v4.addNeighbour(new Edge(140, v4, v1));
		v4.addNeighbour(new Edge(99, v4, v5));
		v4.addNeighbour(new Edge(151, v4, v3));
		v4.addNeighbour(new Edge(80, v4, v6));

		v5.addNeighbour(new Edge(99, v5, v4));
		v5.addNeighbour(new Edge(211, v5, v13));

		v6.addNeighbour(new Edge(80, v6, v4));
		v6.addNeighbour(new Edge(97, v6, v7));
		v6.addNeighbour(new Edge(146, v6, v12));

		v7.addNeighbour(new Edge(97, v7, v6));
		v7.addNeighbour(new Edge(101, v7, v13));
		v7.addNeighbour(new Edge(138, v7, v12));

		v8.addNeighbour(new Edge(118, v8, v1));
		v8.addNeighbour(new Edge(111, v8, v9));

		v9.addNeighbour(new Edge(111, v9, v8));
		v9.addNeighbour(new Edge(70, v9, v10));

		v10.addNeighbour(new Edge(70, v10, v9));
		v10.addNeighbour(new Edge(75, v10, v11));

		v11.addNeighbour(new Edge(75, v11, v10));
		v11.addNeighbour(new Edge(120, v11, v12));

		v12.addNeighbour(new Edge(120, v12, v11));
		v12.addNeighbour(new Edge(146, v12, v6));
		v12.addNeighbour(new Edge(138, v12, v7));

		v13.addNeighbour(new Edge(101, v13, v7));
		v13.addNeighbour(new Edge(90, v13, v14));
		v13.addNeighbour(new Edge(211, v13, v5));

		v14.addNeighbour(new Edge(90, v14, v13));


        Dijkstra dijkstra = new Dijkstra();

        dijkstra.computePath(v2);

        System.out.println(dijkstra.getShortestPathTo(v13));
    }
	

}
