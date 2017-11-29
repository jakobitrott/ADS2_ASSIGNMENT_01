package ads2;

/* This data structure represents a queue.
 * You should hold the underlying data using doubly linked list.
 * You must use QueueNode class
 */

public class ADS2Queue
{
  //Define member variables of ADS2Queue class
  /* You should define some trackers to locate the heads and tails of underlying
   * doubly linked list. */

  public QueueNode myNode;
  public QueueNode head;
  public QueueNode tail;
  public int size = 0;


  // Default Constructor
  public ADS2Queue()
  {
    head = null;
    tail = null;
    myNode = new QueueNode(null);

  }
  
  //Optional: Create some helper methods below for your implementation.
  
  
  
  
  /* Return the number of items contained within this data structure */
  public int GetNoOfItems()
  {
    return size;
  }
  
  // Returns true if the queue is empty else false if there are items available
  public boolean IsEmpty()
  {
    return (head == null);
  }
  
  /* Gets the next item from the queue (remember First-in, First-out) 
  /* or null if there are no more items.
   * You should renew your trackers inside this method */
  public String Pop()
  {


    if(head == tail.next)
      return "nothing to pop";

    QueueNode tracker = head;
    head = tracker.next;
    tracker.prev = head;

    size--;
    return ("Popping: " + tracker.data);



  }
  
  /* Adds value to the queue  (remember First-in, First-out).
   * You should renew your trackers inside this method */
   public void Push(String value)
  {
    QueueNode Node_x = new QueueNode(value);
    Node_x.data = value;
    Node_x.next = null;

    if(IsEmpty())
    {
      head = Node_x;
      tail = Node_x;
      head.prev = null;

    }

    else{
      tail.next = Node_x;
      Node_x.prev = tail;

      tail = Node_x;


    }
    size++;
  }
  
  
}
