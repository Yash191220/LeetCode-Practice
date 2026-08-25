class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());

        for(int i=min; i>=1; i--){
            String part = str1.substring(0, i);

            if(canMake(str1,part) && canMake(str2,part)){
                return part;
            }
        }
        return "";
    }

    public static boolean canMake(String str, String part){
        if(str.length() % part.length() != 0){
            return false;
        }

        String result = "";
        for(int i=0; i<str.length()/part.length(); i++){
            result += part;
        }

        return result.equals(str);
    }
}