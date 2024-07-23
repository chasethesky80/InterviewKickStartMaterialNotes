package com.ik.algorithms.recursion;

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
     * NOTE: If all keys are in ascending order then time complexity is O(N) where N is number of nodes
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

