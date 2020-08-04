package com.demo1;

import java.util.*;

/**
 * program: 20200515
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-15 19
 * Time:45
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class BinaryTree {

    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    // 前序遍历
    void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root) {
        if (root == null) {
            return;
        }
        //System.out.println(root.val + " ");
        size ++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root == null) {
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }else {
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
           return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }
    // 获取二叉树的高度
    int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, char val) {
        if (root == null) {
            return null;
        }
        //1、判断根节点是否是查找的数字val
        if(root.val == val) {
            return root;
        }
        //2、左边
        Node leftfind = find(root.left, val);
        //  递归--》左边全部递归完成后-》返回值是否是空
        if (leftfind != null) {
            return leftfind;
        }
        //3、右边
        Node rightfind = find(root.right, val);
        if (rightfind != null) {
            return rightfind;
        }
        return null;
    }

    // 层序遍历
    void levelOrderTraversal(Node root){
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                System.out.println(cur.val +" ");

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //1、求当前队列的大小  size
            int size = queue.size();
            //2、while(size > 0)  -->控制当前每一层的数据个数
            List<Integer> listRow = new ArrayList<>();
            while (size > 0) {
                Node cur = queue.poll();
                listRow.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(listRow);
        }

        return ret;
    }

    //判断一棵树是不是完全二叉树
    boolean isCompletlTree(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        //看一下 队列里面是否都是空
        while (!queue.isEmpty()) {
            Node cur2 = queue.peek();
            if(cur2 != null) {
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }

    // 中序遍历
    void inOrderTraversalNor(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    // 后序遍历
    void postOrderTraversalNor(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                System.out.print(cur.val+" ");
                stack.pop();
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        System.out.println();
    }
}
