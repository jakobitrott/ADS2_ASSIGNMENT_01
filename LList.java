package ads2;
  
/*
 * This data structure for a collection will store String objects
 * While this is the class that makes Singly-linked list functions available, you 
 * should implement the LNode class to do the bulk of the behaviour using recursion method.  
 * You will have very similar method names in your node class which this class calls 
 * upon if this class's root node is valid.
 */


//TODO TODO TODO TODO TODO
//INSERT ITEM BREAK AND RECONNECT

public class LList
{
  //Define member variables of LList class  
    private LNode myNode  = new LNode(null,null);
    private int length = -1;
  
  //Default constructor
  public LList()
  {
     System.out.println("LList Constructor Called");
      
  }
  
  //Optional: Create some helper methods below for your implementation.
 
   

  /* Return the number of items contained within this data structure.
   * Use recursion to count the number of nodes in the linked list */
  public int GetNoOfItems()
  { 
    return  GetNoOfItems(length,myNode);
  }
  
 private int GetNoOfItems(int length, LNode tracker){
     if(tracker != null){
          
          tracker = tracker.next;
          
          ++length;
          GetNoOfItems(length,tracker);
     }
      return length;
 }

  /* Returns the String value held at index (base zero) or null if the index
   * is out of bounds. 
   * Use recursion to access index n*/
  public String GetItemByIndex(int index)
  {
    return null;
  }
  
  
  /* Appends new String object to the end of the data structure 
   * This method must be able to append new items as head if the current list is empty */
  public void AppendItem(String value)
  {
         if(myNode.data == null){
         //first data value
         myNode.data = value;
         
      }
      else
      {
          //not the first
          
          LNode tracker = myNode;
          
          while(tracker.next != null) tracker = tracker.next;
          
         
            tracker.next = new LNode(value,null);
           
      }
      
      ++length;
      
      
  }
  
  /* Insert new String object into the data structure at index (base zero) or at the end
   * if there are less items in the data structure than index.
   * The method must be able to insert new items at head of the linked list 
   * This method must be able to insert new items as head if the current list is empty */
  public void InsertItem(int index, String value) //break logic links, reconnect
  {
      LNode tracker = myNode;
      
      if(index > length){
          System.out.println("Index is less than length!");
          AppendItem(value);
      }
      
      for (int i = 0; i < length; i++) {
          if(i == index){
              LNode newNode = tracker;
            
              System.out.println(tracker.data + " BAZINGA");
              
              tracker.next = newNode.next;
             newNode.data = value;
             
            
             
            
              
              length++;
          }
          else
          {
              tracker = tracker.next;
          }
          
      }
      
  }

  /* Removes the item at index from the data structure - if index is out of
   * bounds then the data structure remains unchanged */  //TODO: break logic links, reconnect
  public void DeleteItem(int index)
  {
      
       LNode tracker = myNode;
      
      for (int i = 0; i < length; i++) {
          if(i == index){
              tracker.data = null;
          }
          else
          {
              tracker = tracker.next;
          }
          
      }
      --length;
      
  }
  
  public String ListAllIItem()
  {
      
      LNode tracker = myNode;
      String listAll = "";
      
      for (int i = 0; i < length; i++) {
          listAll += tracker.data;
          if(tracker.next != null) { listAll += " + ";}
          tracker = tracker.next;
          
      }
      return listAll;
  }

  
}
