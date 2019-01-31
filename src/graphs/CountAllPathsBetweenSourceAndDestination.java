package graphs;

public class CountAllPathsBetweenSourceAndDestination {

	int paths =0;
	
	public static void main(String[] args) {
		int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        int source =0;
        int destination=5;

        GraphPrintAllPaths p = new  GraphPrintAllPaths();
        p.printAllPaths(graph, source, destination);
        
        CountAllPathsBetweenSourceAndDestination c = new CountAllPathsBetweenSourceAndDestination();
        c.countPaths(source, destination, graph);

	}

	public void countPaths(int source, int destination,Graph graph){
        count(source, destination,graph);
        System.out.println("No of paths between source: " +  source
        + " and destination: " +  destination + " are: " + paths);
    }

    public void count(int start, int destination,Graph graph){
        if(start==destination) {
            paths++;
        }else {
            for (int i = 0; i < graph.adjacencyList[start].size(); i++) {
                int adjacentVerted = graph.adjacencyList[start].get(i).destination;
                count(adjacentVerted, destination,graph);
            }
        }
    }
}
