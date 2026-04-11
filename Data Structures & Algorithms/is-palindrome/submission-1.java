class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length()-1;
        while(start < end) {
            char sch = s.charAt(start); 
            while(!(sch >= 'A' && sch <= 'Z') &&
                  !(sch >= 'a' && sch <= 'z') &&
                  !(sch >= '0' && sch <= '9')) {
                start++;
                if(start >= s.length()) break;
                sch = s.charAt(start);
            }
            char ech = s.charAt(end); 
            while(!(ech >= 'A' && ech <= 'Z') &&
                  !(ech >= 'a' && ech <= 'z') &&
                  !(ech >= '0' && ech <= '9')) {
                end--;
                if(end < 0) break;
                ech = s.charAt(end);
            }
            if(start > end) break;
            if(sch >= 'A' && sch <= 'Z'){
                if(ech == sch || ech == (char)(sch + 32)){
                    start++;
                    end--;
                } else {
                    return false;
                }
            } else if(sch >= 'a' && sch <= 'z'){
                if(ech == sch || ech == (char)(sch - 32)){
                    start++;
                    end--;
                } else {
                    return false;
                }
            } else if(sch >= '0' && sch <= '9'){
                if(ech == sch){
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
