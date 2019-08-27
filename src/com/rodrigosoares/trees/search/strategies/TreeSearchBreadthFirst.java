package com.rodrigosoares.trees.search.strategies;

import com.rodrigosoares.trees.TreeNode;

import java.util.ArrayList;

public class TreeSearchBreadthFirst extends TreeSearchStrategy {
    private TreeNode rootNode;

    public TreeSearchBreadthFirst(TreeNode rootNode) {
        super(rootNode);
        this.rootNode = rootNode;
    }

    @Override
    public TreeNode getTreeNode(Object nodeValue) {
        if (rootNode.getNodeValue().equals(nodeValue)) {
            return rootNode;
        }

        ArrayList<TreeNode> searchList = new ArrayList<>(rootNode.getNodeConnections());
        while (!searchList.isEmpty()) {
            TreeNode currentNode = searchList.remove(0);
            if(currentNode.getNodeValue().equals(nodeValue)) {
                return currentNode;
            }

            searchList.addAll(currentNode.getNodeConnections());
        }

        return null;
    }

    @Override
    public boolean hasTreeNode(Object nodeValue) {
        return getTreeNode(nodeValue) != null;
    }

    @Override
    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public TreeNode getRootNode() {
        return rootNode;
    }
}
