package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * This abstract class represents a search strategy for a graph
 */
public abstract class GraphSearchStrategy {

    /**
     * Constructor
     * @param nodesHashMap Graph nodes hash map
     */
    GraphSearchStrategy(HashMap<Object, GraphNode> nodesHashMap) {
    }

    /**
     * Returns a graph node based on its value
     * @param nodeValue Node value to be searched
     * @return The graph node if it exists or null if it does not exist
     */
    public abstract GraphNode getGraphNode(Object nodeValue);

    /**
     * Search for a path between two nodes
     * @param startValue The value of the node to be used as the start of the search
     * @param endValue The value of the end node to be used as the end of the search
     * @return The path between those two nodes
     */
    public abstract LinkedList<GraphNode> pathBetween(Object startValue, Object endValue);

}
