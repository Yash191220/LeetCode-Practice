class Solution {
    public int longestSubsequence(int[] nums) {
        int xorAll = 0;
        boolean nonZero = false;

        for(int num:nums){
            xorAll ^= num;
            if(num != 0){
                nonZero = true;
            }
        }
        if(xorAll != 0){
            return nums.length;
        }

        if(nonZero){
            return nums.length - 1;
        }

        return 0;
    }
}