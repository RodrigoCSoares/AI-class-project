package com.rodrigosoares.graphs;

import java.util.*;

/**
 * This class build a graph
 * based on a string that represents a line of connection.
 * This line follows a pattern: First item is a node of the graph
 * and the following items are the connections
 * of that node.
 * The line has a split pattern for the items, normally a "," but it can be any other character
 */
public class GraphBuilder {
    private Collection<GraphNode> graphNodes;
    private GraphNode rootNode;

    /**
     * Constructor
     * @param linesOfConnections An ArrayList of strings with all the lines that represents the graph
     *                          connections
     * @param splitPattern The split pattern for the items in which line
     */
    public GraphBuilder(ArrayList<String> linesOfConnections, String splitPattern) {
        HashMap<Object, GraphNode> nodesHashMap = initializeAllNodes(linesOfConnections, splitPattern);
        setupNodesConnection(linesOfConnections, nodesHashMap, splitPattern);
        this.graphNodes = nodesHashMap.values();
    }

    /**
     * Initializes all nodes of the graph
     * , reading all lines of connections and adding all nodes into a HashMap
     * @param linesOfConnections An ArrayList of strings with all the lines that represents the graph
     *                          connections
     * @param splitPattern The split pattern for the items in which line
     * @return The HashMap linking the nodes with the respective node's value
     */
    private HashMap<Object, GraphNode> initializeAllNodes(ArrayList<String> linesOfConnections, String splitPattern) {
        HashMap<Object, GraphNode> readNodes = new HashMap<>();

        for(String line : linesOfConnections) {
            String[] nodeValues = line.split(splitPattern);

            for(String node : nodeValues) {
                if (!readNodes.containsKey(node)) {
                    readNodes.put(node, new GraphNode(node, null));
                }
            }
        }

        return readNodes;
    }

    /**
     * Setup node objects connections between the each other in the HashMap
     * @param linesOfConnections An ArrayList of strings with all the lines that represents the graph
     *                          connections
     * @param nodesHashMap The HashMap linking the nodes with the respective node's value
     * @param splitPattern The split pattern for the items in which line
     */
    private void setupNodesConnection(ArrayList<String> linesOfConnections, HashMap<Object, GraphNode> nodesHashMap, String splitPattern) {
        this.rootNode = nodesHashMap.get(linesOfConnections.get(0).split(splitPattern)[0]);

        for(String line : linesOfConnections) {
            String[] nodeValues = line.split(splitPattern);
            GraphNode node = nodesHashMap.get(nodeValues[0]);

            for(int i = 1; i < nodeValues.length; i++) {
                node.addNodeConnection(nodesHashMap.get(nodeValues[i]));
            }
        }
    }

    /**
     * Returns the graph
     * nodes
     * @return The graph
     * nodes
     */
    public Collection<GraphNode> getGraphNodes() {
        return graphNodes;
    }

    /**
     * Returns the root of the graph
     *
     * @return The root of the graph
     *
     */
    public GraphNode getRootNode() {
        return rootNode;
    }
}
