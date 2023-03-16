package codechallenge;

import java.util.Objects;

public class TreeInverse {

    static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

    }

    /**
     *
     * @param root Root node of tree
     * @return TreeNode that is the root node of inverted tree
     */
    public TreeNode inverseTree(TreeNode root) {
        if (Objects.isNull(root))
            return null;

        inverseTree(root.left);
        inverseTree(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        return root;
    }
}
