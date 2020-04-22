package tree;

/**
 * @author jianw.li
 * @date 2020/4/15 10:10 AM
 * @Description: 二叉树最近公共祖先
 */
public class T68_LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //临界值，（1）当根节点为空时 （2）当根节点等于q时 （3）当根节点等于p时，其自身就是最近公共祖先
        if(root == null || root == q || root == p){
            return root;
        }

        //左右子树递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //四种情况：
        // (1)左右节点为空时返回null
        // (2)当左子节点找到p或q时，返回左子树查找的结果值
        // (3)当右子节点找到p或q时，返回右子树查找的结果值
        // (4)当左右子树都找到p或q时，返回当前节点，当前节点就是最近公共祖先
        if(left == null && right == null) {
            return null;
        }
        if(left != null && right == null) {
            return left;
        }
        if(right != null && left == null) {
            return right;
        }
        return root;
    }
}
