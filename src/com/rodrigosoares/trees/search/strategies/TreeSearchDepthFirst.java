package com.rodrigosoares.trees.search.strategies;

import com.rodrigosoares.trees.TreeNode;

public class TreeSearchDepthFirst extends TreeSearchStrategy {
    private TreeNode rootNode;

    public TreeSearchDepthFirst(TreeNode rootNode) {
        super(rootNode);
        this.rootNode = rootNode;
    }

    @Override
    public TreeNode getTreeNode(Object nodeValue) {
        return null;
    }

    @Override
    public void setRootNode(TreeNode rootNode) {

    }

    @Override
    public TreeNode getRootNode() {
        return null;
    }
}
