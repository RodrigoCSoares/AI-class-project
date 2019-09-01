package com.rodrigosoares.graphs.search;

import com.rodrigosoares.graphs.GraphNode;
import com.rodrigosoares.graphs.search.strategies.GraphSearchStrategy;

import java.util.LinkedList;

/**
 * This class search for a specific node of a graph using some search strategy
 */
public class GraphSearcher {
    private GraphSearchStrategy searchStrategy;

    /**
     * Constructor
     * @param searchStrategy Search strategy to be used
     */
    public GraphSearcher(GraphSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    /**
     * Search for a graph node with the given node value
     * @param nodeValue Node value to be searched
     * @return A graph node with the given node value or null if there is no graph node with that value
     */
    public GraphNode getGraphNode(Object nodeValue) {
        return searchStrategy.getGraphNode(nodeValue);
    }

    /**
     * Verifies if there is or there is not a node with a given node value
     * @param nodeValue Node value to be searched
     * @return true if there is a node or false if there is not
     */
    public boolean hasGraphNode(Object nodeValue) {
        return searchStrategy.hasGraphNode(nodeValue);
    }

    /**
     * Search for a path between two nodes
     * @param startValue The value of the node to be used as the start of the search
     * @param endValue The value of the end node to be used as the end of the search
     * @return The path between those two nodes
     */
    public LinkedList pathBetween(Object startValue, Object endValue) {
        return searchStrategy.pathBetween(startValue, endValue);
    }
}
