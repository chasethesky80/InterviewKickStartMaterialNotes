package com.ik.algorithms.recursion;

import java.util.Objects;

public class TreeAlgorithms {

    /**
     * TC = O(logN) - height of tree and SC = O(1)
     * @param root
     * @param key
     * @return
     */
    private BinaryTreeNode searchIterative(final BinaryTreeNode root, final int key) {
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

    private BinaryTreeNode searchRecursive(final BinaryTreeNode root, final int key) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }
        BinaryTreeNode current = root;
        if (current.value == key) {
            return current;
        } else if (key < current.value) {
            searchRecursive(current.left, key);
        } else {
            searchRecursive(current.right, key);
        }
        return null;
    }

    /**
     * TC = O(logN) - height of tree and SC = O(1) for balanced tree
     * NOTE: If all keys are in ascending order then time complexity is O(N) where N is number of nodes like (1, 2, 3, 4, ....N)
     * @param root
     * @param key
     * @return
     */
    private BinaryTreeNode insert(final BinaryTreeNode root, final int key) throws Exception {
        if (root == null) {
            return null;
        }
        BinaryTreeNode current = root, prev = null, newNode = BinaryTreeNode.builder().value(key).build();
        while (current != null) {
            if (key == current.value) {
                throw new Exception("NODE ALREADY EXISTS");
            }
            if (key < current.value) {
                prev = current;
                current = current.left;
            } else {
                prev = current;
                current = current.right;
            }
        }
        if (key > prev.value) {
            prev.right = newNode;
        } else if (key < prev.value) {
            prev.left = newNode;
        }
        return newNode;
    }

    /**
     * TC = O(logN) for a balanced binary tree
     * @param root
     * @return
     */
    private BinaryTreeNode findMinimumInBST(final BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * TC = O(logN) for a balanced binary tree as it is height of the tree
     * @param root
     * @return
     */
    private BinaryTreeNode findMaximumInBST(final BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
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
        /**
         * Record the ancestor making the first left turn till we reach the node we want to find ancestor for
         */
        while (!Objects.equals(curr.value, node.value)) {
            if (node.value < curr.value) {
                ancestor = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ancestor;
    }
}

