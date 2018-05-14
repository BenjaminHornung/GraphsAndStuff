package graph;

import java.util.Arrays;
import java.util.List;

public class Graph {

    private boolean bfs = false;
    private int capacity = 10;
    private int size = 0;
    private Vertex[] vertices = new Vertex[10];

    public Graph() {
    }

    public Graph(Vertex ver) throws Exception {
        addVertex(ver);
    }

    public Graph(Vertex[] ver) throws Exception {
        for (Vertex v : ver) {
            addVertex(v);
        }
    }

    public Graph(List<Vertex> ver) throws Exception {
        for (Vertex v : ver) {
            addVertex(v);
        }
    }

    void addVertex(Vertex vert) throws Exception {
        if (checkNames(vert.getName())) {
            if (this.size == capacity) {
                vertices = Arrays.copyOf(vertices, (capacity / 2) * 3);
                capacity = (capacity / 2) * 3;
            }
            vertices[size] = vert;
            size++;
        } else {
            throw new Exception("Graph.addVertex: The name of a Vertex must be unique " +  vert.getName());
        }
    }

    public boolean checkNames(String name) {
        for (Vertex v : vertices) {
            if(v == null){
                return true;
            }
            if ( v.getName().equals(name))
                return false;
        }
        return true;
    }

    public Vertex getVertex(String name) throws Exception {
        for (Vertex v : vertices) {
            if (v.getName().equals(name))
                return v;
        }
        throw new Exception("Graph.getVertex: The vertex with the given name does not exist");
    }

    public void cleanUp() throws Exception {
        for (Vertex v : vertices) {
            if(v != null){
                v.setState(0);
                v.setDistance(-999);
                v.setParent(null);
            }
        }
    }

    public boolean isBfs() {
        return bfs;
    }

    public void setBfs(boolean bfs) {
        this.bfs = bfs;
    }
}
