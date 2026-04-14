class Pair{
    int userId;
    List<int[]> tweets;

    Pair(int userId) {
        this.userId = userId;
        this.tweets = new ArrayList<>();
    }

    void addTweet(int[] tweet){
        this.tweets.add(tweet);
    }
}
    
class Twitter {

    PriorityQueue<int[]> q ; 
    HashMap<Integer, Pair> hm;
    HashMap<Integer, HashSet<Integer>> fMap;
    int t;
    public Twitter() {
        hm = new HashMap<>();
        fMap = new HashMap<>();
        t = 0;
    }
 
    public void postTweet(int userId, int tweetId) {
        if(!fMap.containsKey(userId)) {
            fMap.put(userId, new HashSet<>());
        }
        if(!hm.containsKey(userId)){
            hm.put(userId, new Pair(userId));
        }
        hm.get(userId).addTweet(new int[]{tweetId, t});
        t++;
    }
    
    // most recent tweet ids by user and users he is following
    public List<Integer> getNewsFeed(int userId) {
        q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int user : fMap.get(userId)){
            Pair cur = hm.get(user);
            int i = cur.tweets.size()-1;
            int count = 10;
            while(count > 0 && i >= 0){
                q.add(cur.tweets.get(i));
                i--;
            }
        }
        Pair user = hm.get(userId); 
        int i = user.tweets.size()-1;
        int count = 10;
        while(count > 0 && i >= 0){
            q.add(user.tweets.get(i));
            i--;
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty() && ans.size() < 10){
            ans.add(q.remove()[0]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!hm.containsKey(followerId)){
            hm.put(followerId, new Pair(followerId));
        }
        if(!hm.containsKey(followeeId)){
            hm.put(followeeId, new Pair(followeeId));
        }
        if(!fMap.containsKey(followerId)) {
            fMap.put(followerId, new HashSet<>());
        }
        fMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        fMap.get(followerId).remove(followeeId);
    }
}
