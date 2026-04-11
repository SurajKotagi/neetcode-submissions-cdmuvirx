class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int totalBananas = 0;
        int maxPile  = 0;;
        for(int pile : piles){
            totalBananas += pile;
            maxPile = Math.max(maxPile, pile);
        }
        int l = totalBananas / h;
        int r = maxPile;
        return bs(piles, l, r, h);
    }

    public int noOfHoursTaken(int[] piles, int rate) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / rate);
        }
        return hours;
    }

    public int bs(int [] piles, int l, int r, int h){
        while(l <= r){
            int mid = (l + r) / 2;
            int hours = noOfHoursTaken(piles, mid);
            if(hours <= h){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r+1;
    } 
}
