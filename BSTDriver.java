public class BSTDriver {
    public static void main(String[] args) {
        BasicBST tree = new BasicBST();
        tree.insert(10);
        tree.insert(8);
        tree.insert(15);
        tree.insert(5);
        tree.insert(2);
        tree.insert(12);
        tree.insert(1);
        tree.insert(17);
        tree.insert(20);
        tree.insert(19);
        tree.print();

        System.out.println("Count Lower: " + tree.countLower(8));
        System.out.println("Height: " + tree.height());
        System.out.println("Count Leaves: " + tree.countLeaves());
        System.out.println("CountOneChildParents: " + tree.countOneChildParents());
        System.out.println("CountEvenNumbers: " + tree.countEven());

    }
}
