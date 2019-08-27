package com.rodrigosoares.trees;

import java.util.*;

public class TreeBuilder {
    private Collection<TreeNode> treeNodes;
    private TreeNode rootNode;

    public TreeBuilder(ArrayList<String> linesOfConnections, String splitPattern) {
        HashMap<String, TreeNode> nodesHashMap = initializeAllNodes(linesOfConnections, splitPattern);
        setupNodesConnection(linesOfConnections, nodesHashMap, splitPattern);
        this.treeNodes = nodesHashMap.values();
    }

    private HashMap<String, TreeNode> initializeAllNodes(ArrayList<String> linesOfConnections, String splitPattern) {
        HashMap<String, TreeNode> readNodes = new HashMap<>();

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

    private void setupNodesConnection(ArrayList<String> linesOfConnections, HashMap<String, TreeNode> nodesHashMap, String splitPattern) {
        this.rootNode = nodesHashMap.get(linesOfConnections.get(0).split(splitPattern)[0]);

        for(String line : linesOfConnections) {
            String[] nodeValues = line.split(splitPattern);
            TreeNode node = nodesHashMap.get(nodeValues[0]);

            for(int i = 1; i < nodeValues.length; i++) {
                node.addNodeConnection(nodesHashMap.get(nodeValues[i]));
            }
        }
    }

    public Collection<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    public TreeNode getRootNode() {
        return rootNode;
    }
}
