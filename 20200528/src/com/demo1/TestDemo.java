package com.demo1;

/**
 * program: 20200528
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-28 20
 * Time:22
 */
public class TestDemo {
    public static void main(String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("fdie"));
    }
    public static void main2(String[] args) {
        int i = 0;
        Integer j = new Integer(0);
        System.out.println(i == j);
        System.out.println(j.equals(i));
    }
    public static void main1(String[] args) {
        BSTree bsTree = new BSTree();
        int[] array = {7,2,9,18,56,15,3};
        for (int i : array) {
            bsTree.insert(i);
        }
        bsTree.preOrder(bsTree.root);
        System.out.println(bsTree);
        bsTree.inOrder(bsTree.root);
    }
}
