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
     int count = 0;
        int result = 0;
    public int kthSmallest(TreeNode root, int k) {
       inOrder(root,k);
        return result;   

    }
    private void inOrder(TreeNode root, int k){
        if(root==null) return;
        inOrder(root.left,k);
        count++;
        if(count==k){
            result= root.val;
            return;
        }
        inOrder(root.right,k);
    }
    //     List<Integer> list = new ArrayList<>();
    //     getInOrderList(root,list);

    //     return list.get(k-1);

        
    // }
    // public void getInOrderList(TreeNode root, List<Integer> list){
    //     if(root == null ) return;
    //     getInOrderList(root.left,list);
    //     list.add(root.val);
    //     getInOrderList(root.right,list);
    // }
}
