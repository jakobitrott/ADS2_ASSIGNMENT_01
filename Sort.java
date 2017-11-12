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

          j = i-1;

          key = data[i];

          location = BinarySearch(data,key,0,j);

          while(j>=location){

              data[j+1] = data[j];
              j--;
          }
          data[j+1] = key;
      }

      for(int i=0;i<data.length;i++)
          System.out.println(i+" : "+data[i]);
  }


    
    
    /* Implement the bottom-up merge sort algorithm for String items */
    public static void mergeSort(String[] data)
  {


  }





    public static int BinarySearch(String data[], String item,int start, int end){


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

            //apple ant

    }

}
