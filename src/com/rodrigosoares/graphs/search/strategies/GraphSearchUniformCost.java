package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.*;

public class GraphSearchUniformCost extends GraphSearchStrategy {
    private HashMap<Object, GraphNode> nodesHashMap;

    public GraphSearchUniformCost(HashMap<Object, GraphNode> nodesHashMap) {
        super(nodesHashMap);
        this.nodesHashMap = nodesHashMap;
    }

    @Override
    public GraphNode getGraphNode(Object nodeValue) {
        return nodesHashMap.get(nodeValue);
    }

    @Override
    public LinkedList<GraphNode> pathBetween(Object startValue, Object endValue) {
        LinkedList<GraphNode> currentPath = new LinkedList<>();
        LinkedList<GraphNode> searchList = new LinkedList<>();
        GraphNode startNode = nodesHashMap.get(startValue);
        GraphNode endNode = nodesHashMap.get(endValue);

        if (startNode == null || endNode == null) {
            return null;
        }

        searchList.add(startNode);
        //While there are nodes to be search, it still looking for a valid path
        while (!searchList.isEmpty()) {
            GraphNode currentNode = searchList.getLast();
            currentNode.setValid(false);
            currentPath.add(currentNode);

            //If the algorithm reach the end node
            if (currentNode.getNodeValue().equals(endNode.getNodeValue())) {
                return super.traversePath(currentPath);
            }

            HashSet validConnections = currentNode.getValidNodeConnections();
            //If the current node has no more connections to be added to the search list
            if (validConnections.isEmpty()) {
                currentPath.remove(currentNode);
                searchList.removeLast();
            } else {
                //If the current node has connections to be search yet, insert in weight order
                Map<GraphNode, Integer> test = currentNode.getValidNodeConnectionsWeightOrder();
                searchList.addAll(test.keySet());
            }
        }

        //If there is no connection between the begin and end nodes
        return currentPath;
    }
}
