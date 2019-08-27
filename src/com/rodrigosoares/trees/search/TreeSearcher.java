package com.rodrigosoares.trees.search;

import com.rodrigosoares.trees.TreeNode;
import com.rodrigosoares.trees.search.strategies.TreeSearchStrategy;

public class TreeSearcher {
    private TreeSearchStrategy searchStrategy;

    public TreeSearcher(TreeSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public TreeNode getTreeNode(Object nodeValue) {
        return searchStrategy.getTreeNode(nodeValue);
    }
}
