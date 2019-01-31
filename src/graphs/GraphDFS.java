package graphs;

import java.util.Arrays;
import java.util.Iterator;

public class GraphDFS {

	public static void main(String[] args) {
		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
        
        GraphDFS dfs = new GraphDFS();
        dfs.DFS(2, g);

	}
	
	void DFSUtil(int v,boolean visited[],Graph g) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+"-->"); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Node> i = g.adjacencyList[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int targetVertex = i.next().destination; 
            if (!visited[targetVertex]) 
                DFSUtil(targetVertex, visited,g); 
        } 
    } 
  	
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v, Graph g) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[g.vertices]; 
        Arrays.fill(visited, false);
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited,g); 
    } 
    
}
