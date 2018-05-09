package graph;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFS {
    public static void processGraph(Graph graph, String start) throws Exception {
        Queue<Vertex> queue = new ConcurrentLinkedQueue<>();
        graph.cleanUp();
        Vertex vert = graph.getVertex(start);
        vert.setState(1);
        vert.setDistance(0);
        queue.add(vert);
    }
}
