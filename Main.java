package ads2;

import java.util.Scanner;

public class Main
{
  
  public static void main(String[] args)
  {
    //All required data structures and algorithms must be defined in the classes files provide.
    //The main method is ONLY for you to test your classes.
    //You must keep evidence of your tests in this main method.
      
    /*Test your classes below */
  
    //VectorTest();
  
   
      //LList list = new LList();
      
      //LNode node = new LNode(null,null);
      /*
      
      LList myList = new LList();
      
      myList.AppendItem("Hello");
      myList.AppendItem("darkness");
      myList.AppendItem("my");
      myList.AppendItem("old");
      myList.AppendItem("friend");
  
      myList.InsertItem(2, "jesus");
      
      System.out.println(myList.ListAllIItem());
      //myList.DeleteItem(2);
      
      //System.out.println(myList.GetNoOfItems());
      */


/*
      LList list = new LList();


      list.AppendItem("1");
      list.AppendItem("2");
      list.AppendItem("3");
      list.AppendItem("4");
      list.AppendItem("5");



      list.InsertItem(1, "1000");

      System.out.println(list.ListAllIItem());



      list.DeleteItem(2);
*/
//        Sort sort;

       String[] data = {"pineapple", "Pango","apple", "Pomato", "tesus"};

    // Sort.insertionSort(data);


      Sort.insertionSort(data);


  }  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public static void VectorTest(){
  Scanner reader = new Scanner(System.in);
  Vector vector = new Vector();
  
     
      System.out.println("How many items would you like to add?: ");
       int amount = reader.nextInt();
      
       for (int i = 1; i <= amount; i++) {
          System.out.println("\nPlease enter the value to add: ");
          vector.AppendItem(reader.next());
      }
       
       vector.displayVector();
      System.out.println("Number of Items: " + vector.GetNoOfItems());

        System.out.println("How many items would you like to insert?: ");
        amount = reader.nextInt();
        
        for (int i = 1; i <= amount; i++) {
            System.out.println("\nPlease enter the INDEX then the VALUE: ");
            vector.InsertItem(reader.nextInt(), reader.next());
      }
        vector.displayVector();
        
        System.out.println("\nHow many items would you like to search?: ");
        amount = reader.nextInt();
        
        for (int i = 0; i < amount; i++) {
            int index = vector.FindItem(reader.next());
            if(index != -1){
            
                System.out.println("\nItem found at index: " + index);
            }
            else
                System.out.println("\nError item does not exist " + index);
          
      }
        vector.displayVector();  
        
        System.out.println("\nHow many values would you like to access by index: ");
        amount = reader.nextInt();
        
        for (int i = 1; i <= amount; i++) {
         
            System.out.println("\nPlease enter an index value: ");
            System.out.println(vector.GetItemByIndex(reader.nextInt()));
          
      }
      
  }
  
}
