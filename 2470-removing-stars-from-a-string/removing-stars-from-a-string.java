class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(char c:s.toCharArray()){
            if(c == '*'){
                st.pop();
            }else{
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch:st){
            sb.append(ch);
        }
        return sb.toString();
    }
}