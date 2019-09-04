package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphSearchBreadthFirst extends GraphSearchStrategy {

    GraphSearchBreadthFirst(HashMap<Object, GraphNode> nodesHashMap) {
        super(nodesHashMap);
    }

    @Override
    public GraphNode getGraphNode(Object nodeValue) {
        return null;
    }

    @Override
    public LinkedList<GraphNode> pathBetween(Object startValue, Object endValue) {
        return null;
    }
}
