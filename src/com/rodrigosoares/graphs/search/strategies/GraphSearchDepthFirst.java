package com.rodrigosoares.graphs.search.strategies;

import com.rodrigosoares.graphs.GraphNode;

import java.util.*;

/**
 * This class is the Depth-first search strategy of a graph.
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

    @Override
    public LinkedList<GraphNode> pathBetween(Object startValue, Object endValue) {
        LinkedList<GraphNode> currentPath = new LinkedList<>();
        LinkedList<GraphNode> searchList = new LinkedList<>();
        GraphNode startNode = nodesHashMap.get(startValue);
        GraphNode endNode = nodesHashMap.get(endValue);

        if(startNode == null || endNode == null) {
            return null;
        }

        searchList.add(startNode);
        //While there are nodes to be search, it still looking for a valid path
        while (!searchList.isEmpty()) {
            GraphNode currentNode = searchList.getLast();
            currentNode.setValid(false);
            currentPath.add(currentNode);

            //If the algorithm reach the end node
            if(currentNode.getNodeValue().equals(endNode.getNodeValue())) {
                return currentPath;
            }

            HashSet validConnections = currentNode.getValidNodeConnection();
            //If the current node has no more connections to be added to the search list
            if(validConnections.isEmpty()) {
                removeParentConnections(currentNode, currentPath);
                currentPath.remove(currentNode);
                searchList.removeLast();
            } else {
                //If the current node has connections to be search yet
                searchList.addAll(currentNode.getValidNodeConnection());
            }
        }

        //If there is no connection between the begin and end nodes
        return null;
    }

    /**
     * Removes all parent connections of node. It is useful for clear the current path of leafs that is not in
     * the path between the begin and end nodes of the search.
     * @param node The node to be removed from the parent connections
     * @param currentPath The current path of the search
     */
    private void removeParentConnections(GraphNode node, LinkedList<GraphNode> currentPath) {
        for(GraphNode currentParent : node.getNodeConnections()) {
            HashSet<GraphNode> parentConnections = currentParent.getNodeConnections();
            parentConnections.remove(node);
            if(parentConnections.size() < 2) {
                currentPath.remove(currentParent);
            }
        }
    }

    @Override
    public GraphNode getGraphNode(Object nodeValue) {
        return nodesHashMap.get(nodeValue);
    }

}
