class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max heap based on frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Add all characters
        for (char ch : map.keySet()) {
            pq.add(ch);
        }

        String ans = "";

        // Build answer
        while (!pq.isEmpty()) {
            char ch = pq.poll();

            for (int i = 0; i < map.get(ch); i++) {
                ans += ch;
            }
        }

        return ans;
    }
}