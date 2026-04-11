class Solution {
    public int[] productExceptSelf(int[] nums) {

        int [] ans = new int[nums.length]; 
        ans[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i - 1] * nums[i];
        }
        int prodFfromRight = nums[ans.length-1];
        ans[nums.length-1] = ans[nums.length-2];
        for(int i = nums.length-2; i > 0; i--){
            ans[i] = prodFfromRight * ans[i-1];
            prodFfromRight = prodFfromRight * nums[i];
        }
        ans[0] = prodFfromRight;
        return ans;
    }
}  
