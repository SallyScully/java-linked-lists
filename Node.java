import java.util.*;
import java.lang.*;
import java.io.*; 

//Node class
public class Node {

    int data;
    Node prev;
    Node next;

    public Node(int data)
    {
        this.data = data;
        this.prev = null;
        this.next = null;

    }
    



   //A doubly linked list class 
   class DoublyLinkedList {
    Node head;
    Node tail;
    
   //constructor to initialize head and tail to null      
        DoublyLinkedList ()
          {
          this.head = null;
          this.tail = null;
          }
    


      //Traverse from head to the end of the list
         public void traverseForward()
         {
            Node current= head;
             while (current != null) {
                System.out.print(current.data + "");
               current = current.next;
              }//end while
         }
      
         //Traverse from tail to head
         public void traverseBackward()
         {
          Node current = tail;
          while (current != null) {
            System.out.print(current.data + "");
            current = current.prev;
          }//end while
         }//end traverseBackward
         
         //Insert a node the  front of a list
         public void insertAtBeginning(int data)
         {
         //create new node
         Node temp = new Node(data);
         if(head == null) {
            head = temp;
            tail = temp;
         }
         //if the current head is not null
         else {
            //set the next pointer of the new node to the current head
            temp.next = head;
            //set the previous pointer of the current head to point to the new nose
            head.prev = temp;
            //assign temp as the new head (or the first node)
            //temp.prev is already set to null via the Node constructor
            head = temp;
         }
         
         }//end insertAtBeginning
         
         public void insertAtEnd(int data)
         {
         Node temp = new Node(data);
           //if the list is empty
            if(tail == null) {
             head = temp;
               tail = temp;
             }
             //if the list is not empty
            else {
             //next pointer of tail points to new node
               tail.next = temp;
               //previous pointer of new node points to tail
               temp.prev = tail;
              //new node is the last node
               tail = temp;
             }
         }//end insertAtEnd
         
         
         
         
         public void insertAtPosition(int data, int position) {
         
            Node temp = new Node(data);
            
            //if position is 1, use method to insert at beginning
            if (position == 1) {
               insertAtBeginning(data);
            }
            else {
               Node current = head;
               //tracker to traverse to node in position
               int currPosition = 1;
               //traverse through list until reach given position
               while(current != null && currPosition < position) {
               current = current.next;
               currPosition++;
               
               }
          
            
            //if current points to null, indicates the node is last
           if(current == null){
           insertAtEnd(data);
           }
           else {
                  temp.next = current;
                  temp.prev = current.prev;
                  current.prev.next  = temp;
                  current.prev = temp;
                }// end second, inner else 
             }//end first, outer else 
         }//end insertAtPosition
         
         
         
         
         public void deleteAtBeginning()
         {
          //if empty list, return
          if(head == null) {
          return;
          }
          
          //if only one node, set both head and tail to null
          if(head == tail)  {
          head = null;
          tail = null;
          return;
          }
          
          //temp node to preserve original head to be deleted
          Node temp = head;
          //set the 'head' to be the node after the one to be deleted
          head = head.next;
          //set this new head to point to null, again to show it is now the first node
          head.prev = null;
          //temp, which was the former first node is cut off, by setting its next ponter to null
          temp.next = null;
          
         }//end deleteAtBeginning()
         
         public void deleteAtEnd()
         {
         if(tail == null) {
         return;
         }
         
         if(head == tail) {
         head = null;
         tail = null;
         }
         Node temp = tail;
         tail = tail.prev;
         tail.next = null;
         temp.prev = null;
         
         
         }//end deleteAtEnd

      }//end DoublyLinkedList class

}//end Node class
