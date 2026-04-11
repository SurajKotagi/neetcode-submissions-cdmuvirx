class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length()-1;
        while(start < end) {
            char sch = s.charAt(start); 
            while(!isAlphaNum(sch)) {
                start++;
                if(start >= s.length()) break;
                sch = s.charAt(start);
            }
            char ech = s.charAt(end); 
            while(!isAlphaNum(ech)) {
                end--;
                if(end < 0) break;
                ech = s.charAt(end);
            }
            if(start > end) break;
            if(sch >= 'A' && sch <= 'Z'){
                if(ech != sch && ech != (char)(sch + 32)) return false;
            } else if(sch >= 'a' && sch <= 'z'){
                if (ech != sch && ech != (char)(sch - 32)) return false;
            } else if(sch >= '0' && sch <= '9'){
                if(ech != sch) return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isAlphaNum(char ch){
        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }
}
