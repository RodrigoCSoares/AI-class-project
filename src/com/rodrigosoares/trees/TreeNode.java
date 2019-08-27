package com.rodrigosoares.trees;

import java.util.ArrayList;

public class TreeNode {
    private String nodeName;
    private ArrayList<TreeNode> nodeConnections;

    public TreeNode(String nodeName, ArrayList<TreeNode> nodeConnections) {
        this.nodeName = nodeName;
        this.nodeConnections = nodeConnections != null ? nodeConnections : new ArrayList<>();
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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
                "nodeName='" + nodeName + '\'' +
                ", nodeConnections=" + nodeConnections +
                '}';
    }
}
