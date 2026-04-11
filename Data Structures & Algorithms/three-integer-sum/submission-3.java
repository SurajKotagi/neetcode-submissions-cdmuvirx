class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> temp = Arrays.asList(new Integer[]{nums[i], nums[l], nums[r]});
                    ans.add(temp);
                    while(l < r && nums[l] == nums[l+1]) l++;
                    l++;
                } else if(sum > 0) {
                    while(nums[r] == nums[r-1]) r--;
                    r--;
                } else if(sum < 0){
                    while(nums[l] == nums[l+1]) l++;
                    l++;
                }
            }
        }
        return ans;
    }
}
