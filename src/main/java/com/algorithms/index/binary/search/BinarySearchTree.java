package com.algorithms.index.binary.search;



/**
 * @author xuande (xuande@dajiaok.com)
 * @date 2022/4/11  13:35:49
 */
public class BinarySearchTree {

    private TreeNode rootNode;


    public void addNode(TreeNode treeNode){

        // 根节点
        if (rootNode == null){
            rootNode = treeNode;
            return;
        }

        TreeNode parentNode = rootNode;

        while (parentNode != null) {

            if(treeNode.value < parentNode.value){

                if (parentNode.left != null){
                    parentNode = parentNode.left;
                    continue;
                }else {
                    parentNode.left = treeNode;
                    break;
                }
            } else {
              if (parentNode.right != null){
                  parentNode = parentNode.right;
                  continue;
              } else {
                  parentNode.right = treeNode;
                  break;
              }
            }
        }

    }


    /**
     * 节点删除
     * @param treeNode
     * @return
     */
    public boolean delete(TreeNode treeNode){
        if (rootNode== null || treeNode == null){
            return false;
        }

        // 父节点
        TreeNode parentNode = rootNode;

        // 当前待删除的节点
        TreeNode current = rootNode;

        // 当前节点是否左节点
        boolean isLeftNode = false;

        // 查询待删除的节点
        while (!current.value.equals(treeNode.value)){

            if (current.value < treeNode.value){
                current = current.left;
                parentNode = current;
                isLeftNode = true;
            } else {
                current = current.right;
                parentNode = current;
                isLeftNode = false;
            }

            // 无此节点删除失败
            if (current == null){
                return false;
            }
        }

        if (current.left == null && current.right == null){
            // 当前节点为根节点
            if (current == rootNode){
                rootNode = null;
            }else if (isLeftNode){
                parentNode.left = null;
            }else {
                parentNode.right = null;
            }

        }

        // 当前节点下仅有一个左节点
        if (current.left != null && current.right == null){
            // 被删除节点为根节点，将被删除节点的左节点更改为根节点
            if (rootNode == current){
                rootNode = current.left;
            }else if (isLeftNode){
                parentNode.left = current.left;
            }else {
                parentNode.right = current.left;
            }

        }else if (current.left == null && current.right != null){
            // 被删除节点为根节点，将被删除节点的左节点更改为根节点
            if (rootNode == current){
                rootNode = current.right;
            }else if (isLeftNode){
                parentNode.left = current.right;
            }else {
                parentNode.right = current.right;
            }

        }

        TreeNode next = findNext(current);

        // 被删除节点下有两个节点
        if (current.left != null && current.right != null){
            if (rootNode == current){
                rootNode = next;
            }else if (isLeftNode){
                parentNode.left = next;
            }else {
                parentNode.right = next;
            }
        }

        return true;

    }

    /**
     * 查询下一个节点(左树最大节点)
     * 或（右树最小节点）
     * @param deleteNode
     * @return
     */
    public TreeNode findNext(TreeNode deleteNode){

        TreeNode successorParent = deleteNode;

        TreeNode successor = deleteNode;

        TreeNode current = deleteNode.left;

        //寻找左树的最大节点
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.right;
        }



        if (successor != deleteNode.left){
            // 将左树最大节点的左节点连接到其父节点的右节点（保持二叉树平衡）
            successorParent.right = successor.left;
            // 与被删除节点交换位置
            successor.left = deleteNode.left;

            successor.right = deleteNode.right;
        }

        return successor;

    }


    public TreeNode find(TreeNode treeNode){

        if (rootNode == null ) {
            return null;
        }

        TreeNode current = rootNode;

        while (current != null){

            if (treeNode.value.equals(current.value)){
                return current;
            }

            if (treeNode.value < current.value){
                current =  current.left;

                continue;
            }else {
                current = current.right;
                continue;
            }
        }
        return null;

    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(15);




        binarySearchTree.addNode(treeNode);
        binarySearchTree.addNode(treeNode2);
        binarySearchTree.addNode(treeNode3);
        binarySearchTree.addNode(treeNode4);
        binarySearchTree.addNode(treeNode5);

        int maxDeep = binarySearchTree.maxDeep(treeNode);
        System.out.println(maxDeep);

        int i = 0;
    }





    private void showTree(){
        TreeNode current = rootNode;

        int maxDeep = maxDeep(current);

        // 最大叶子节点数量
//        int maxLeafNode = 2 << maxDeep;






    }


    /**
     * 二叉树最大深度
     */
    private int maxDeep(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }

        if (treeNode.left == null && treeNode.right == null){
            return 1;
        }

        int maxLeft = 0;

        int maxRight = 0;

        if(treeNode != null){

            maxLeft = maxDeep(treeNode.left);

            maxRight = maxDeep(treeNode.right);
        }

        return Math.max(maxLeft, maxRight) + 1;

    }



}


class TreeNode{

    public Integer value;

    // 左节点
    public TreeNode left;

    // 右节点
    public TreeNode right;


    public TreeNode(Integer value) {
        this.value = value;
    }
    
}