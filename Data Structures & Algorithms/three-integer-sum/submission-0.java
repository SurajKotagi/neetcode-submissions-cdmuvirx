class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet<>();
        for(int i = 0; i < nums.length;) {
            int target = -1 * nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    List<Integer> temp = Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]});
                    Collections.sort(temp);
                    hs.add(temp);
                    left++;
                } else if(nums[left] + nums[right] > target) {
                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;
                } else if(nums[left] + nums[right] < target){
                    while(left < right && nums[left] == nums[left+1]) left++;
                    left++;
                }
            }
            while(i < nums.length-1 && nums[i+1] == nums[i]) i++;
            i++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> x : hs) ans.add(x);

        return ans;
    }
}
