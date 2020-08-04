package com.demo1;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * program: 20200515
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-15 20
 * Time:27
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
public class TestMain {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChid(root.left, root.right);
    }

    public boolean isSymmetricChid(TreeNode leftTree, TreeNode rightTree) {
        if ((leftTree != null && rightTree == null) || (leftTree == null && rightTree != null)) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        return isSymmetricChid(leftTree.left, rightTree.right) &&
        isSymmetricChid(leftTree.right, rightTree.left) &&
        (leftTree.val == rightTree.val);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2 && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) {
            return false;
        }
        if (isSameTree(s,t)) {
            return true;
        }
        if (isSubtree(s.left,t)) {
            return true;
        }
        if (isSubtree(s.right,t)) {
            return true;
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else if (p == null || q == null){
            return false;
        }
        if (p.val == q.val ) {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);

        List<Integer> left = preorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        list.addAll(right);
        return list;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }else if (left != null) {
            return left;
        }else {
            return right;
        }
    }
}
