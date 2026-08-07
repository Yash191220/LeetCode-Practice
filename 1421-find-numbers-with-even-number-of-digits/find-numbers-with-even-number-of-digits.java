class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for(int num : nums){
            if(((int) Math.log10(num)+1) % 2 == 0 ){
                total++;
            }
        }
        return total;
    }
}