class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for(String x : strs){
            char[] arr = x.toCharArray(); 
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(hm.containsKey(sorted)){
                hm.get(sorted).add(x);
            } else {
                hm.put(sorted, new ArrayList<>());
                hm.get(sorted).add(x);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String x : hm.keySet()){
            ans.add(hm.get(x));
        }
        return ans;
    }
}
