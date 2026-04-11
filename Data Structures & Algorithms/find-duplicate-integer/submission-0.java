class Solution {
    public int findDuplicate(int[] nums) {
        for(int num : nums){
            if(num < 0) {
                num *= -1;
            }
            if(nums[num - 1] < 0) return num;
            nums[num - 1] = nums[num-1] * -1;
        }
        return -1;
    }
}
