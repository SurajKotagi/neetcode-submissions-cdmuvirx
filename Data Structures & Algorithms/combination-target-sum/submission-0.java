class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hans = new HashSet<>();
        helper(0, nums, target, hans, new ArrayList<>());
        for(List<Integer> x : hans) ans.add(x);
        return ans;
    }
    public void helper(
        int i, 
        int[] nums, 
        int target,
        HashSet<List<Integer>> ans, 
        List<Integer> cur){
        if(target < 0) return;
        if(i == nums.length){
            if(target == 0)
                ans.add(new ArrayList<>(cur));
            return;
        }
        
        cur.add(nums[i]);
        helper(i+1, nums, target-nums[i], ans, cur);
        helper(i, nums, target-nums[i], ans, cur);
        cur.remove(cur.size()-1);

        helper(i+1, nums, target, ans, cur);
    }
}
