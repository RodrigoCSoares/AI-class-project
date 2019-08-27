package com.rodrigosoares.trees.search.strategies;

import com.rodrigosoares.trees.TreeNode;


public abstract class TreeSearchStrategy {

    TreeSearchStrategy(TreeNode rootNode) {
    }

    public abstract TreeNode getTreeNode(Object nodeValue);

    public abstract void setRootNode(TreeNode rootNode);

    public abstract TreeNode getRootNode();

}
