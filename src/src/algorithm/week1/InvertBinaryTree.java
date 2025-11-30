package algorithm.week1;

public class InvertBinaryTree {
//    issue 226
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

    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = null;
        swapNode(root, temp);
        return root;
    }

    public void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        traverseTree(root.left);
        System.out.println(root.val);
        traverseTree(root.right);
    }

    private static void swapNode(TreeNode root, TreeNode temp) {
        if (root == null) {
            return;
        }
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        swapNode(root.left, temp);
        swapNode(root.right, temp);
    }

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        root.left = node1;
        root.right = node2;

        invertBinaryTree.invertTree(root);
        invertBinaryTree.traverseTree(root);
    }

}
