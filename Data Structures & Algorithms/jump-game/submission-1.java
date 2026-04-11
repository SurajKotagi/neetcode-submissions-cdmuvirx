class Solution {
    public boolean canJump(int[] nums) {
        boolean [] possible = new boolean[nums.length];
         
        possible[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if(possible[i]){
                int jump =  nums[i];
                int st = i+1; 
                while(jump > 0 && st < nums.length){
                    possible[st] = true;
                    jump--;
                    st++;
                }
            }
        }
        return possible[nums.length-1];
    }
}
