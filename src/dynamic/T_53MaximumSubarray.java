package dynamic;

/**
 * @author jianw.li
 * @date 2020/4/22 11:27 PM
 * @Description:
 *
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 总结:
 * 动态规划为题，重点在于状态转移公式
 *
 * 如果前序数组和 + 当前下标所对应数值 < 当前下标所对应数值，则前序数组和可以抛去，后续计算从当前下标所对应数值开始。
 * 例如：-2+1+-3（前序数组和为-4） < 4(当前下标所对应数值)，dp[i]=4。dp永远记录最优解。
 *
 * 该问题是dp[i] = max{dp[i-1] + nums[i], nums[i]}
 *
 * dp[i]表示nums数组中，以nums[i]结尾的最大自序和
 * dp[i-1]表示nums[i]前的最大自序和（不包括nums[i]）
 *
 */
public class T_53MaximumSubarray {


    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
