class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] ap  = new int[128];

        for(int i=0; i<s.length(); i++){
            ap[s.charAt(i)]++;
        }
        for(int i=0; i<t.length(); i++){
            ap[t.charAt(i)]--;

            if(ap[t.charAt(i)]<0){
                return false;
            }
        }
        return true;
    }
}