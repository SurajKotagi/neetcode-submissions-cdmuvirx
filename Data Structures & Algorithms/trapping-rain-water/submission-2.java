class Solution {
    public int trap(int[] nums) {
        if(nums.length == 1) return 0;
        int water = 0;
        int l = 0;
        int r = nums.length-1;
        int leftMax = nums[0];
        int rightMax = nums[nums.length-1];
        
        while(l < r) {
            if (leftMax < rightMax) {
                l++;
                if(leftMax < nums[l]) leftMax = nums[l];
                water += Math.max(leftMax, nums[l]) - nums[l];
            } else {
                r--;
                if(rightMax < nums[r]) rightMax = nums[r];
                water += Math.max(rightMax, nums[r]) - nums[r];
            }
        }

        return water;
    }
}
