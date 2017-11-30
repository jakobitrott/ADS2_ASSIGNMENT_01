package ads2;



public class Sort
{
  /* Takes an array of String items and sorts them into ascending alphabetical order (A to Z).
   * The sort is not case sensitive, i.e. ZOO and zoo are considered the same.
   * The input data array is full (i.e. every valid index contains a String).
   * When this function completes, the data array will contain the sorted data 
   * items */
    
    //Apple Ant
  
  // NOTE: This is a class method since the signature includes the keyword static
  // You must complete two sorting algorithms, i.e. insertion and merge sort
  
    
    
   /* Use binary search to locate the insert position */
    public static void insertionSort(String[] data)
  {
      int j,location;
      String key;


      for (int i = 1; i < data.length; ++i) {

          j = i-1; //insert the one previous

          key = data[i]; //get the string value

          location = BinarySearch(data,key,0,j); //find position to insert at

          while(j>=location){

              data[j+1] = data[j]; //reshuffle
              j--;
          }
          data[j+1] = key;
      }


  }

    /* Implement the bottom-up merge sort algorithm for String items */
    public static void mergeSort(String[] data)
  {
      if(data.length >= 2){

          String[] left = new String[data.length/2];
          String[] right = new String[data.length - data.length/2];

          for (int i = 0; i < left.length; i++) {
              left[i] = data[i];

          }
          for (int i = 0; i < right.length; i++) {
              right[i] = data[i+data.length /2];

          }

          mergeSort(left);
          mergeSort(right);

          merge(data,left,right);


      }


  }

    private static void merge(String[] result, String[] left, String[] right){
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < result.length; i++) {
            if(index2 >= right.length ||(index1 < left.length && left[index1].compareToIgnoreCase(right[index2])<0)){
                result[i] = left[index1];
                index1++;
            }
            else
            {
                result[i] = right[index2];
                index2++;
            }

        }



    }

    public static void display(String[] data){
        for(int i=0;i<data.length;i++)
            System.out.println(i+" : "+data[i]);
    }






    private static int BinarySearch(String data[], String item,int start, int end){


        int mid = (start+end)/2;
        int itemChar = item.toLowerCase().charAt(0);
        int midChar = data[mid].toLowerCase().charAt(0);
        int starChar = data[start].toLowerCase().charAt(0);


        if(end< start)
        return(itemChar > starChar)? (start+1):start;

        if(itemChar == midChar) //write a loop to check next characters
        {
            int i = 0;

            while(item.toLowerCase().charAt(i) == data[mid].toLowerCase().charAt(i)) {
                i++;
                if(item.toLowerCase().charAt(i) > data[mid].toLowerCase().charAt(i))
                {
                    return BinarySearch(data,item,mid+1,end);
                }

                if(item.toLowerCase().charAt(i) < data[mid].toLowerCase().charAt(i))
                {
                    return BinarySearch(data,item,start,end-1);
                }

            }

            return mid+1;
            }



        if(itemChar > midChar)
            return BinarySearch(data,item,mid+1,end);

        return BinarySearch(data,item,start,end-1);

    }

}
