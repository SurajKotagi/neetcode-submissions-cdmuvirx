class Solution {
    public List<List<Integer>> combinationSum2(int[] c, int target) {
        Arrays.sort(c);
        List<List<Integer>> ans= new ArrayList<>();
        h(0, target, 0, new ArrayList<>(), ans, c);
        return ans;
    }
    public void h(int idx, int t,int s, List<Integer> cur, List<List<Integer>> ans, int[] c) {
      //  if(s==t) ans.add(new ArrayList<>(cur));
        if(s>t)return;
        if(idx== c.length){
            if(s==t)ans.add(new ArrayList<>(cur));
            return;
        } //return;
        //if(idx == c.length){
        //    return;
      //  }
       // for(int i=idx; i < c.length; i++){
       boolean ok = true;
           //if(idx > 0 && c[idx-1]==c[idx]) ok = false;
            if (ok){

            
            cur.add(c[idx]);
            h(idx+1, t, s+c[idx], cur, ans, c);
            cur.remove(cur.size()-1);
            } 
            while(idx < c.length -1 && c[idx]== c[idx+1]) idx++;
            h(idx+1, t, s, cur, ans ,c);
            
       // }
    }
}
