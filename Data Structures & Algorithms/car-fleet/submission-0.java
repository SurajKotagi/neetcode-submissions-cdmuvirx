class Solution {
    class Pair{
        int pos;
        int spd;

        Pair(int pos, int spd){
            this.pos = pos;
            this.spd = spd;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> cars = new ArrayList<>();
        for(int i = 0; i < position.length; i++) {
            cars.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(cars, (a,b)->a.pos - b.pos);
        Stack<Pair> st = new Stack<>();
        st.push(cars.get(cars.size()-1));
        int ans = 0;
        for (int i = cars.size()-2; i >= 0; i--) {
            Pair cur = cars.get(i);
            double curCarHourNeeded = ((double)(target - cur.pos) / cur.spd);
            // System.out.println(curCarHourNeeded);
            while(!st.isEmpty() && 
            (curCarHourNeeded > ((double)(target - st.peek().pos)/st.peek().spd))) {
                st.pop();
            }
            if(st.isEmpty()) ans++;
            st.push(cur); 
        }

        return ans+1;
    }
}
