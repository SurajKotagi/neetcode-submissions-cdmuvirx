class Solution {
    class Pair {
        int elm;
        int freq;

        Pair(int elm, int freq){
            this.elm = elm;
            this.freq = freq; 
        }
    }
    public int[] topKFrequent(int[] nums, int k) {  
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq , a.freq));
        for(int key : hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }
        
        int [] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().elm;
        }
        return ans;
    }
}
