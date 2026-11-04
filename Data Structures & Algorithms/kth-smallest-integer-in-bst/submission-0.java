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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        getInOrderList(root,list);
        int[] array = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(array);
        return array[k-1];

        
    }
    public void getInOrderList(TreeNode root, List<Integer> list){
        if(root == null ) return;
        getInOrderList(root.left,list);
        list.add(root.val);
        getInOrderList(root.right,list);
    }
}
