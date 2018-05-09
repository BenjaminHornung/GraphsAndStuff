package graph;

import java.util.ArrayList;

public class Vertex {
    public static final int DIRECTED = 0;
    public static final int UNDIRECTED = 1;

    private int distance = 0;
    private Vertex parent = null;
    private ArrayList<Vertex> connectedTo = null;
    private int state = 0;
    private String name = null;


    public Vertex(String name) {
        setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public ArrayList<Vertex> getConnectedTo() {
        return connectedTo;
    }

    private void setConnectedTo(Vertex ver) {
        this.connectedTo.add(ver);
    }


    public void addConnection(Vertex ver, int type) throws Exception {
        if (type == DIRECTED) {
            this.setConnectedTo(ver);
        } else if (type == UNDIRECTED) {
            ver.setConnectedTo(this);
            this.setConnectedTo(ver);
        } else {
            throw new Exception("Vertex.addConnection: A connection can be either directed or undirected");
        }
    }

    public void removeConnection(Vertex ver, int type) throws Exception {
        if (!this.connectedTo.contains(ver)) {
            throw new Exception("Vertex.removeConnection: The given vertex is not connected with this vertex");
        } else {
            if (type == DIRECTED) {
                this.connectedTo.remove(ver);
            } else if (type == UNDIRECTED) {
                ver.connectedTo.remove(ver);
                this.connectedTo.remove(ver);
            } else {
                throw new Exception("Vertex.removeConnection: You can only remove directed or undirected connections");
            }
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) throws Exception {
        if (this.state > 2) {
            throw new Exception("Vertex.setState: The state cannot be bigger than 2");
        } else {
            this.state = state;
        }
    }

}
