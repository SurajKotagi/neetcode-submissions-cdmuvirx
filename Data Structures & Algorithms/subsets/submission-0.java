class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void helper(
        int i, 
        int[] nums, 
        List<List<Integer>> ans, 
        List<Integer> cur){
        if(i == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        helper(i+1, nums, ans, cur);
        cur.remove(cur.size()-1);

        helper(i+1, nums, ans, cur);
    }
}
