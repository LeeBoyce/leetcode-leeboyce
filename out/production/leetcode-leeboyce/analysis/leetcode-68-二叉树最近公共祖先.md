#### [面试题68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

### 题目

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

<img src="https://gitee.com/leeboyce/imagebed/raw/20200305-image/uPic/leetcode-68-二叉树的最近公共祖先.png" alt="leetcode-68-二叉树的最近公共祖先" style="zoom:50%;" />

 

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。


说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。



### 思路

（1）二叉树问题，先找临界值也就是先找递归出口

（2）临界值，（1）当根节点为空时 （2）当根节点等于q时 （3）当根节点等于p时，其自身就是最近公共祖先

（3）递归问题就是子问题，最小子问题是会出现什么情况？

（4）四种情况： (1)左右节点为空时返回null (2)当左子节点找到p或q时，返回左子节点值 (3)当右子节点找到p或q时，返回右子节点 (4)当左右子节点都找到p或q时，返回当前节点，当前节点就是最近公共祖先



### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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
```

