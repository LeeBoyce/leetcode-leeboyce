package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianw.li
 * @date 2019/10/5 10:28 AM
 * @Description:
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static Map<Integer ,List<Integer>> levelsMap = new HashMap<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        traversalList(root, 0);
        List<List<Integer>> levelsResList = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry : levelsMap.entrySet()){
            List<Integer> nodeList = entry.getValue();
            levelsResList.add(nodeList);
        }
        return levelsResList;
    }

    public static void traversalList(TreeNode root, Integer level){
        if(root == null){
            return;
        }
        if(levelsMap.size() > level){
            List<Integer> levelNodes = levelsMap.get(level);
            levelNodes.add(root.val);
            levelsMap.put(level, levelNodes);
        }
        if(levelsMap.size() == level){
            List<Integer> levelNodes = new ArrayList<>();
            levelNodes.add(root.val);
            levelsMap.put(level, levelNodes);
        }

        traversalList(root.left, level + 1);
        traversalList(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;
        levelOrder(node1);

    }
}
