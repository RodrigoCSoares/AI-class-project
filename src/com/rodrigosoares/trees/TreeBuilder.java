package com.rodrigosoares.trees;

import java.util.*;

/**
 * This class build a tree based on a string that represents a line of connection.
 * This line follows a pattern: First item is a node of the tree and the following items are the connections
 * of that node.
 * The line has a split pattern for the items, normally a "," but it can be any other character
 */
public class TreeBuilder {
    private Collection<TreeNode> treeNodes;
    private TreeNode rootNode;

    /**
     * Constructor
     * @param linesOfConnections An ArrayList of strings with all the lines that represents the tree connections
     * @param splitPattern The split pattern for the items in which line
     */
    public TreeBuilder(ArrayList<String> linesOfConnections, String splitPattern) {
        HashMap<Object, TreeNode> nodesHashMap = initializeAllNodes(linesOfConnections, splitPattern);
        setupNodesConnection(linesOfConnections, nodesHashMap, splitPattern);
        this.treeNodes = nodesHashMap.values();
    }

    /**
     * Initializes all nodes of the tree, reading all lines of connections and adding all nodes into a HashMap
     * @param linesOfConnections An ArrayList of strings with all the lines that represents the tree connections
     * @param splitPattern The split pattern for the items in which line
     * @return The HashMap linking the nodes with the respective node's value
     */
    private HashMap<Object, TreeNode> initializeAllNodes(ArrayList<String> linesOfConnections, String splitPattern) {
        HashMap<Object, TreeNode> readNodes = new HashMap<>();

        for(String line : linesOfConnections) {
            String[] nodeValues = line.split(splitPattern);

            for(String node : nodeValues) {
                if (!readNodes.containsKey(node)) {
                    readNodes.put(node, new TreeNode(node, null));
                }
            }
        }

        return readNodes;
    }

    /**
     * Setup node objects connections between the each other in the HashMap
     * @param linesOfConnections An ArrayList of strings with all the lines that represents the tree connections
     * @param nodesHashMap The HashMap linking the nodes with the respective node's value
     * @param splitPattern The split pattern for the items in which line
     */
    private void setupNodesConnection(ArrayList<String> linesOfConnections, HashMap<Object, TreeNode> nodesHashMap, String splitPattern) {
        this.rootNode = nodesHashMap.get(linesOfConnections.get(0).split(splitPattern)[0]);

        for(String line : linesOfConnections) {
            String[] nodeValues = line.split(splitPattern);
            TreeNode node = nodesHashMap.get(nodeValues[0]);

            for(int i = 1; i < nodeValues.length; i++) {
                node.addNodeConnection(nodesHashMap.get(nodeValues[i]));
            }
        }
    }

    /**
     * Returns the tree nodes
     * @return The tree nodes
     */
    public Collection<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    /**
     * Returns the root of the tree
     * @return The root of the tree
     */
    public TreeNode getRootNode() {
        return rootNode;
    }
}
