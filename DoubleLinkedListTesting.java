public class DoubleLinkedListTesting
{
        public static void main(String[] args)
        {

            DoubleLinkedListPractice<String> myList = new DoubleLinkedListPractice<String>();
            myList.add(0, "A");
            myList.add(1, "C");
            myList.add(2, "D");
            myList.add(3, "E");
            myList.traverse();
            myList.add(1, "B");
            myList.add(5, "F");
            myList.add(6, "G");
            myList.traverse();
            DoubleLinkedListPractice<String> myList2 = new DoubleLinkedListPractice<String>();
            //myList2.add(0, "I");
            //myList2.add(1, "J");
            //myList2.add(2, "K");
            myList2.add(0, "M");
            myList2.add(1, "O");
            myList2.add(2, "N");
            myList2.add(3, "P");
            myList2.add(4, "K");
            myList2.add(5, "L");
            myList2.traverse();

            //Project: add testing code below to test your remove methods
            System.out.println("Original list is: ");
            myList2.traverse();

            myList2.removeFirst();
            System.out.println("The new list when removing the head is: ");
            myList2.traverse(); //traversing to test

            myList2.removeLast();
            System.out.println("The new list when removing the tail is: ");
            myList2.traverse(); //traversing to test


            myList2.remove(4);
            System.out.println("The new list when removing the node at the specified index is: ");
            myList2.traverse(); //traversing to test
            myList2.reverseList();
            System.out.println("The new value ot the linked list is: ");
            myList2.traverse();


        }
    }

