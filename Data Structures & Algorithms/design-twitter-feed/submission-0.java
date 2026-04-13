class Pair{
    int userId;
    int tweetId;
    int time;

    Pair(int userId, int tweetId, int time) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
    }
}
    
class Twitter {

    HashMap<Integer, HashSet<Integer>> hm;
    PriorityQueue<Pair> q ; 
    int t;
    public Twitter() {
        hm = new HashMap<>();
        q = new PriorityQueue<>((a, b) -> b.time - a.time);
        t = 0;
    }

    // {userId_1, tweetId_1}
    // {userId_2, tweetId_2}
    // {userId_3, tweetId_3}    
    public void postTweet(int userId, int tweetId) {
        q.add(new Pair(userId, tweetId, t));
        t++;
    }
    
    // most recent tweet ids by user and users he is following
    public List<Integer> getNewsFeed(int userId) {
        Queue<Pair> helper = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        while(count != 10 && !q.isEmpty()){
            Pair cur = q.remove();
            if(cur.userId == userId || (hm.containsKey(userId) && hm.get(userId).contains(cur.userId))){
                ans.add(cur.tweetId);
                count++;
            }
            helper.add(cur);
        }  
        while(!helper.isEmpty()) q.add(helper.remove());
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!hm.containsKey(followerId)) {
            hm.put(followerId, new HashSet<>());
        }
        hm.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        hm.get(followerId).remove(followeeId);
    }
}
