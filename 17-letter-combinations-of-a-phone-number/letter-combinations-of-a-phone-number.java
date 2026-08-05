class Solution {
    final static char[][] L = {
        {'a','b','c'},{'d','e','f'},
        {'g','h','i'},{'j','k','l'},
        {'m','n','o'},{'p','q','r','s'},
        {'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> result  = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        bfs(0,digits.length(),new StringBuilder(),digits,result);
        return result;
    }
    public static void bfs(int pos, int len,StringBuilder sb, String D, List<String> result){
        if(pos == len){
            result.add(sb.toString());
        }else{
            char[] letters = L[Character.getNumericValue(D.charAt(pos))-2];
            for(int i=0; i<letters.length; i++){
                bfs(pos+1,len,new StringBuilder(sb).append(letters[i]),D,result);
            }
        }
    }
}
