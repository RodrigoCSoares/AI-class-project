package com.rodrigosoares.trees.search.strategies;

import com.rodrigosoares.trees.TreeNode;

public class TreeSearchBreadthFirst extends TreeSearchStrategy {
    private TreeNode rootNode;

    public TreeSearchBreadthFirst(TreeNode rootNode) {
        super(rootNode);
        this.rootNode = rootNode;
    }

    @Override
    public TreeNode getTreeNode(Object nodeValue) {
        return null;
    }

    @Override
    public boolean hasTreeNode(Object nodeValue) {
        return false;
    }

    @Override
    public void setRootNode(TreeNode rootNode) {

    }

    @Override
    public TreeNode getRootNode() {
        return null;
    }
}
