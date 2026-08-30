class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> key:tickets){
            if(!map.containsKey(key.get(0))){
                map.put(key.get(0),new PriorityQueue<>());
            }
            map.get(key.get(0)).add(key.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs("JFK",map,result);

        Collections.reverse(result);
        return result;
    }

    public void dfs(String from, HashMap<String, PriorityQueue<String>> map, List<String> result){
        while(map.containsKey(from) && !map.get(from).isEmpty()){
            String to = map.get(from).poll();

            dfs(to,map,result);
        }
        result.add(from);
    }
}