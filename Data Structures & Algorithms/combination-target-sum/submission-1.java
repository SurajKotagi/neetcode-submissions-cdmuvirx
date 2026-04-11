class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(
        int i, 
        int[] nums, 
        int sum, 
        int target,
        List<Integer> cur,
        List<List<Integer>> ans) {
        
        if(target == sum){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(nums[j] + sum > target) break;
            cur.add(nums[j]);
            helper(j, nums, sum + nums[j], target, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
}
