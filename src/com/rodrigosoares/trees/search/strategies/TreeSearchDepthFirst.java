package com.rodrigosoares.trees.search.strategies;

import com.rodrigosoares.trees.TreeNode;

import java.util.Stack;

/**
 * This class is the Depth-first search strategy of a tree.
 * It searches the value going deeper and deeper into the nodes before changing to a same-level node.
 */
public class TreeSearchDepthFirst extends TreeSearchStrategy {
    private TreeNode rootNode;

    /**
     * Constructor
     * @param rootNode Root node of the tree
     */
    public TreeSearchDepthFirst(TreeNode rootNode) {
        super(rootNode);
        this.rootNode = rootNode;
    }

    @Override
    public TreeNode getTreeNode(Object nodeValue) {
        Stack<TreeNode> searchStack = new Stack<>();
        if (rootNode.getNodeValue().equals(nodeValue)) {
            return rootNode;
        }

        searchStack.addAll(rootNode.getNodeConnections());
        while (!searchStack.isEmpty()) {
            TreeNode currentNode = searchStack.pop();
            if(currentNode.getNodeValue().equals(nodeValue)) {
                return currentNode;
            }

            searchStack.addAll(currentNode.getNodeConnections());
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
