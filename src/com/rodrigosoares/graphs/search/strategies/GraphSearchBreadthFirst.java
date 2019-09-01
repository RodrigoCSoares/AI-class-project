package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.ArrayList;

/**
 * This class is the Breadth-first search strategy of a graph.
 * It start searching in the nearest connections between the nodes, level by level.
 */
public class GraphSearchBreadthFirst extends GraphSearchStrategy {
    private GraphNode rootNode;

    /**
     * Constructor
     * @param rootNode Root node of the graph
     */
    public GraphSearchBreadthFirst(GraphNode rootNode) {
        super(rootNode);
        this.rootNode = rootNode;
    }

    @Override
    public GraphNode getGraphNode(Object nodeValue) {
        if (rootNode.getNodeValue().equals(nodeValue)) {
            return rootNode;
        }

        ArrayList<GraphNode> searchList = new ArrayList<>(rootNode.getNodeConnections());
        while (!searchList.isEmpty()) {
            GraphNode currentNode = searchList.remove(0);
            if(currentNode.getNodeValue().equals(nodeValue)) {
                return currentNode;
            }

            searchList.addAll(currentNode.getNodeConnections());
        }

        return null;
    }

    @Override
    public boolean hasGraphNode(Object nodeValue) {
        return getGraphNode(nodeValue) != null;
    }

    @Override
    public void setRootNode(GraphNode rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public GraphNode getRootNode() {
        return rootNode;
    }
}
