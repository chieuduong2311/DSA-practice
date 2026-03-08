package algorithm.week5;

import java.util.*;

public class LowestCommonAncestorBinaryTree {
//    issue 236
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        ArrayDeque<TreeNode> firstPath = findPath(root, p);
        ArrayDeque<TreeNode> secondPath = findPath(root, q);
        TreeNode result = root;
        while (!firstPath.isEmpty() && !secondPath.isEmpty()) {
            if (firstPath.getFirst().val == secondPath.getFirst().val) {
                result = firstPath.removeFirst();
                secondPath.removeFirst();
            } else {
                return result;
            }
        }
        return result;
    }

    public ArrayDeque<TreeNode> findPath(TreeNode source, TreeNode target) {
        ArrayDeque<TreeNode> path = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        while (source.val != target.val) {
            if (visited.contains(source)) {
                path.removeLast();
                source = path.removeLast();
                continue;
            }

            path.add(source);

            if (source.left != null && !visited.contains(source.left)) {
                source = source.left;
                continue;
            }

            if (source.right != null && !visited.contains(source.right)) {
                source = source.right;
                continue;
            }
            visited.add(source);
            path.removeLast();
            source = path.removeLast();
        }

        path.add(source);
        return path;
    }




    public static void main(String[] args) {
        LowestCommonAncestorBinaryTree lowestCommonAncestorBinaryTree = new LowestCommonAncestorBinaryTree();
        TreeNode root = new TreeNode(3);
        var l1 = new TreeNode(5);
        var r1 = new TreeNode(1);
        root.left = l1;
        root.right = r1;
        var l2 = new TreeNode(6);
        var r2 = new TreeNode(2);
        l1.left = l2;
        l1.right = r2;
        var l3 = new TreeNode(7);
        var r3 = new TreeNode(4);
        r2.left = l3;
        r2.right = r3;
        var l4 = new TreeNode(0);
        var r4 = new TreeNode(8);
        r1.left = l4;
        r1.right = r4;

        TreeNode root2 = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root2.left = left;
        System.out.println(lowestCommonAncestorBinaryTree.lowestCommonAncestor(root2, root2, left).val);
    }
}
