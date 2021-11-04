import java.io.*;
import java.util.*;

public class RemoveDuplicates {

    /*
     * Use hashset!!
     * Runtime Complexity:
     * Linear, O(n) - where 'n' is length of the linked list.
     *
     * Memory Complexity:
     * Linear, O(n) - to store nodes in hashset.
     * */

    /*
    ListNode prev = null;
		ListNode curr = head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(curr != null){
			if(set.contains(curr.val)){
				prev.next = curr.next;
			}else{
				set.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
    */
    
    public static class LinkedList {

        private Node head;
        
        public Node removeDuplicates(Node head) {
            Node currentNode = head;

            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(currentNode.data);

            while (currentNode.next != null) {
                if(hashSet.contains(currentNode.next.data)) {
                    currentNode.next = currentNode.next.next;
                } else {
                    hashSet.add(currentNode.next.data);
                    currentNode = currentNode.next;
                }
            }
            return head;
        }

        public void print(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

        public static class Node {
            private int data;
            private Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    }


    public static void main(String [] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.head = new LinkedList.Node(1);
        linkedList.head.next =  new LinkedList.Node(1);
        linkedList.head.next.next =  new LinkedList.Node(3);
        linkedList.head.next.next.next = new LinkedList.Node(2);
        linkedList.head.next.next.next.next = new LinkedList.Node(3);
        linkedList.head.next.next.next.next.next = new LinkedList.Node(1);

        linkedList.print(linkedList.head);
        linkedList.head = linkedList.removeDuplicates(linkedList.head);
        System.out.println("");
        linkedList.print(linkedList.head);
    }
}


/* Output: 
 * 1 1 3 2 3 1 
 * 1 3 2
 */
