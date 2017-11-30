package ads2;

import java.util.Scanner;

public class Main {

    /*
            Jakob Trott - b5015250

    *       NOTES FOR JING
    *       ----------------
    *
    *       - Hash function is't working properly but I hope I can get some marks for it
    *       - Sorry that I didn't comment any of it. If you don't understand my logic email me
    *
    *
    *
    *
    *
    * */


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
            System.out.println("1: LinkedList");
            System.out.println("2: HashMap");
            System.out.println("3: Sort");
            System.out.println("4: Queue");
            System.out.println("5: SparseMatrix");

            System.out.println("\nPlease enter the corresponding number 0-5: ");
            switchSelect = reader.nextInt();

            switch (switchSelect){
                case 0:
                    VectorTest();
                    break;
                case 1:
                    LlistTest();
                    break;
                case 2:
                    hashTest();
                    break;
                case 3:
                    sortTest();
                    break;
                case 4:
                    QueueTest();
                    break;
                case 5:
                    sparseMatrixTest();
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


        System.out.println("\nNumber of items in linked list: " + list.GetNoOfItems());
        System.out.println(list.ListAllIItem());
        System.out.println("\nEnter an index to look up the data value: ");
        amount = reader.nextInt();
        System.out.println(list.GetItemByIndex(amount));


    }

    public static void hashTest() {
        HashMap hash = new HashMap(50);
        Scanner reader = new Scanner(System.in);
        int amount;
        String key;


        System.out.println("\nHow many items would you like to add to the hashmap: ");
        amount = reader.nextInt();


        for (int i = 0; i < amount; i++) {
        System.out.println("\nPlease enter a key followed by a value: ");
        hash.AddItem(reader.next(),reader.next());
        }

        //hash.printHashMap();

        System.out.println("\nHow many items would you like to search?: ");
        amount = reader.nextInt();

        for (int i = 0; i < amount ; i++) {

            System.out.println("\nEnter a key to search:");
            key = reader.next();
        System.out.println(hash.SearchValue(key));
        }

        System.out.println("\nHow many items would you like to delete?: ");
        amount = reader.nextInt();

        for (int i = 0; i < amount; i++) {

            System.out.println("\nEnter a key to delete: ");
             key = reader.next();
             hash.DeleteItem(key);

        }



    }

    public static void sortTest(){
        Scanner reader = new Scanner(System.in);
        int amount;



        System.out.println("\nHow many words for insertion sort: ");
        amount = reader.nextInt();

        String[] words = new String[amount];

        for (int i = 0; i < words.length; i++) {
            System.out.println("\nPlease enter a word: ");
            words[i] = reader.next();
        }
        Sort.display(words);
        Sort.insertionSort(words);
        System.out.println("\n");
        Sort.display(words);

        System.out.println("\nHow many words for binary sort: ");
        amount = reader.nextInt();

        String[] words1 = new String[amount];

        for (int i = 0; i < words1.length; i++) {
            System.out.println("\nPlease enter a word: ");
            words1[i] = reader.next();
        }

        Sort.display(words1);
        Sort.mergeSort(words1);
        System.out.println("\n");
        Sort.display(words1);
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


    public static void sparseMatrixTest() {
        SparseMatrix matrix = new SparseMatrix();
        Scanner reader = new Scanner(System.in);
        int amount;

        System.out.println("Please enter the size of matrix you'd like to create (ROW,COL): ");
        matrix.Create(reader.nextInt(), reader.nextInt());

        DisplayMatrix(matrix);

        System.out.println("\nThe size of the matrix is: " + matrix.GetNoOfCols() + "x" + matrix.GetNoOfRows());

        System.out.println("\nHow many values would you like to add?: ");
        amount = reader.nextInt();
        while(amount > (matrix.GetNoOfCols()*matrix.GetNoOfRows())) {
            System.out.println("\nPlease try again: ");
            amount = reader.nextInt();
        }

        for (int i = 1; i <= amount ; i++) {
            System.out.println("\nPlease enter the ROW, COLUMN, VALUE in the specified range: ");
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



}
