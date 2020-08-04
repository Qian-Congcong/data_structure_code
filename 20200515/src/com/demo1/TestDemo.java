package com.demo1;

/**
 * program: 20200515
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-15 21
 * Time:26
 */

public class TestDemo {
    public static void main1(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("最大深度：> ");
        System.out.println(binaryTree.getHeight(root));
    }
}
