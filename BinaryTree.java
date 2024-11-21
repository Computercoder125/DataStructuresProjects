import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E>
{
        private class Node<E>{
            private E data;
            private Node<E> left;
            private Node<E> right;
            public Node(E value) {
                data = value;
                left = null;
                right = null;
            }
            public Node(E value, Node<E> leftRef, Node<E> rightRef) {
                data = value;
                left = leftRef;
                right = rightRef;
            }
        }
        protected Node<E> root;

       // Node<E> pass
        public BinaryTree()
        {
            root = null;
        }
        public BinaryTree(Node<E> rootnode)
        {
            root = rootnode;
        }
        public BinaryTree(E value, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
            root = new Node<E>(value);
            if (leftTree != null)
            {
                root.left = leftTree.root;
            } else {
                root.left = null;
            }
            if (rightTree != null)
            {
                root.right = rightTree.root;
            } else
            {
                root.right = null;
            }
        }
    public void showPreOrderTraverse(Node<E> givenroot, int level)
    {
        if(level < 0)
        {
            System.out.println("Level is out of range.");
            return;
        }
        for (int i=1; i < level; i++)
        {
            System.out.print(" ");
        }
        if(givenroot == null)
        {
            System.out.println("null");
        }
        else
        {
            System.out.println(givenroot.data);
            showPreOrderTraverse(givenroot.left, level+1);
            showPreOrderTraverse(givenroot.right, level+1);
        }
    }
    public void showPreOrderTraverseV2(Node<E> givenroot)
    {
        if(givenroot != null)
        {
            System.out.print(givenroot.data);
            showPreOrderTraverseV2(givenroot.left);
            showPreOrderTraverseV2(givenroot.right);
        }
    }
    public void showinOrderTraverse(int level, Node<E> root)
    {
        if(level < 1)
        {
            System.out.println("Level is out of range.");
            return;
        }
        if(root != null)
        {
            showinOrderTraverse(level + 1, root.left); //printing the left subtree

            for (int i = 1; i < level; i++)
            {
                System.out.print(" ");
            }
            System.out.println(root.data); //printing the data

            showinOrderTraverse(level + 1, root.right); //printing the right subtree
        }
        else
        {
            for (int i = 1; i < level; i++)
            {
                System.out.print("  ");
            }
            System.out.println("null");
        }
    }
    public void showinOrderTraverseV2(Node<E> root)
    {
        if(root != null)
        {
            showinOrderTraverseV2(root.left);

            System.out.print(" " + root.data);

            showinOrderTraverseV2(root.right);
        }
    }
    public void showPostOrderTraverse(int level, Node<E> root)
    {
        if(level < 0)
        {
            System.out.println("Level out of range.");
            return;
        }

        if(root == null)
        {
            for(int i = 0; i < level; i++)
            {
                System.out.print(" ");
            }
            System.out.println("null");
            return;
        }
        else
        {

            showPostOrderTraverse(level + 1, root.left);

            showPostOrderTraverse(level + 1, root.right);

            for (int i = 1; i < level; i++)
            {
                System.out.print(" ");
            }

            System.out.println(" " + root.data);
        }
    }
        public void showPostOrderTraverseV2(Node<E> root)
        {
            if(root == null)
            {
                return;
            }

            showPostOrderTraverseV2(root.left); //recursively printing left subtree

            showPostOrderTraverseV2(root.right); //recursively printing right subtree

            //printing out the root in the end

            System.out.print(" " + root.data);
        }
    public void showLevelOrderTraverse(int level, Node<E> root)
    {
        if(level < 0)
        {
            System.out.println("Level out of range.");
            return;
        }

        if(root != null)
        {

            System.out.println(root.data);

            for(int i = 0; i < level; i++)
            {

                showLevelOrderTraverse(level + 1, root.right);

                showLevelOrderTraverse(level + 1, root.left);

                System.out.print(" ");
            }

        }
        else
        {
            for(int i = 0; i < level; i++)
            {
                System.out.print(" ");
            }
            System.out.println("null");
        }

    }
        //this method uses a queue to store all the elements of the tree and then print out in order when needed.
        public void showLevelOrderTraversalV2(Node<E> root)
        {
            Queue <Node<E>> queue = new LinkedList<Node<E>>();

            queue.add(root);

            while(queue.peek() != null)
            {
                Node<E> front = queue.poll();
                System.out.print(" " + front.data);

                if(front.left != null)
                {
                    queue.add(front.left);
                }

                if(front.right != null)
                {
                    queue.add(front.right);
                }
            }
        }

        public void preOrder()
        {
           showPreOrderTraverse(root,2);
           showPreOrderTraverseV2(root);
        }
    }

