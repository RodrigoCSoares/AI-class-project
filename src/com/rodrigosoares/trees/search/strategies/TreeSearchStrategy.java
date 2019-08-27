package com.rodrigosoares.trees.search.strategies;

import com.rodrigosoares.trees.TreeNode;

/**
 * This abstract class represents a search strategy for a tree
 */
public abstract class TreeSearchStrategy {

    /**
     * Constructor
     * @param rootNode Root node of the tree
     */
    TreeSearchStrategy(TreeNode rootNode) {
    }

    /**
     * Returns a tree node with the given node value
     * @param nodeValue Node value to be searched
     * @return The tree node with the given node value or null if there is no node
     */
    public abstract TreeNode getTreeNode(Object nodeValue);

    /**
     * Verifies if there is or there is not a node with the given node value
     * @param nodeValue Node value to be searched
     * @return true if there is a node or false if there is not
     */
    public abstract boolean hasTreeNode(Object nodeValue);

    /**
     * Sets the root node of the tree
     * @param rootNode Root node of the tree
     */
    public abstract void setRootNode(TreeNode rootNode);

    /**
     * Returns the root node of the tree
     * @return The root node of the tree
     */
    public abstract TreeNode getRootNode();

}
