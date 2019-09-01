package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.LinkedList;

/**
 * This abstract class represents a search strategy for a graph
 */
public abstract class GraphSearchStrategy {

    /**
     * Constructor
     * @param rootNode Root node of the graph
     */
    GraphSearchStrategy(GraphNode rootNode) {
    }

    /**
     * Returns a graph node with the given node value
     * @param nodeValue Node value to be searched
     * @return The graph node with the given node value or null if there is no node
     */
    public abstract GraphNode getGraphNode(Object nodeValue);

    /**
     * Verifies if there is or there is not a node with the given node value
     * @param nodeValue Node value to be searched
     * @return true if there is a node or false if there is not
     */
    public abstract boolean hasGraphNode(Object nodeValue);

    /**
     * Search for a path between two nodes
     * @param startValue The value of the node to be used as the start of the search
     * @param endValue The value of the end node to be used as the end of the search
     * @return The path between those two nodes
     */
    public abstract LinkedList<GraphNode> pathBetween(Object startValue, Object endValue);

    /**
     * Sets the root node of the graph
     * @param rootNode Root node of the graph
     */
    public abstract void setRootNode(GraphNode rootNode);

    /**
     * Returns the root node of the graph
     * @return The root node of the graph
     */
    public abstract GraphNode getRootNode();

}
