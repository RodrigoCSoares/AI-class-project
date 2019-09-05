package com.rodrigosoares.graphs;

import java.util.HashSet;

/**
 * This class represents a node of the a graph
 */
public class GraphNode {
    private Object nodeValue;
    private HashSet<GraphNode> nodeConnections;
    private boolean isValid = true;

    /**
     * Constructor
     * @param nodeValue Node's value
     * @param nodeConnections Connections of the node
     */
    public GraphNode(Object nodeValue, HashSet<GraphNode> nodeConnections) {
        this.nodeValue = nodeValue;
        this.nodeConnections = nodeConnections != null ? nodeConnections : new HashSet<>();
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
    public HashSet<GraphNode> getNodeConnections() {
        return nodeConnections;
    }

    public HashSet<GraphNode> getValidNodeConnections() {
        HashSet<GraphNode> validNodes = new HashSet<>();
        for(GraphNode node : nodeConnections) {
            if (node.isValid()) {
                validNodes.add(node);
            }
        }
        return validNodes;
    }

    public HashSet<GraphNode> getInvalidNodeConnections() {
        HashSet<GraphNode> validNodes = new HashSet<>();
        for(GraphNode node : nodeConnections) {
            if (!node.isValid()) {
                validNodes.add(node);
            }
        }
        return validNodes;
    }

    /**
     * Set node's connection
     * @param nodeConnections Node's connection
     */
    public void setNodeConnections(HashSet<GraphNode> nodeConnections) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return getNodeValue().equals(graphNode.getNodeValue());
    }

    /**
     * Checks if a node of the graph was already visited or not
     * @return true if the node was visited or false if it was not visited
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Set if a node of the graph was already visited or not
     * @param valid true if the node was visited or false if it was not visited
     */
    public void setValid(boolean valid) {
        isValid = valid;
    }
}
