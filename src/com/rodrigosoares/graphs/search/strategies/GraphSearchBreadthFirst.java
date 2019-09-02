package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.*;

/**
 * This class is the Breadth-first search strategy of a graph.
 * It start searching in the nearest connections between the nodes, level by level.
 */
public class GraphSearchBreadthFirst extends GraphSearchStrategy {
    private HashMap<Object, GraphNode> nodesHashMap;

    /**
     * Constructor
     * @param nodesHashMap Graph nodes hash map
     */
    public GraphSearchBreadthFirst(HashMap<Object, GraphNode> nodesHashMap) {
        super(nodesHashMap);
        this.nodesHashMap = nodesHashMap;
    }

//    @Override
//    public GraphNode getGraphNode(Object nodeValue) {
//        if (rootNode.getNodeValue().equals(nodeValue)) {
//            return rootNode;
//        }
//
//        ArrayList<GraphNode> searchList = new ArrayList<>(rootNode.getNodeConnections());
//        while (!searchList.isEmpty()) {
//            GraphNode currentNode = searchList.remove(0);
//            if(currentNode.getNodeValue().equals(nodeValue)) {
//                return currentNode;
//            }
//
//            searchList.addAll(currentNode.getNodeConnections());
//        }
//
//        return null;
//    }

    @Override
    public LinkedList<GraphNode> pathBetween(Object startValue, Object endValue) {
        //TODO implement a new list to save the currentPath
        LinkedList<GraphNode> searchList = new LinkedList<>();
        GraphNode startNode = nodesHashMap.get(startValue);
        GraphNode endNode = nodesHashMap.get(endValue);

        if(startNode == null || endNode == null) {
            return null;
        }

        searchList.add(startNode);
        while (!searchList.isEmpty()) {
            GraphNode currentNode = searchList.getLast();
            currentNode.setValid(false);
            if(currentNode.getNodeValue().equals(endNode.getNodeValue())) {
                return getOnlyCurrentPath(searchList);
            }

            HashSet validConnections = currentNode.getValidNodeConnection();
            if(validConnections.isEmpty()) {
                searchList.removeLast();
            } else {
                searchList.addAll(currentNode.getValidNodeConnection());
            }
        }
        return null;
    }

    @Override
    public GraphNode getGraphNode(Object nodeValue) {
        return nodesHashMap.get(nodeValue);
    }

    private LinkedList<GraphNode> getOnlyCurrentPath(LinkedList<GraphNode> path) {
        LinkedList<GraphNode> clone = new LinkedList<>(path);
        for (GraphNode node : path) {
            if(!node.isOnTheCurrentPath()) {
                clone.remove(node);
            }
        }
        return clone;
    }
}
