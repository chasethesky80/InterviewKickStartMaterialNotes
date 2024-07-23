package com.ik.algorithms.recursion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BinaryTreeNode {
    public Integer value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
}
