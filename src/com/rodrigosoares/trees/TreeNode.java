package com.rodrigosoares.trees;

import java.util.ArrayList;

/**
 * This class represents a node of the a tree
 */
public class TreeNode {
    private Object nodeValue;
    private ArrayList<TreeNode> nodeConnections;

    /**
     * Constructor
     * @param nodeValue Node's value
     * @param nodeConnections Connections of the node
     */
    public TreeNode(Object nodeValue, ArrayList<TreeNode> nodeConnections) {
        this.nodeValue = nodeValue;
        this.nodeConnections = nodeConnections != null ? nodeConnections : new ArrayList<>();
    }

    /**
     * Returns the node's value
     * @return Node's value
     */
    public Object getNodeValue() {
        return nodeValue;
    }

    /**
     * Set node's value
     * @param nodeValue Node's value
     */
    public void setNodeValue(Object nodeValue) {
        this.nodeValue = nodeValue;
    }

    /**
     * Get node's connection
     * @return Node's connection
     */
    public ArrayList<TreeNode> getNodeConnections() {
        return nodeConnections;
    }

    /**
     * Set node's connection
     * @param nodeConnections Node's connection
     */
    public void setNodeConnections(ArrayList<TreeNode> nodeConnections) {
        this.nodeConnections = nodeConnections;
    }

    /**
     * Adds a single node connection
     * @param node Node's connection
     */
    public void addNodeConnection(TreeNode node) {
        this.nodeConnections.add(node);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "nodeName='" + nodeValue.toString() + '\'' +
                ", nodeConnections=" + nodeConnections +
                '}';
    }
}
