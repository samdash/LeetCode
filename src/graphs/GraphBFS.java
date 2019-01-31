package graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

	public static void main(String[] args) {

		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  

        System.out.print("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2) --> "); 
        
        GraphBFS gbs = new GraphBFS();
        gbs.BFS(2, g);System.out.println();
        gbs.printGraph(g);
        
	}
	
	void BFS(int v, Graph g) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[g.vertices]; 
        Arrays.fill(visited, false);
        // Create a queue for BFS 
        Queue<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[v]=true; 
        queue.add(v); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            v = queue.poll(); 
            System.out.print(v+"-->"); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Node> i = g.adjacencyList[v].listIterator(); 
            while (i.hasNext()) 
            { 
                int targetVertex = i.next().destination; 
                if (!visited[targetVertex]) 
                { 
                    visited[targetVertex] = true; 
                    queue.add(targetVertex); 
                } 
            } 
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
	  
}
