package com.rodrigosoares.trees.search;

import com.rodrigosoares.trees.TreeNode;
import com.rodrigosoares.trees.search.strategies.TreeSearchStrategy;

/**
 * This class search for a specific node of a tree using some search strategy
 */
public class TreeSearcher {
    private TreeSearchStrategy searchStrategy;

    /**
     * Constructor
     * @param searchStrategy Search strategy to be used
     */
    public TreeSearcher(TreeSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    /**
     * Search for a tree node with the given node value
     * @param nodeValue Node value to be searched
     * @return A tree node with the given node value or null if there is no tree node with that value
     */
    public TreeNode getTreeNode(Object nodeValue) {
        return searchStrategy.getTreeNode(nodeValue);
    }

    /**
     * Verifies if there is or there is not a node with a given node value
     * @param nodeValue Node value to be searched
     * @return true if there is a node or false if there is not
     */
    public boolean hasTreeNode(Object nodeValue) {
        return searchStrategy.hasTreeNode(nodeValue);
    }
}
