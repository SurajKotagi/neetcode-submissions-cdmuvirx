class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(String.valueOf(s.length()));
            sb.append("~");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0; 
        int start = 0;
        while(i < str.length()){
            while(str.charAt(i) != '~') i++;
            int len = Integer.parseInt(str.substring(start, i));
            decoded.add(str.substring(i+1, i+1+len));
            start = i+1+len;
            i = i+1+len;
        }
        return decoded;
    }
}
