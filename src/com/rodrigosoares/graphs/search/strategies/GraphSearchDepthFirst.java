package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.Stack;

/**
 * This class is the Depth-first search strategy of a graph.
 * It searches the value going deeper and deeper into the nodes before changing to a same-level node.
 */
public class GraphSearchDepthFirst extends GraphSearchStrategy {
    private GraphNode rootNode;

    /**
     * Constructor
     * @param rootNode Root node of the graph
     */
    public GraphSearchDepthFirst(GraphNode rootNode) {
        super(rootNode);
        this.rootNode = rootNode;
    }

    @Override
    public GraphNode getGraphNode(Object nodeValue) {
        Stack<GraphNode> searchStack = new Stack<>();
        if (rootNode.getNodeValue().equals(nodeValue)) {
            return rootNode;
        }

        searchStack.addAll(rootNode.getNodeConnections());
        while (!searchStack.isEmpty()) {
            GraphNode currentNode = searchStack.pop();
            if(currentNode.getNodeValue().equals(nodeValue)) {
                return currentNode;
            }

            searchStack.addAll(currentNode.getNodeConnections());
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
