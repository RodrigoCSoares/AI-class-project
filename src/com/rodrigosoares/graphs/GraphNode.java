package com.rodrigosoares.graphs;

import java.util.ArrayList;

/**
 * This class represents a node of the a graph
 */
public class GraphNode {
    private Object nodeValue;
    private ArrayList<GraphNode> nodeConnections;

    /**
     * Constructor
     * @param nodeValue Node's value
     * @param nodeConnections Connections of the node
     */
    public GraphNode(Object nodeValue, ArrayList<GraphNode> nodeConnections) {
        this.nodeValue = nodeValue;
        this.nodeConnections = nodeConnections != null ? nodeConnections : new ArrayList<>();
    }

    /**
     * Returns the node's value
     * @return Node's value
     */
    public Object getNodeValue() {
        return nodeValue;
    }

    /**
     * Set node's value
     * @param nodeValue Node's value
     */
    public void setNodeValue(Object nodeValue) {
        this.nodeValue = nodeValue;
    }

    /**
     * Get node's connection
     * @return Node's connection
     */
    public ArrayList<GraphNode> getNodeConnections() {
        return nodeConnections;
    }

    /**
     * Set node's connection
     * @param nodeConnections Node's connection
     */
    public void setNodeConnections(ArrayList<GraphNode> nodeConnections) {
        this.nodeConnections = nodeConnections;
    }

    /**
     * Adds a single node connection
     * @param node Node's connection
     */
    public void addNodeConnection(GraphNode node) {
        this.nodeConnections.add(node);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "nodeName='" + nodeValue.toString() + '\'' +
                ", nodeConnections=" + nodeConnections +
                '}';
    }
}
