package Leetcode;
import java.util.*;

public class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode leftLevel1 = new TreeNode(9);
        TreeNode rightLevel1 = new TreeNode(20);
        TreeNode leftLevel22 = new TreeNode(15);
        TreeNode rightLevel22 = new TreeNode(7);

        root.left = leftLevel1;
        root.right = rightLevel1;

        rightLevel1.left = leftLevel22;
        rightLevel1.right = rightLevel22;

        System.out.println("Maximum depth : " + new Solution().maxDepth1(root));
        System.out.println("Maximum depth : " + new Solution().maxDepth2(root));
    }
    static class Solution {
        public int maxDepth1(TreeNode root) {
            if(root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size > 0){
                    TreeNode out = queue.poll();
                    size--;
                    if(out.left != null){
                        queue.add(out.left);
                    }
                    if(out.right != null){
                        queue.add(out.right);
                    }
                }
                level++;
            }
            return level;
        }
        public int maxDepth2(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = maxDepth2(root.left);
            int right = maxDepth2(root.right);
            return Math.max(left,right)+1;
        }
    }
}

