//package com.ik.algorithms.recursion;
//
//public class TreeTraversalAlgorithms {
//
//// Initialize an empty result array
//// Handle an empty tree as a special edge case
//
//// Create an empty queue and push the root of the tree into it.
//
//// While the queue is not empty:
//    // Count the number of nodes in the Queue
//    // Repeat that many times:
//
//    // Remove the next node from the front of the Queue
//    // Append the value to the result array
//
//    // If it has a left child, add the left child to the queue
//    // If it has a right child, add the right child to the queue
//    List<List<Integer>> function getLevelOrder(TreeNode root){
//
//        List<List<Integer>> result = new List()
//        if(root is null) return result
//
//        Queue<TreeNode> nodeQueue = new Queue()
//
//        nodeQueue.add(root)
//
//        while(nodeQueue is not empty){
//
//            int count = nodeQueue.size()
//            List<Integer> temp  = new List()
//
//            for(int i = 0; i < count; i++){
//
//                TreeNode node = nodeQueue.dequeue()
//
//                temp.add(node.val)
//
//                if(node.left is not null) nodeQueue.enqueue(node.left)
//                if(node.right is not null) nodeQueue.enqueue(node.right)
//
//            }
//            result.add(temp)
//        }
//        return result
//
//    }
//
//    List<List<Integer>> function getNaryLevelOrder(Node root){
//
//        List<List<Integer>> result = new List()
//        if(root is null) return result
//
//        Queue<Node> nodeQueue = new Queue()
//
//        nodeQueue.add(root)
//
//        while(nodeQueue is not empty){
//
//            int count = nodeQueue.size()
//            List<Integer> temp  = new List()
//
//            for(int i = 0; i < count; i++){
//
//                Node node = nodeQueue.dequeue()
//
//                temp.add(node.val)
//
//                foreach (child in node.children) {
//                    nodeQueue.enqueue(child)
//                }
//
//            }
//            result.add(temp)
//        }
//        return result
//
//    }
//
//    List<List<Integer>> function getZigZagLevelOrder(TreeNode root){
//
//        List<List<Integer>> result = new List()
//        if(root is null) return result
//
//        Queue<TreeNode> nodeQueue = new Queue()
//
//        nodeQueue.add(root)
//
//        boolean leftToRight = true
//
//        while(nodeQueue is not empty){
//
//            int count = nodeQueue.size()
//            List<Integer> temp  = new List(count)
//
//            for(int i = 0; i < count; i++){
//
//                int idx = i
//
//                if(not leftToRight) idx = count - 1 - i
//
//                TreeNode node = nodeQueue.dequeue()
//
//                temp[idx] = node.val
//
//                if(node.left is not null) nodeQueue.enqueue(node.left)
//                if(node.right is not null) nodeQueue.enqueue(node.right)
//
//            }
//
//            /// if(not leftToRight) temp.reverse()
//
//            result.add(temp)
//
//            leftToRight = not leftToRight
//        }
//        return result
//
//    }
//
//    List<Integer>function getRightSideView(TreeNode root){
//
//        List<Integer> result = new List()
//        if(root is null) return result
//
//        Queue<TreeNode> nodeQueue = new Queue()
//
//        nodeQueue.add(root)
//
//        while(nodeQueue is not empty){
//
//            int count = nodeQueue.size()
//
//            for(int i = 0; i < count; i++){
//
//                TreeNode node = nodeQueue.dequeue()
//
//                if(i == count-1) result.add(node.val)
//
//                if(node.left is not null) nodeQueue.enqueue(node.left)
//                if(node.right is not null) nodeQueue.enqueue(node.right)
//
//            }
//        }
//        return result
//
//    }
//
//    List<List<Integer>> function getBottomUpLevelOrder(TreeNode root){
//
//        List<List<Integer>> result = new List()
//        if(root is null) return result
//
//        Queue<TreeNode> nodeQueue = new Queue()
//
//        nodeQueue.add(root)
//
//        while(nodeQueue is not empty){
//
//            int count = nodeQueue.size()
//            List<Integer> temp  = new List()
//
//            for(int i = 0; i < count; i++){
//
//                TreeNode node = nodeQueue.dequeue()
//
//                temp.add(node.val)
//
//                if(node.left is not null) nodeQueue.enqueue(node.left)
//                if(node.right is not null) nodeQueue.enqueue(node.right)
//
//            }
//            result.add(temp)
//        }
//        return result.reverse()
//
//    }
//
//------------------------------------------------------------------
//    Boundary Walk (Depth-first, Recursion)
//
//// Handle an empty tree as a special edge case
//
//// Create a recursive function to execute on every node.
//// Function: dfs(node)
//    // Base Case: If Leaf Node, then do something if necessary.
//    // Recursive Case: (Not a leaf node)
//
//    // Pre-Order: Process info before visiting either child
//
//    // add value to preorder array
//
//    // If the node has a LEFT child:  dfs(node.left)
//
//    // In-Order : Process the information in sequence
//
//    // add value to inorder array
//
//    // If the node has a RIGHT child: dfs(node.right)
//
//    // add value to postorder array
//
//    // Post-Order: Process the information after both
//    children have been visited
//
//-------------------------------------------------------------
//    Top Down Depth-First
//
//    Flow of information travels from ROOT to LEAF
//
//// Handle an empty tree as a special edge case
//    (return empty result array)
//
//// Create a recursive function to execute on every node.
//
//// Function: topDownDFS ( node, information to be passed down)
//    // Process information passed down (Pre-Order)
//
//    // Base Case: If Leaf Node, then do something if necessary.
//
//    // Recursive Case: (Not a leaf node)
//    // If the node has a LEFT child:  topDownDFS(node.left, info)
//    // If the node has a RIGHT child: topDownDFS(node.right, info)
//
//    // Likely returns nothing back to the parent
//
//
//    boolean function hasPathSum(TreeNode root, int target){
//
//        boolean hasSum = false
//
//        if(root is null) return hasSum
//
//
//
//        function helper(TreeNode node, int sum){
//
//            if(hasSum) return // backtracking
//
//            if(node.left is null and node.right is null){ // leaf
//                if(sum == node.val) hasSum = true
//                return
//            }
//
//            sum = sum - node.val
//
//            if(node.left is not null) helper(node.left, sum)
//
//            if(node.right is not null) helper(node.right, sum)
//
//
//        }
//
//        helper(root, target)
//        return hasSum
//
//    }
//    List<List<Integer>> function getSumPaths(TreeNode root, int target){
//
//        List<List<Integer>> result = new List()
//
//        if(root is null) return result
//
//        function helper(TreeNode node, int sum, List<Integer> slate){
//
//            slate.add(node.val)
//
//            if(node.left is null and node.right is null){ // leaf
//                if(sum == node.val) {
//                    result.add(slate.copy())
//                }
//                slate.pop()
//                return
//            }
//
//            sum = sum - node.val
//
//            if(node.left is not null) helper(node.left, sum)
//            if(node.right is not null) helper(node.right, sum)
//
//            slate.pop()
//        }
//
//        helper(root, target,  new List<Integer>)
//        return result
//
//    }
//
//--------------------------------------------------------------
//    Bottom-Up Depth First
//
//    Flow of information travels from LEAF to ROOT
//
//// Handle an empty tree as a special edge case
//    (return empty result array)
//
//// Create a recursive function to execute on every node.
//// Function: bottomUpDFS ( node )
//
//    // Base Case: (Leaf Node) Return required data back to the
//    parent for processing.
//
//            // Recursive Case: (Not a leaf node)
//            // If the node has a LEFT child:
//            resultLeft = bottomUpDfs(node.left)
//
//    // If the node has a RIGHT child:
//    resultRight = bottomUpDfs(node.right)
//
//    // Process information sent back by child nodes (Post-Order)
//    // Returns information back to the parent
//
//    int function getTreeDiameter(TreeNode root){
//
//        int diameter = 0
//
//        int function howManyEdges(TreeNode node){
//
//            if(node.left == null and node.right == null) return 0
//
//            int leftEdges = 0
//            int rightEdges = 0
//
//
//            if(node.left is not null){
//                leftEdges = howManyEdges(node.left) + 1
//            }
//
//            if(node.right is not null){
//                rightEdges = howManyEdges(node.right) + 1
//            }
//
//            int myDiameter = leftEdges + rightEdges
//
//            diameter = myDiameter if(myDiameter > diameter) else diameter
//
//            return Math.max(leftEdges, rightEdges)
//        }
//
//        howManyEdges(root)
//        return diameter
//    }
//
//
//    int function getTreeDiameter(TreeNode root){
//
//        int diameter = 0
//
//        int function howManyEdges(TreeNode node){
//
//            if(node.left == null and node.right == null) return 0
//
//            int leftEdges = 0
//            int rightEdges = 0
//
//
//            if(node.left is not null){
//                leftEdges = howManyEdges(node.left) + 1
//            }
//
//            if(node.right is not null){
//                rightEdges = howManyEdges(node.right) + 1
//            }
//
//            int myDiameter = leftEdges + rightEdges
//
//            diameter = myDiameter if(myDiameter > diameter) else diameter
//
//            return Math.max(leftEdges, rightEdges)
//        }
//
//        howManyEdges(root)
//        return diameter
//    }
//
//    int function getUnivalueSubtrees(TreeNode root){
//        if(root is null) return 0
//
//        int univalCount = 0
//
//        boolean function isUnival(TreeNode node){
//
//            if(node.left is null and node.right is null){
//                univalCount++
//                return true
//            }
//
//            boolean allUnival = true
//
//            if(node.left is not null){
//                allUnival = isUnival(node.left)
//                and (node.val == node.left.val )
//
//            }
//            if(node.right is not null){
//                allUnival = isUnival(node.right)
//                and (node.val == node.right.val)
//                and allUnival
//            }
//
//            if(allUnival) univalCount++
//
//            return allUnival
//        }
//
//        isUnival(root)
//        return univalCount
//    }
//
//
//
//------------------------------------------------------------------
//    Tree Construction
//
//    Divide and Conquer
//
//    // Repeat for each node makeNode(array, start, end) and return a TreeNode.
//    // if the start value is greater than the
//    end value, return nothing (Null)
//
//    // if the start value is equal to the end value,
//       return a new tree node with the value array[start]
//
//    // else, build the subtrees:
//
//    // Identify the sub-tree root node value and
//    root_index in the array
//
//    // Create a new node with value array[root_index]
//
//    // Identify the start and end position of
//    the left subtree in the array.
//
//    // Identify the start and end position of
//    the right subtree in the array.
//
//    // Recursive:
//    // Set the node.left = makeNode(array, leftStart, leftEnd)
//    // Set the node.right = makeNode(array, rightStart, rightEnd)
//
//    // return the subtree node.
//
//
//    TreeNode function arrayToBst(int[] sortedArr){
//
//        TreeNode function makeTree(int[] sortedArray, int s, int e){
//
//            if(s > e) return null
//
//            if(s == e) return new TreeNode(sortedArr[s])
//
//
//            int mid = s + (e-s) / 2
//
//            TreeNode root = new TreeNode(sortedArr[mid])
//
//            root.left = makeTree(sortedArr, s, mid-1)
//            root.right = makeTree(sortedArr, mid+1, e)
//
//            return root
//
//        }
//
//        return makeTree(sortedArr, 0, sortedArr.length-1)
//
//    }
//    TreeNode function arraysToBt(int[] preorder, int[] inorder){
//
//        Map<Integer, Integer> ioMap = new Map()
//
//        for(int i=0; i<inorder.length; i++){
//
//            ioMap.put(inorder[i], i)
//        }
//
//        TreeNode function makeTree(int[] preorder, int pos, int poe
//        int[] inorder, int ios, int ioe){
//
//            if(pos > poe) return null
//
//            if(pos == poe) return new TreeNode(preorder[pos])
//
//
//            int rootIndex = ioMap.get(preorder[pos]) // O(N)
//
//            ///
//
//            int count = rootIndex - ios
//
//            TreeNode root = new TreeNode(preorder[pos])
//
//            root.left = makeTree(preorder, pos+1, pos+count,
//                    inorder, ios, rootIndex-1)
//            root.right = makeTree(preorder, pos+count+1, poe,
//                    inorder, rootIndex+1, ioe)
//
//            return root
//
//        }
//
//        return makeTree(preorder, 0, preorder.length-1,
//                inorder, 0, inorder.length-1)
//
//    }
//
//
//
//}
