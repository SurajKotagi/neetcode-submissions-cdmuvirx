class Pair {
    int idx;
    String val;

    Pair (int idx, String val) {
        this.idx = idx;
        this.val = val;
    }
}
class TimeMap {
    HashMap<String, List<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            hm.get(key).add(new Pair(timestamp, value));
        } else {
            hm.put(key, new ArrayList<>());
            hm.get(key).add(new Pair(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        if(timestamp < hm.get(key).get(0).idx) return "";

        return bs(hm.get(key), timestamp);
    }

    public String bs(List<Pair> arr, int ts){
        int s = 0;
        int e = arr.size() - 1;
        while(s <= e){
            int mid = (s + e) / 2 ;
            int idx = arr.get(mid).idx;
            String val = arr.get(mid).val;
            if (idx == ts) {
                return val; 
            } else if (idx > ts) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return arr.get(e).val;
    }
}
