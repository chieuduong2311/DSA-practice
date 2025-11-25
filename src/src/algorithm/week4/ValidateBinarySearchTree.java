package algorithm.week4;

public class ValidateBinarySearchTree {
//    issue 98
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTRec(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null && left.val >= root.val)
            return false;

        if (right != null && right.val <= root.val)
            return false;

        return root.val >= min && root.val <= max && isValidBSTRec(root.left, min, root.val - 1) && isValidBSTRec(root.right, root.val + 1, max);
    }
}
