package graphs;

public class CycleInUndirectedGraph {


    public boolean isCycle(Graph graph) {

        //visited array
        boolean[] visited = new boolean[graph.vertices];
        //do DFS, from each vertex
        for (int i = 0; i <graph.vertices ; i++) {
            if(!visited[i]){
                if(isCycleUtil(i, visited, -1,graph)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean isCycleUtil(int currVertex, boolean [] visited, int parent,Graph graph){

        //add this vertex to visited vertex
        visited[currVertex] = true;

        //visit neighbors except its direct parent
        for (int i = 0; i <graph.adjacencyList[currVertex].size() ; i++) {
            int vertex = graph.adjacencyList[currVertex].get(i).destination;
            //check the adjacent vertex from current vertex
            if(vertex!=parent) {
                //if destination vertex is not its direct parent then
                if(visited[vertex]){
                    //if here means this destination vertex is already visited
                    //means cycle has been detected
                    return true;
                }
                else{
                    //recursion from destination node
                    if (isCycleUtil(vertex, visited, currVertex,graph)) {
                        return true;
                    }
                }
            }
        }
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

 
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdgeUndirectedGraph(0, 1);
        graph.addEdgeUndirectedGraph(1, 2);
        graph.addEdgeUndirectedGraph(2, 3);
        graph.addEdgeUndirectedGraph(3, 4);
        graph.addEdgeUndirectedGraph(4, 5);
        graph.addEdgeUndirectedGraph(5, 2);
        CycleInUndirectedGraph c = new CycleInUndirectedGraph();
        boolean result = c.isCycle(graph);
        System.out.println("is Cycle present: " + result);
        c.printGraph(graph);
    }
}