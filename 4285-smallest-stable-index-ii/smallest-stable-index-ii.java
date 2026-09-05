class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int sufixMin[] = new int[n];
        sufixMin[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--){
            sufixMin[i] = Math.min(nums[i],sufixMin[i+1]);
        }

        int prefixMax = nums[0];
        for(int i=0; i<nums.length; i++){
            prefixMax = Math.max(nums[i],prefixMax);

            int score = prefixMax - sufixMin[i];

            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}