package ads2;

/* This class is used within the ADS2Queue data collection as the doubly link nodes.
 * The items are String objects.
 * This is a doubly linked list node for constructing queues */
public class QueueNode {
  //Define member variables of QueueNode class.
    public String data;
    public QueueNode prev;
    public QueueNode next;

  //Default Constructor function
    public QueueNode(String data){

        this.data = data;
        prev = null;
        next = null;
    }
    
  //Optional: Create some helper methods below for your implementation.


    public QueueNode getNextNode(){
        if(this.next != null){

            return this.next;
        }
        else
            return null;

    }


    public QueueNode getPrevNode(){

        if(this.prev != null){

            return this.prev;
        }
        else
            return null;

    }
}
