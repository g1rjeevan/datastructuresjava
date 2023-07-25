package com.datastructures.java.graph;

import java.util.List;

public class GraphNode {

    int val;
    List<GraphNode> neighbors;

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }

    public void setNeighbors(List<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }


}
