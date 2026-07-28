class Solution {
    public String smallestPalindrome(String s) {
        int cnt[] = new int[26];
        char arr[] = s.toCharArray();
        for(char c : arr){
            cnt[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char mid = 0;

        for(int i=0; i<26; i++){
            char c = (char) ('a' + i);
            if(cnt[i] % 2 == 1){
                mid = c;
            }
            for(int j=0; j<cnt[i]/2; j++){
                half.append(c);
            }
        }
        String halfStr = half.toString();
        String reversed = new StringBuilder(halfStr).reverse().toString();

        return halfStr + ((mid==0) ? "" : String.valueOf(mid)) + reversed;
    }
}