class Solution {
    public int maxArea(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int maxArea = 0;
        while (l < r) {
            int curArea = (r - l) * Math.min(nums[l], nums[r]);
            if(curArea > maxArea) maxArea = curArea;

            if(nums[l] == nums[r] || nums[l] < nums[r])
                l++;
            else 
                r--;
            
        }
        return maxArea;
    }
}
