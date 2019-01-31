package graphs;

import java.util.Arrays;
import java.util.Iterator;
// The vertex that finishes last should be the mother node
// In Directed Graph : The vertex which has path to reach every other vertex is called mother vertex 
public class MotherVertex {

	public void DFSUtil(int v,boolean visited[],Graph g)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        Iterator<Node> i = g.adjacencyList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next().destination;
            if (!visited[n])
                DFSUtil(n, visited,g);
        }
    }
    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(Graph g)
    {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[g.vertices];
        
        Arrays.fill(visited, false);
        // The vertex that finishes last should be the mother node
        int v = -1;
        for (int i = 0; i < g.vertices; i++)
        {
            if (!visited[i])
            {
                DFSUtil(i, visited,g);
                v = i;
            }
        }
        
        // the node that finishes last in DFS can be the mother vertex

        Arrays.fill(visited, false);
        System.out.println(" Mother Vertex Detected At:"  + v);
        
        // we found the last finishing node
        // need to validate that
        // consider a individual node in the graph. It may not be the last vertex to finish.
        // to we need to confirm that
        DFSUtil(v, visited,g);
        for(int i = 0; i < g.vertices; i++)
        {
            if(visited[i] == false)
            {
                System.out.println("Not a mother vertex.Node that wasn't connected :" + i);        
                return;
            }
        }
        System.out.println(" Mother Vertex: "  + v);
    }
    public static void main(String args[])
    {
        Graph g = new Graph(4);
        
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        MotherVertex mv = new MotherVertex();
        mv.DFS(g);
        mv.printGraph(g);
    }
   
    void printGraph(Graph g) 
    {
        for (int j= 0; j < g.vertices; ++j)
        {
            System.out.print("j:" + j + " :  ");
            Iterator<Node> i = g.adjacencyList[j].listIterator();
            while (i.hasNext())
            {
                int n = i.next().destination;
                System.out.print( " " + n + " ");
            }
            System.out.println(" ");
        }    
    }
}
