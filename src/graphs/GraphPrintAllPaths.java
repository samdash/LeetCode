package graphs;

import java.util.LinkedList;


/*
 Objective: Given a graph, source vertex and destination vertex. Write an algorithm to print all possible paths between source and destination.
 
 Approach: Use Depth First Search

1) Start from the source vertex and visit the next vertex (use adjacency list).
2) Now if you look carefully, the new problem is to find paths from the current vertex to destination. 
For instance as per the example above, start from vertex 0 and visit vertex 1. 
Now all the paths from vertex 1 to vertex 5 will be included in our final result if we add vertex 0. 
So make a recursive call with source as vertex 1 and destination as vertex 5.

3) Keep track of visited nodes to avoid cycles.
4) Add current vertex to result (taking string here) to keep track of path from source.
5) Once reach to the destination vertex, print the path.
6) Now visit the next node in adjacency list in step 1 and repeat all the steps (loop)

 */
public class GraphPrintAllPaths {

	
    public void printAllPaths(Graph graph, int start, int end){
        boolean[] visited = new boolean[graph.vertices];
        visited[start] = true;
        print(graph, start, end, "", visited);
    }

	public void print(Graph graph, int start, int end, String path, boolean[] visited){
        String newPath = path +  "->" + start;
        visited[start] = true;
        LinkedList<Node> list = graph.adjacencyList[start];
        for (int i = 0; i <list.size() ; i++) {
            Node node = list.get(i);
            if(node.destination!=end && !visited[node.destination]){
//                visited[node.destination] = true;
                print(graph,node.destination,end,newPath,visited);
            }else if(node.destination==end){
                System.out.println(newPath + "->" + node.destination);
            }
        }
        //remove from path
        visited[start] = false;
    }

    public void printGraph(Graph graph, int vertices){
        for (int i = 0; i <vertices ; i++) {
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
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        GraphPrintAllPaths p = new GraphPrintAllPaths();
        p.printAllPaths(graph,0,5);
        p.printGraph(graph, vertices);
    }
}
