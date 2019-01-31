package dijkstras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Dijkstra algorithm is similar to BFS graph search 
 */
public class Dijkstra {
	
    public void computePath(Vertex sourceVertex) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
        	
            Vertex vertex = priorityQueue.poll();

            for (Edge edge : vertex.getEdges()) {
                Vertex nextVertex = edge.getTargetVertex();
                double weight = edge.getWeight();
                double minDistance = vertex.getMinDistance() + weight;
                if (minDistance < nextVertex.getMinDistance()) {
                    priorityQueue.remove(vertex);
                    nextVertex.setPreviousVertex(vertex);
                    nextVertex.setMinDistance(minDistance); // settle this vertex ( change from Infity to min distance
                    priorityQueue.add(nextVertex);// process this vertex next
                }
            }
        }
    }
    
    
    public List<Vertex> getShortestPathTo(Vertex nextVertex) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = nextVertex; vertex != null; vertex = vertex.getPreviousVertex()) {
            path.add(vertex);
            System.out.println(vertex+" --> with distance: "+vertex.getMinDistance());
        }

        Collections.reverse(path);
        return path;
    }
}