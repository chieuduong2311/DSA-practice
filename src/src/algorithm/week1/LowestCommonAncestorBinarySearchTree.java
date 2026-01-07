package algorithm.week1;

public class LowestCommonAncestorBinarySearchTree {
//    issue 235
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
                continue;
            }
            if (root.val < p.val && root.val < q.val){
                root = root.right;
                continue;
            }
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(9);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;
        n4.right = n6;
        n2.left = n7;
        n2.right = n8;

        LowestCommonAncestorBinarySearchTree l = new LowestCommonAncestorBinarySearchTree();
        System.out.println(l.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(4)).val);
    }
}
