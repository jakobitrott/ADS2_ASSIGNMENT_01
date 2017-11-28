package ads2;

/*This class defines the behaviour of a Vector where the items in the collection
 *are String objects. */



//TODO TODO TODO TODO TODO
//implement shift right into the vector array


public class Vector
{
  // Define member variables of Vector
    private int maxCapacity = 6;
    private int growByAmount;
    private String[] myArray;
    private int length = 0;
  
  // Default Constructor function
  public Vector()
  { 
        System.out.println("Constructor Called");
        this.length = length;
        this.maxCapacity = maxCapacity;
        myArray = new String[maxCapacity];
  }
  
  
  //Optional: Create some helper methods below for your implementation.
  
      /* Sets how much this vector should grow by when it needs resizing.  A sensible
     * default growby value should be used in your implementation */
    private void SetGrowBy(int growby) {

        growByAmount = maxCapacity * growby;
    }


  
  
  
  /* Returns the vector's maximum capacity before it will need to resize again.
   * This is not the number of items in the vector or the number of remaining free slots, 
   * but the current max capacity - i.e. the length of the underlying data array. */
  public int GetCapacity()
  {
   return (maxCapacity);
  }
  
  /* Returns the number of items in the vector. 
   * This method do not count the number of remaining free slots of the underlying 
   * array */
  public int GetNoOfItems()
  {
     return length;
  }
  
  /* Returns the String value held at index (base zero) or null if the index
   * is out of bounds */
  public String GetItemByIndex(int index)
  {
      if(index < length) //length or maxcapacity??
   return(myArray[index]);
      else
    return null; 
  }

  
  /* Use linear search algorithm
   * Returns the index (base zero) of the first item found in the collection that
   * matches the value passed in, or -1 if no such item exists.
   * String matches are not case sensitive. */
  public int FindItem(String search)
  {
      for (int i = 0; i < myArray.length; i++) {
          if(search.equals(myArray[i])){
          
              return i;
          }
          
      }
     
      
    return -1;
  }
  
  
  /* Appends value to the Vector collection of data items. 
   * The method need to grow the underlying array space automatically when the maximum 
   * capacity is reached */
  public void AppendItem(String value)
  {
      
        if (length < maxCapacity) {
            myArray[length] = value;
            ++length;
        } else if (length == maxCapacity) {
            resizeArray(value);
        }
      
      
  }
  
  private void resizeArray(String value){
  
     System.out.println("\nresizing array...");
            SetGrowBy(2);
            String[] newArray = new String[growByAmount];


            for (int i = 0; i < myArray.length; i++) {
                newArray[i] = myArray[i];

            }

            newArray[length] = value;
            ++length;

            maxCapacity = growByAmount;
            myArray = newArray;


  
  }
  
  /* Inserts the item at index from the data structure. 
   * If index is out of bounds then insert the item at the end of the vector.
   * The method need to grow the underlying array space automatically when the maximum 
   * capacity is reached */
  public void InsertItem(int index, String value)
  { 
      
      if (GetNoOfItems() == 0) {

            myArray[0] = value;
        }
        else
            if(GetNoOfItems() < GetCapacity()) {


                for (int i = GetNoOfItems()-1; i >= index ; --i) {
                    myArray[i+1] = myArray[i];
                    myArray[i] = value;
                }
                ++length;

            }
            else
                if(GetNoOfItems() == GetCapacity()){

                    resizeArray(null);
                    for (int i = GetNoOfItems()-1; i >= index ; --i) {
                        myArray[i+1] = myArray[i];
                        myArray[i] = value;
                    }
                    ++length;

                }






  }
  
  public void displayVector(){
  
      for (int i = 0; i < myArray.length; i++) {
          if(myArray[i] != null)
          System.out.println("\nPosition:"  + i + " " + myArray[i]);
          
      }
  
  }
  
  
}


/*

insert value at element. 


Shift the array to the right. If maxCapacity + 1 is reached. Resize the array.


  for( int index =myArray.length-1; index >= 0 ; index-- )
        myArray[i+1] = myArray[index];



*/