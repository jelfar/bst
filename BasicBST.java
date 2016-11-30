public class BasicBST {
    private class BSTNode {
        public BSTNode left, right;
        public int value;

        public BSTNode(int v) {
            this.value = v;
        }

        public int compareTo(BSTNode comp) {
            if(this.value > comp.value)
                return 1;
            else if(this.value < comp.value)
                return -1;
            else
                return 0;
        }
    }

    private BSTNode root;

    public BasicBST() {
        root = null;
    }

    public void insert(int x) {
        if(root == null)
            this.root = insert(new BSTNode(x), root); 
        else
            insert(new BSTNode(x), root);
    }

    private BSTNode insert(BSTNode nodeToBeAdded, BSTNode rootNode) {
        if(rootNode == null) {
            return nodeToBeAdded;
        }

        int comparison = rootNode.compareTo(nodeToBeAdded); 

        if(comparison < 0) {
            rootNode.right = insert(nodeToBeAdded, rootNode.right);
        } else if (comparison > 0) {
            rootNode.left = insert(nodeToBeAdded, rootNode.left);
        }

        return rootNode;
    }

    public int countLower(int x) {
        if(root == null)
            return 0;
        else
            return countLower(new BSTNode(x), this.root);
    }

    private int countLower(BSTNode curNode, BSTNode rootNode) {
        if(rootNode == null)
            return 0;

        int comparison = rootNode.compareTo(curNode);

        if(comparison < 0) {
            return 1 + countLower(curNode, rootNode.left) + countLower(curNode, rootNode.right);
        } else if(comparison >= 0) {
            return countLower(curNode, rootNode.left) + countLower(curNode, rootNode.right);
        } 

        return 0;
    }

    public int countEven() {
        if(root == null)
            return 0;
        else
            return countEven(this.root);
    }

    private int countEven(BSTNode curNode) {
        if(curNode == null)
            return 0;

        if(curNode.value%2 == 0)
            return curNode.value + countEven(curNode.left) + countEven(curNode.right);
        else
            return countEven(curNode.left) + countEven(curNode.right);
    }

    public int height() {
        if(this.root == null) 
            return -1;
        else
            return height(this.root);
    }

    private int height(BSTNode rootNode) {
        if(rootNode.left == null && rootNode.right == null){
            return 0;
        }

        if(rootNode.left != null && rootNode.right != null) {
            if(height(rootNode.left) > height(rootNode.right)) {
                return 1 + height(rootNode.left);
            } else {
                return 1 + height(rootNode.right);
            }
        } else if(rootNode.right != null) {
            return 1 + height(rootNode.right);
        } else if(rootNode.left != null) {
            return 1 + height(rootNode.left);
        } else {
            return 0;
        }
    }

    public int countLeaves() {
        if(this.root == null)
            return 0;
        else 
            return countLeaves(this.root);
    }

    private int countLeaves(BSTNode rootNode) {
        if(rootNode.left == null && rootNode.right == null){
            return 1;
        }

        if(rootNode.left != null && rootNode.right != null) {
            return countLeaves(rootNode.left) + countLeaves(rootNode.right);
        } else if(rootNode.right != null) {
            return countLeaves(rootNode.right);
        } else if(rootNode.left != null) {
            return countLeaves(rootNode.left);
        } else {
            return 0;
        }
    }

    public int countOneChildParents() {
        if(this.root == null) 
            return 0;
        else
            return countOneChildParents(this.root);
    }

    private int countOneChildParents(BSTNode rootNode) {
        if(rootNode.left == null && rootNode.right == null){
            return 0;
        }

        if(rootNode.left != null && rootNode.right != null) {
            return countOneChildParents(rootNode.left) + countOneChildParents(rootNode.right);
        } else if(rootNode.right != null) {
            return 1 + countOneChildParents(rootNode.right);
        } else if(rootNode.left != null) {
            return 1 + countOneChildParents(rootNode.left);
        } else {
            return 0;
        }
    }

    public void print() {
        print(root);
    }

    public void print(BSTNode rootNode){
        if (rootNode != null) {
            print(rootNode.left);
            System.out.print(rootNode.value + " ");
            print(rootNode.right);
        }
    }

}
