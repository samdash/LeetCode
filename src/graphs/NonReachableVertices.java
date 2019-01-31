package graphs;

import java.util.Arrays;

public class NonReachableVertices {
    

    public int calculateVertices(int vertex,Graph graph){
        boolean [] visited = new boolean[graph.vertices];
        Arrays.fill(visited, false);
        //Do the DFS from the given vertex
        dfs(vertex, visited,graph);

        //count the number of non reached vertices
        int count = 0;
        for (int i = 0; i <visited.length ; i++) {
            if(visited[i]==false)
                count++;
        }
        return count;
    }

    public void dfs(int start, boolean [] visited,Graph graph){
        visited[start] = true;
        for (int i = 0; i <graph.adjacencyList[start].size() ; i++) {
            int vertex = graph.adjacencyList[start].get(i).destination;
            if(!visited[vertex])
                dfs(vertex,visited,graph);
        }
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
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEdgeUndirectedGraph(0, 1);
        graph.addEdgeUndirectedGraph(1, 2);
        graph.addEdgeUndirectedGraph(2, 3);
        graph.addEdgeUndirectedGraph(3, 1);
        graph.addEdgeUndirectedGraph(4, 5);
        graph.addEdgeUndirectedGraph(5, 6);
        NonReachableVertices nrv = new NonReachableVertices();
        nrv.printGraph(graph);
        int nonReachableVertices = nrv.calculateVertices(0,graph);
        System.out.println("Number of non reachable vertices from the vertex 0 are: " + nonReachableVertices);
        nonReachableVertices = nrv.calculateVertices(5,graph);
        System.out.println("Number of non reachable vertices from the vertex 6 are: " + nonReachableVertices);
    }
}