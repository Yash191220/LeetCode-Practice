/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair{
        TreeNode node;
        int row; 
        int col;
        Pair(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();

            TreeNode curr = p.node;
            int row = p.row;
            int col = p.col;
            // Create column if not present
            map.putIfAbsent(col, new TreeMap<>());
            // Create row if not present
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            // Add value
            map.get(col).get(row).add(curr.val);

            //left
            if(curr.left != null){
                q.add(new Pair(curr.left,row+1,col-1));
            }
            //right
            if(curr.right != null){
                q.add(new Pair(curr.right,row+1,col+1));
            }
        }
        //convert into list
        // col
        for(TreeMap<Integer, PriorityQueue<Integer>> col:map.values()){
            List<Integer> list = new ArrayList<>();
            //row
            for(PriorityQueue<Integer> pq:col.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}