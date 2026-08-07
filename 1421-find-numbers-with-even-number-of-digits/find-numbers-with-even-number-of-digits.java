class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for(int i = 0; i<nums.length; i++){
            int count  = 0;
            int curr_ele = nums[i];
            while(curr_ele > 0){
                count++;
                curr_ele = curr_ele / 10;
            }
            if(count % 2 == 0){
                total++;
            }
        }
        return total;
    }
}