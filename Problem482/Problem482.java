public class Problem482 {
    public static void main(String args[]) {
        BTreeNode root = new BTreeNode(5);
        BTreeNode leftSubTree = new BTreeNode(3);
        BTreeNode rightSubTree = new BTreeNode(8);
        BTreeNode leftLeftSubTree = new BTreeNode(2);
        BTreeNode rightLeftSubTree = new BTreeNode(4);
        BTreeNode leftRightSubTree = new BTreeNode(6);
        BTreeNode rightRightSubTree = new BTreeNode(10);
        leftSubTree.left = leftLeftSubTree;
        leftSubTree.right = rightLeftSubTree;
        rightSubTree.left = leftRightSubTree;
        rightSubTree.right = rightRightSubTree;
        root.left = leftSubTree;
        root.right = rightSubTree;
        System.out.println(solution(root, 4, 9));
    }
    public static int solution(BTreeNode root, int lowerBound, int upperBound) {
        if (root == null) {
          return 0;
        }
        else if (root != null && (root.left == null && root.right == null)) {
          if (root.val >= lowerBound && root.val <= upperBound){
            return root.val;
          }
          else{
            return 0;
          }
        }
        else {
            return ((root.val >= lowerBound && root.val <= upperBound) ? root.val : 0) + solution(root.left, lowerBound, upperBound) + solution(root.right, lowerBound, upperBound);
        }
    }
}