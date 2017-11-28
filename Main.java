package ads2;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //All required data structures and algorithms must be defined in the classes files provide.
        //The main method is ONLY for you to test your classes.
        //You must keep evidence of your tests in this main method.
      
    /*Test your classes below */










        Scanner reader = new Scanner(System.in);
        boolean test = true;
        int switchSelect;
        String selectDecision;
        
        while(test)
        {
            System.out.println("\n0: Vector");
            System.out.println("1: Queue");
            System.out.println("2: LinkedList");
            System.out.println("3: HashMap");
            System.out.println("4: SparseMatrix");
            System.out.println("5: Sort");

            System.out.println("\nPlease enter the corresponding number 0-5: ");
            switchSelect = reader.nextInt();

            switch (switchSelect){
                case 0:
                    // VectorTest();
                    break;
                case 1:
                    //QueueTest();
                    break;
                case 2:
                    //LlistTest();
                        break;
                case 3:
                    //hashTest();
                    break;
                case 4:
                    //sparseMatrixTest();
                    break;
                case 5:
                    //sortTest();
                    break;
                default:
                    System.out.println("\nERROR PLEASE SELECT NUMBER 0-5");
                    break;

            }
                System.out.println("\nWould you like to continue? (Y/N)");
                selectDecision = reader.next();

            if(selectDecision.toUpperCase().charAt(0) == 'N')
            test = false;
        }

    }


    public static void VectorTest() {
        Scanner reader = new Scanner(System.in);
        Vector vector = new Vector();


        System.out.println("How many items would you like to add?: ");
        int amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {
            System.out.println("\nPlease enter the value to add: ");
            vector.AppendItem(reader.next());
        }

        vector.displayVector();
        System.out.println("\nNumber of Items: " + vector.GetNoOfItems());

        System.out.println("\nHow many items would you like to insert?: ");
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
            if (index != -1) {

                System.out.println("\nItem found at index: " + index);
            } else
                System.out.println("\nError item does not exist " + index);

        }
        vector.displayVector();

        System.out.println("\nHow many values would you like to access by index: ");
        amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {

            System.out.println("\nPlease enter an index value: ");
            System.out.println(vector.GetItemByIndex(reader.nextInt()));

        }

        System.out.println("\nVector capacity = " + vector.GetCapacity());

    }

    public static void QueueTest() {
        Scanner reader = new Scanner(System.in);
        ADS2Queue queue = new ADS2Queue();


        System.out.println("How many items would you like to add?: ");
        int amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {
            System.out.println("\nPlease enter the value to push: ");
            queue.Push(reader.next());
        }


        System.out.println("Number of Items: " + queue.GetNoOfItems());

        System.out.println("How many items would you like to pop?: ");
        amount = reader.nextInt();

        for (int i = 1; i <= amount; i++) {

            System.out.println(queue.Pop());
        }

        System.out.println("Number of Items: " + queue.GetNoOfItems());


    }

    public static void LlistTest() {
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

        System.out.println("\nNumber of items in linked list: " + list.GetNoOfItems());

        System.out.println("\nEnter an index to look up the data value: ");
        amount = reader.nextInt();
        System.out.println(list.GetItemByIndex(amount));


    }

    public static void hashTest() {
        HashMap hash = new HashMap(50000);


        hash.AddItem("meme", "50");
        hash.AddItem("meme", "100");


        System.out.println(hash.SearchValue("meme"));
        System.out.println(hash.SearchValue("key"));

    }

    public static void sparseMatrixTest() {
        SparseMatrix matrix = new SparseMatrix();
        Scanner reader = new Scanner(System.in);
        int amount;


        matrix.Create(4, 4);

        DisplayMatrix(matrix);

        System.out.println("\nThe size of the matrix is: " + matrix.GetNoOfCols() + "x" + matrix.GetNoOfRows());

        System.out.println("\nHow many values would you like to add?: ");
        amount = reader.nextInt();
        while(amount > (matrix.GetNoOfCols()*matrix.GetNoOfRows())) {
            System.out.println("\nPlease try again: ");
            amount = reader.nextInt();
        }

        for (int i = 1; i <= amount ; i++) {
            System.out.println("\nPlease enter the ROW, COLUMN, VALUE: ");
            matrix.SetValue(reader.nextInt(),reader.nextInt(),reader.nextInt());
            DisplayMatrix(matrix);
        }

        System.out.println("\nHow many values would you to search for: ");
        amount = reader.nextInt();

        for (int i = 1; i <=amount ; i++) {
            System.out.println("\nPlease enter the ROW,COLUMN of the value: ");
            System.out.println(matrix.GetValue(reader.nextInt(),reader.nextInt()));
            DisplayMatrix(matrix);
        }

    }

    private static void DisplayMatrix(SparseMatrix matrix) {
        System.out.println("\n\n");
        for (int j = 1; j <= matrix.GetNoOfRows(); j++) {
            for (int i = 1; i <= matrix.GetNoOfCols(); i++)
                System.out.print(matrix.GetValue(j, i) + " ");
            System.out.println("");
        }


    }

    public static void sortTest(){
        Scanner reader = new Scanner(System.in);
        int amount;



        System.out.println("\nHow many words: ");
        amount = reader.nextInt();

        String[] words = new String[amount];

        for (int i = 0; i < words.length; i++) {
            System.out.println("\nPlease enter a word: ");
            words[i] = reader.next();
        }

        Sort.insertionSort(words);
        Sort.mergeSort(words);
    }

}
