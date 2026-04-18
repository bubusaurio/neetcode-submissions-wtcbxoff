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

    int result = 0;

    public int maxLength(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = maxLength(root.left);
        int rightHeight = maxLength(root.right);

        int diameter = leftHeight + rightHeight;

        result = Math.max(result, diameter);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        maxLength(root);
    
        return result;
    }
}
