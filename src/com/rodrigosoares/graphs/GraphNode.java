package com.rodrigosoares.graphs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class represents a node of the a graph
 */
public class GraphNode {
    private Object nodeValue;
    private HashSet<GraphNode> nodeConnections;
    private HashMap<GraphNode, Integer> nodeConnectionsWeight;
    private boolean isValid = true;

    /**
     * Constructor
     *
     * @param nodeValue             Node's value
     * @param nodeConnectionsWeight Connections of the node
     */
    public GraphNode(Object nodeValue, HashMap<GraphNode, Integer> nodeConnectionsWeight) {
        this.nodeValue = nodeValue;
        this.nodeConnectionsWeight = nodeConnectionsWeight != null ? nodeConnectionsWeight : new HashMap<>();
        if (nodeConnectionsWeight != null) {
            this.nodeConnections = new HashSet<>(nodeConnectionsWeight.keySet());
        } else {
            this.nodeConnections = new HashSet<>();
        }
    }

    /**
     * Returns the node's value
     *
     * @return Node's value
     */
    public Object getNodeValue() {
        return nodeValue;
    }

    /**
     * Set node's value
     *
     * @param nodeValue Node's value
     */
    public void setNodeValue(Object nodeValue) {
        this.nodeValue = nodeValue;
    }

    /**
     * Get node's connection
     *
     * @return Node's connection
     */
    public HashSet<GraphNode> getNodeConnections() {
        return nodeConnections;
    }

    public HashMap<GraphNode, Integer> getNodeConnectionsWeight() {
        return nodeConnectionsWeight;
    }

    public void setNodeConnectionsWeight(HashMap<GraphNode, Integer> nodeConnectionsWeight) {
        this.nodeConnectionsWeight = nodeConnectionsWeight;
    }

    public HashSet<GraphNode> getValidNodeConnections() {
        HashSet<GraphNode> validNodes = new HashSet<>();
        for (GraphNode node : nodeConnections) {
            if (node.isValid()) {
                validNodes.add(node);
            }
        }
        return validNodes;
    }

    public HashSet<GraphNode> getInvalidNodeConnections() {
        HashSet<GraphNode> validNodes = new HashSet<>();
        for (GraphNode node : nodeConnections) {
            if (!node.isValid()) {
                validNodes.add(node);
            }
        }
        return validNodes;
    }

    public Map<GraphNode, Integer> getValidNodeConnectionsWeightOrder() {
        Map<GraphNode, Integer> ordered = nodeConnectionsWeight.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e1, LinkedHashMap::new));
        Map<GraphNode, Integer> copy = new HashMap<>(ordered);

        for (GraphNode node : copy.keySet()) {
            if (!node.isValid()) {
                ordered.remove(node);
            }
        }
        return ordered;
    }

    /**
     * Set node's connection
     *
     * @param nodeConnections Node's connection
     */
    public void setNodeConnections(HashSet<GraphNode> nodeConnections) {
        this.nodeConnections = nodeConnections;
    }

    /**
     * Adds a single node connection
     *
     * @param node Node's connection
     */
    public void addNodeConnection(GraphNode node) {
        this.nodeConnections.add(node);
    }

    /**
     * Add a weight to a node connection
     *
     * @param node   Node's connection
     * @param weight Weight of the connection
     */
    public void addNodeConnectionWeight(GraphNode node, Integer weight) {
        this.nodeConnectionsWeight.put(node, weight);
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
     *
     * @return true if the node was visited or false if it was not visited
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Set if a node of the graph was already visited or not
     *
     * @param valid true if the node was visited or false if it was not visited
     */
    public void setValid(boolean valid) {
        isValid = valid;
    }
}
