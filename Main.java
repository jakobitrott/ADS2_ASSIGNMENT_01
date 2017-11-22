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
  
    //QueueTest();

    LlistTest();


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

    public static void QueueTest(){
        Scanner reader = new Scanner(System.in);
       ADS2Queue queue = new ADS2Queue();


        System.out.println("How many items would you like to add?: ");
        int amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {
            System.out.println("\nPlease enter the value to push: ");
            queue.Push(reader.next());
        }


        System.out.println("Number of Items: " +queue.GetNoOfItems());

        System.out.println("How many items would you like to pop?: ");
        amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {

            System.out.println(queue.Pop());
        }

        System.out.println("Number of Items: " +queue.GetNoOfItems());



    }

    public static void LlistTest(){
        Scanner reader = new Scanner(System.in);
        LList list = new LList();


        System.out.println("How many items would you like to add?: ");
        int amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {
            System.out.println("\nPlease enter the value to push: ");
            list.AppendItem(reader.next());
        }


        System.out.println(list.ListAllIItem());

        System.out.println("How many items would you like to insert?: ");
        amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {

            System.out.println("\nPlease enter the INDEX then the VALUE: ");
            list.InsertItem(reader.nextInt(), reader.next());
        }

        System.out.println(list.ListAllIItem());

        System.out.println("How many items would you like to delete?: ");
        amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {

            System.out.println("\nPlease enter the INDEX: ");
            list.DeleteItem(reader.nextInt());
            System.out.println(list.ListAllIItem());
        }
        System.out.println(list.ListAllIItem());


    }


}
