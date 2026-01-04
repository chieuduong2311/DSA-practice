package algorithm.week1;

public class BalancedBinaryTree {
//    issue 110
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left)) {
            return false;
        }
        if (!isBalanced(root.right)) {
            return false;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode n1 = new TreeNode(9);
//        TreeNode n2 = new TreeNode(20);
//        TreeNode n3 = new TreeNode(15);
//        TreeNode n4 = new TreeNode(7);
//        root.left = n1;
//        root.right = n2;
//        n2.left = n3;
//        n2.right = n4;

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n5;
        n3.right = n6;

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(root));
    }
}
