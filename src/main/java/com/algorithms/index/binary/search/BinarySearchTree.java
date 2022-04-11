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
                    treeNode.left = parentNode;
                    parentNode.left = treeNode;
                    break;
                }
            } else {
              if (parentNode.right != null){
                  parentNode = parentNode.right;
                  continue;
              } else {
                  treeNode.left = parentNode;
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
     * 查询下一个节点
     * @param deleteNode
     * @return
     */
    public TreeNode findNext(TreeNode deleteNode){

        TreeNode next = deleteNode;

        TreeNode current = deleteNode;

        //寻找左树的最大节点




        return next;

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

        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);


        binarySearchTree.addNode(treeNode);
        binarySearchTree.addNode(treeNode2);
        binarySearchTree.addNode(treeNode3);
        binarySearchTree.addNode(treeNode4);


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