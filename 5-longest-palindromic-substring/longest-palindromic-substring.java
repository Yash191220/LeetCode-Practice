class Solution {
    public String longestPalindrome(String s) {

        String answer = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                String current = s.substring(i, j + 1);

                if (isPalindrome(current)) {

                    if (current.length() > answer.length()) {
                        answer = current;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}