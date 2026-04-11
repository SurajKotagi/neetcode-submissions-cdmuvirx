class Solution {
    public int findKthLargest(int[] nums, int k) {
        int idx = -1;
        int st = 0;
        int en = nums.length - 1;
        while(true){
            int pivot = nums[en];
            int i = st;
            int j = en - 1;

                while(i <= j){
                    int temp = nums[i];
                    int temp2 = nums[j];
                    if(nums[i] < pivot){
                        i++;
                    } else {
                        nums[j] = nums[i];
                        nums[i] = temp2;
                        j--;
                    }
                            }

            nums[en] = nums[i];
            nums[i] = pivot;
            idx = i;
            int n = nums.length;
            if(idx == n - k ){
                return pivot;
            } else if(idx > n - k){
                en = idx - 1;
            } else {
                st =idx + 1;
            }
        }
    }
}
