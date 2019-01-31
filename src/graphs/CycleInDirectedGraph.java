package graphs;

public class CycleInDirectedGraph {


	 
    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        CycleInDirectedGraph cg = new CycleInDirectedGraph();
        cg.printGraph(graph);
        boolean result = cg.isCycle(graph);
        System.out.println("is Cycle present: " + result);
    }

    public boolean isCycle(Graph graph) {
        boolean visited[] = new boolean[graph.vertices];
        boolean recursiveStack[] = new boolean[graph.vertices];

        //do DFS from each node
        for (int i = 0; i < graph.vertices; i++) {
            if (isCycleUtil(i, visited, recursiveStack,graph))
                return true;
        }
        return false;
    }

    public boolean isCycleUtil(int vertex, boolean[] visited, boolean[] recursiveStack,Graph graph) {
        visited[vertex] = true;
        recursiveStack[vertex] = true;

        //recursive call to all the adjacent vertices
        for (int i = 0; i < graph.adjacencyList[vertex].size(); i++) {
            //if not already visited
            int adjVertex = graph.adjacencyList[vertex].get(i).destination;
            if (!visited[adjVertex] && isCycleUtil(adjVertex, visited, recursiveStack,graph)) {
                return true;
            } else if (recursiveStack[adjVertex])
                return true;
        }
        //if reached here means cycle has not found in DFS from this vertex
        //reset
        recursiveStack[vertex] = false;
        return false;
    }
    
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

}
