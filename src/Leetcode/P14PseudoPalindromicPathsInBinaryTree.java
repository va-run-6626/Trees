package Leetcode;

import java.util.*;

public class P14PseudoPalindromicPathsInBinaryTree {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      TreeNode level1Left = new TreeNode(3);
      TreeNode level1Right = new TreeNode(1);
      TreeNode Level2LeftL = new TreeNode(3);
      TreeNode Level2LeftR = new TreeNode(1);
      TreeNode Level2RightR = new TreeNode(1);


      root.left = level1Left;
      root.right = level1Right;

      level1Left.left = Level2LeftL;
      level1Left.right = Level2LeftR;

      level1Right.right = Level2RightR;

      int ans = new Solution().pseudoPalindromicPaths(root);
        System.out.println(ans);
    }
}
class Solution{
    public int pseudoPalindromicPaths(TreeNode root){
        int[] count = {0};
        int[] path = new int[10];
        helper(root,path,count);
        return count[0];
    }

    private void helper(TreeNode root, int[]path, int[] count) {
        if(root == null) return;
        path[root.val]++;
        helper(root.left,path,count);
        helper(root.right,path,count);
        if(root.left == null && root.right == null){
            int odd = 0;
            for(int i = 0; i <= 9; i++){
                if(path[i] % 2 == 1) odd++;
            }
            if(odd == 0 || odd == 1) count[0]++;
        }
        path[root.val]--;
    }
}
