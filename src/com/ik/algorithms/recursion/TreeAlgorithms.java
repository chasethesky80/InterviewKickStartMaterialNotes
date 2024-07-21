package com.ik.algorithms.recursion;

import javax.swing.tree.TreeNode;

public class TreeAlgorithms {

    private BinaryTreeNode search(final BinaryTreeNode root, final int key) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode current = root;
        while (current != null) {
            if (key == current.value) {
                return current;
            } else if (key < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    private BinaryTreeNode getSuccessor(final BinaryTreeNode root, final BinaryTreeNode node) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode right = node.right;
        /**
         * Returning the minimum element in right sub tree if value has a right sub tree
         */
        if (right != null) {
            BinaryTreeNode curr = right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        BinaryTreeNode curr = root;
        BinaryTreeNode ancestor = null;
        while (curr != null) {
            if (curr.value.equals(node.value)) {
                return ancestor;
            }
            else if (curr.value < node.value) {
                ancestor = curr;
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        return null;
    }
}

