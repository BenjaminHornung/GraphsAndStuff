package graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFS {

    public static void processGraph(Graph graph, String start) throws Exception {
        Queue<Vertex> queue = new ConcurrentLinkedQueue<>();
        graph.cleanUp();
        Vertex vert = graph.getVertex(start);
        vert.setStart(true);
        vert.setState(1);
        vert.setDistance(0);
        queue.add(vert);
        while(!queue.isEmpty()){
            Vertex u = queue.poll();
            ArrayList<Vertex> ar = u.getConnectedTo();
            for(Vertex v : ar){
               if(v.getState() == Vertex.WHITE){
                   v.setState(Vertex.GREY);
                   v.setDistance(u.getDistance() + 1);
                   v.setParent(u);
                   queue.add(v);
               }
            }
            u.setState(Vertex.BLACK);
        }
    }

    public static String shortestPathTo(Graph graph, String end) throws Exception {
        if(!graph.isBfs())
            throw new Exception("BFS.shortestPathTo: You have to run the method processGraph first");
        String s = "";
        Vertex vert = graph.getVertex("end");
        int dis = vert.getDistance();
        while(!vert.isStart()) {
            String tmp = vert.getName() + " ";
            s = tmp + s;
            vert = vert.getParent();
        }
        return s;
    }
}
