package tree;

/**
 * @author jianw.li
 * @date 2020/4/13 9:18 PM
 * @Description: 从前序与中序遍历序列构造二叉树
 */
public class T105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        int index = 0;
        TreeNode root = new TreeNode(preorder[pStart]);
        for (int i = iStart; i <= iEnd; i++) {
            if (preorder[pStart] == inorder[i]) {
                index = i - iStart;
            }
        }
        /**while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }**/

        root.left = buildTree(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        root.right = buildTree(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return root;
    }

    public static TreeNode buildTree1(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        int index = 0;
        TreeNode root = new TreeNode(preorder[pStart]);
        for (int i = iStart; i <= iEnd; i++) {
            if (preorder[pStart] == inorder[i]) {
                index = i;
            }
        }
        //左子树节点个数,这是重点。左子树节点个数目的在于确定preorder的右区间。原理：前序是根左右，根往后数index - iStart是左子树，加一个必然就是右子树
        int leftNum = index - iStart;
        // [3,9,20,15,7]
        // [9,3,15,20,7]
        root.left = buildTree1(preorder, pStart + 1, pStart + leftNum, inorder, iStart,  index - 1);
        root.right = buildTree1(preorder, pStart + leftNum + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2};
        int[] in = {2,1};
        buildTree(pre, in);
    }
}
