
public class BinaryTreeTest
{
    public static void main(String [] args)
    {

        BinaryTree tree2 = new BinaryTree(1, new BinaryTree(2, new BinaryTree(3, null, null), new BinaryTree(6, null, null)), new BinaryTree(4, new BinaryTree(5, null, null), null));

        System.out.println("--------------------In Order-----------------");

        tree2.showinOrderTraverse(2, tree2.root);

        System.out.println("Version 2: ");

        tree2.showinOrderTraverseV2(tree2.root);

        System.out.println("\n-------------------Pre Order-----------------");

        tree2.preOrder();

        System.out.println("\n-------------------Post Order----------------");

        tree2.showPostOrderTraverse(2, tree2.root);

        System.out.println("Version 2: ");

        tree2.showPostOrderTraverseV2(tree2.root);

        System.out.println("\n-------------------Level Order---------------");

        tree2.showLevelOrderTraverse(2, tree2.root);

        System.out.println("Version 2: ");

        tree2.showLevelOrderTraversalV2(tree2.root);

    }
}
