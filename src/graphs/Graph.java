package graphs;

import java.util.LinkedList;

public class Graph{
    int vertices;
    LinkedList<Node> [] adjacencyList;

    @SuppressWarnings("unchecked")
	public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i <vertices; i++) {
            adjacencyList[i] = new LinkedList<Node>();
        }
    }

    public void addEdge(int source, int destination){
        Node node = new Node(source, destination);
        //add edge
        adjacencyList[source].addFirst(node);
    }
    
    public void addEdgeUndirectedGraph(int source, int destination){
        Node s = new Node(source, destination);
        Node d = new Node(source, destination);

        //add forward edge
    	adjacencyList[source].addFirst(s);

        //add reverse edge
    	adjacencyList[destination].addFirst(d);
    }
}

