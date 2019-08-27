package com.rodrigosoares.trees;

import java.util.ArrayList;

public class TreeNode {
    private Object nodeValue;
    private ArrayList<TreeNode> nodeConnections;

    public TreeNode(Object nodeName, ArrayList<TreeNode> nodeConnections) {
        this.nodeValue = nodeName;
        this.nodeConnections = nodeConnections != null ? nodeConnections : new ArrayList<>();
    }

    public Object getNodeValue() {
        return nodeValue;
    }

    public void getNodeValue(Object nodeValue) {
        this.nodeValue = nodeValue;
    }

    public ArrayList<TreeNode> getNodeConnections() {
        return nodeConnections;
    }

    public void setNodeConnections(ArrayList<TreeNode> nodeConnections) {
        this.nodeConnections = nodeConnections;
    }

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
