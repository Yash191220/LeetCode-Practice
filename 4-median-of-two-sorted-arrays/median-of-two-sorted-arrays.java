class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] result = new double[nums1.length + nums2.length];

        for(int i = 0; i<nums1.length; i++){
            result[i] = nums1[i];
        }
        for(int i = 0; i<nums2.length; i++){
            result[nums1.length + i] = nums2[i];
        }

        Arrays.sort(result);
        int len = result.length;

        if(len % 2 == 1){
            return result[len/2];
        }else{
            return (result[len/2 - 1] + result[len/2]) / 2.0;
        }
    }
}