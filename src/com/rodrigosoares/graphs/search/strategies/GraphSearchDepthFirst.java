package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * This class is the Depth-first search strategy of a graph.
 * It searches the value going deeper and deeper into the nodes before changing to a same-level node.
 */
public class GraphSearchDepthFirst extends GraphSearchStrategy {
    private HashMap<Object, GraphNode> nodesHashMap;

    /**
     * Constructor
     * @param nodesHashMap Graph nodes hash map
     */
    public GraphSearchDepthFirst(HashMap<Object, GraphNode> nodesHashMap) {
        super(nodesHashMap);
        this.nodesHashMap = nodesHashMap;
    }

//    @Override
//    public GraphNode getGraphNode(Object nodeValue) {
//        Stack<GraphNode> searchStack = new Stack<>();
//        if (rootNode.getNodeValue().equals(nodeValue)) {
//            return rootNode;
//        }
//
//        searchStack.addAll(rootNode.getNodeConnections());
//        while (!searchStack.isEmpty()) {
//            GraphNode currentNode = searchStack.pop();
//            if(currentNode.getNodeValue().equals(nodeValue)) {
//                return currentNode;
//            }
//
//            searchStack.addAll(currentNode.getNodeConnections());
//        }
//
//        return null;
//    }


    @Override
    public GraphNode getGraphNode(Object nodeValue) {
        //TODO implement method
        return null;
    }

    @Override
    public LinkedList<GraphNode> pathBetween(Object startValue, Object endValue) {
        //TODO implement method
        return null;
    }
}
