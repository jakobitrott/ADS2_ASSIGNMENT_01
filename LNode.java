package ads2;

/* This class is used within the LList data collection as the link nodes.
 * The items are String objects.
 * This is a singly linked list node*/
public class LNode
{
    public String data;
    public LNode next;
    
    //constructor
    public LNode(String newData, LNode nextNode){
        System.out.println("LNode constructor called");
        this.data = newData;
        this.next = nextNode;
    }
  /* This method returns the String item of data held in this node */
  public String GetDataItem()
  {
    return this.data;
  }
   
  /* This method returns the node immediately after this node in the list or null
   * if there is no such node. */
  public LNode GetNextNode()
  {
      if(this.next != null)
      {
        return this.next;
      }
      else
          return null;
    
  }

}