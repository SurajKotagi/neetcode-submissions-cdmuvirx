class Solution {
    class Pair {
                int val;
                        int idx;
                                Pair(int val, int idx) {
                                            this.val = val;
                                                        this.idx = idx;
                                                                }
                                                                    }
                                                                    public int[] dailyTemperatures(int[] nums) {
                                                                            int n = nums.length;
                                                                                    int [] ans = new int[n];
                                                                                            Stack<Pair> st = new Stack<>();
                                                                                                    for (int i = n-1; i >= 0; i--) {
                                                                                                                while(!st.isEmpty() && st.peek().val <= nums[i]) st.pop();
                                                                                                                            
                                                                                                                                        if (st.isEmpty()){
                                                                                                                                                        ans[i] = 0;
                                                                                                                                                                        st.push(new Pair(nums[i], i));
                                                                                                                                                                                        continue;
                                                                                                                                                                                                    }

                                                                                                                                                                                                                ans[i] = st.peek().idx - i;
                                                                                                                                                                                                                            st.push(new Pair(nums[i], i));
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                            return ans;
                                                                                                                                                                                                                                                }
    }

