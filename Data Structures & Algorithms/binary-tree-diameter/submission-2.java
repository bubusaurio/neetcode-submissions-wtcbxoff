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
        int maxLeft = 1;
        int maxRight = 1;

        if(root.left != null){
            maxLeft += maxLength(root.left);
        }
        if(root.right != null){
            maxRight += maxLength(root.right);
        }

        int diameter = maxLeft + maxRight;

        result = Math.max(result, diameter);

        return Math.max(maxLeft, maxRight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        maxLength(root);
    
        return result - 2;
    }
}
