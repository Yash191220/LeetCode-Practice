class Solution {
    public boolean stoneGameIX(int[] stones) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int stone : stones) {

            if (stone % 3 == 0) {
                count0++;
            } else if (stone % 3 == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        // If there are no remainder-1 or remainder-2 stones
        if (count1 == 0 && count2 == 0) {
            return false;
        }

        // If count0 is even
        if (count0 % 2 == 0) {
            return count1 > 0 && count2 > 0;
        }

        // If count0 is odd
        return Math.abs(count1 - count2) > 2;
    }
}