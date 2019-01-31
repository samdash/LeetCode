package graphs;


public class GraphDFSRecursion {
    	
    public void printGraph(Graph graph){
        for (int i = 0; i <graph.vertices ; i++) {
            if(graph.adjacencyList[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < graph.adjacencyList[i].size(); j++) {
                    System.out.print(graph.adjacencyList[i].get(j).destination + " ");
                }
                System.out.println();
            }
        }
    }

    public void DFSRecursion(int startVertex,Graph graph){
        boolean [] visited = new boolean[graph.vertices];
        dfs(startVertex, visited,graph);
    }

    public void dfs(int start, boolean [] visited,Graph graph){
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i <graph.adjacencyList[start].size() ; i++) {
            int destination = graph.adjacencyList[start].get(i).destination;
            if(!visited[destination])
                dfs(destination,visited,graph);
        }
    }


    public static void main(String[] args) {
		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.print("Following is Depth First Traversal "+ 
                "(starting from vertex 2) --> "); 

        GraphDFSRecursion gdr = new GraphDFSRecursion();
        gdr.DFSRecursion(2,g);System.out.println();
        gdr.printGraph(g);
    }
}