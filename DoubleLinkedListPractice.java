public class DoubleLinkedListPractice<E> {
    //Generics
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        private Node(E value) {
            data = value;
            next = null;
            prev = null;
        }

        private Node(E value, Node prevItem, Node nextItem) {
            data = value;
            prev = prevItem;
            next = nextItem;
        }
    }

    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public DoubleLinkedListPractice() {
        head = null;
        tail = null;
//constructed an empty double linkedlist
    }

    private void addFirst(E value) {
        if (size == 0) {
            head = new Node<E>(value);
            tail = head;
        } else {
            head = new Node<E>(value, null, head);
        }
        size++;
    }

    private void addLast(E value)
    {
        if(size == 0)
        {
            System.out.println("Index is empty");
        }
        else
        {
            Node<E> newNode = new Node<E>(value, tail, null);
            tail = newNode;
        }
        size++;

    }
    private Node<E> getRef2Node(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> ref = head;
        for (int i = 0; i < index; i++) {
            ref = ref.next;
        }
        return ref;
    }

    public void add(int index, E value)
    {
        if (index == 0)
        {
        addFirst(value);
        }
        else
        {
            if (index == size)
            {
                addLast(value);
            }
            else
            {
                Node<E> ref = getRef2Node(index);
                Node<E> newnode = new Node<E>(value, ref.prev, ref);
                ref.prev.next = newnode;
                ref.prev = newnode;
                size++;
        }
        }
    }
    public void traverse()
    {
        if (size > 0)
        {
            Node<E> ref = head;
            while (ref != null) {
                System.out.print(ref.data + " ");
                ref = ref.next;
            }
            System.out.println();
            ref = tail;
            while (ref != null) {
                System.out.print(ref.data + " ");
                ref = ref.prev;
            }
            System.out.println();
        }
    }

    //Project: Implement the following methods

    //this method removes the head of the linked list via a pointer to the next Node. It then returns the data of the removed Node. If the index
    //is only 1, then it renders the current head null and returns null.
    public E removeFirst()
    {
        //the data of the Node to be removed

        E index;
        if (size > 0)
        {
            if (size == 1)
            {
                head = null;
                size--;
                return null;
            }
            Node<E> CurrentNode = head.next;
            index = CurrentNode.prev.data;

            CurrentNode.prev = null;
            head = CurrentNode; //update of the head
        }
        else
        {
            System.out.println("This list is empty.");
            return null;
        }
        size--;
        return index;

    }

    //this method removes the tail of the linked list via a pointer to the previous Node. It then returns the data of the removed Node If the index
    //is only 1, then it renders the current tail null and returns null.
    public E removeLast()
    {
        if (size > 0)
        {
            Node<E> currentNode = tail.prev;
            if (size == 1)
            {
                tail = null;
                size--;
                return null;
            }
            E index = currentNode.next.data;
            currentNode.next = null;
            tail = currentNode; //update the tail
            size--;
            return index;
        }
        //else if(size == 1)
        //{
        //Node<E>currentNode = tail.prev;
        //}
        else
        {
            System.out.println("This list is empty.");
            return null;
        }
    }

    //The remove method removes the Node at the specified index by changing the previous
    //pointer of the succeeding node and the subsequent pointer of the preceding node.
    public E remove(int index) {
        //checking if the index is in bounds, if not it returns an error message
        if (index < 0 || index > size - 1) {
            System.out.println("Index out of range.");
            return null;
        } else if (size > 0) {
            Node<E> currentNode = head.next;
            Node<E> reverseNode = tail.prev;
            int count = 0;
            if (size == 1) {
                head = null;
                size--;
                return null;
            } else if (index == 0) {
                E data = currentNode.prev.data;
                currentNode.prev = null;
                head = currentNode;
                size--;
                return data;
            } else if (index == size - 1) {
                E data = reverseNode.next.data;
                reverseNode.next = null;
                tail = reverseNode; //updating the tail
                size--;
                return data;
            }
            Node<E> prevNode = currentNode.prev;
            count++;
            while (currentNode != null) {
                if (count == index) {
                    E data = currentNode.data;
                    prevNode.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                    size--;
                    return data;
                }
                count++;
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        } else {
            //if it reaches the end of the list, the index is not in the list
            System.out.println("This list is empty.");
        }
        return null;
    }
        public void reverseList()
        {
            Node <E> temp = null;

            Node <E> curr = head;

            while (curr != null)
            {
                temp = curr.prev;
                curr.prev = curr.next;
                curr.next = temp;
                curr = curr.prev;
            }
            if (temp != null)
            {
                head = temp.prev;
            }

        }
    }


