package tanxin;

/**
 * @author jianw.li
 * @date 2018/12/19 2:12 PM
 * @Description: 思路。第一个元素如果为3，则跳跃到最远距离。[2,3,0,1,4] [2,3,0,0] [3,2,1,0,4] [0,5,4,0,2] [1,1,4,0,2]
 */
public class tiaoyueyouxi {
    public static boolean canJump(int[] nums) {
        if(jump(nums,0,nums[0])){
            return true;
        }

        return false;
    }

    public static boolean jump(int nums[], int index, int old_step){
        if(index >= nums.length -1){
            return true;
        }
        if(nums[index] == 0){
            return false;
        }

        //当前能够跳跃的最远距离 = 当前位置 + 能跳跃的距离
        index = index + old_step;
        if(jump(nums, index, old_step)){
            return true;
        }

        //之前路径失败，就会走这里.退一步
        old_step--;
        index = index + old_step;
        jump(nums, index, old_step);

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        canJump(nums);
    }
}
