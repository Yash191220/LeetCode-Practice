class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int i =0 ; i<k; i++){
            pq.add(new int[]{nums[i], i});
        }

        res[0] = pq.peek()[0];

        for(int i=k; i<nums.length; i++){
            while(!pq.isEmpty() && pq.peek()[1] <= (i-k)){
                pq.remove();
            }
            pq.add(new int[]{nums[i], i});
            res[i - k + 1] = pq.peek()[0];
        }

        return res;
    }
}