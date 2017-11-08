package ads2;

/* This data structure should use outward-facing zero-based indexing.  To maintain 
 * the concept that there is a dummy header column at 0 (as per the lecture slides) 
 * you can simply add one to any row and column values passed into this class and 
 * keep this "slight of hand" behind the scenes and invisible to the outside world
 * This class uses SparseMatrixNode to hold the nodes and stores integer values
 */

// You may  find it useful to search out further reading related to "Sparse Matrix using Linked Lists"

public class SparseMatrix {
    //Define member variables of SparseMatrix class
    private SparseMatrixNode root;
    private int noOfRows, noOfCols;

    //Default Constructor
    public SparseMatrix()
    {
        noOfRows=noOfCols=0;

        root = new SparseMatrixNode(0,0,0,new SparseMatrixNode(0,0,0,null,null),new SparseMatrixNode(0,0,0,null,null));
    }
    
    
    //Optional: Create some helper methods below for your implementation.
    
    
    /* Initialises this data structure to have the specified number of rows and columns.
     * Any previous matrix held in this object is lost after this call.
    */
    public void Create(int noofrows, int noofcols)
    {
        this.noOfRows =noofrows;
        this.noOfCols = noofcols;

        root = new SparseMatrixNode(0,0,0,new SparseMatrixNode(noOfRows+1,0,0,null,null),new SparseMatrixNode(0,noOfCols+1,0,null,null));

    }

    /* Gets the size of this matrix 
     * It returns a pair holds in an integer array, the first element is the number 
     * of rows and the second element is the number of columns */
    public int[] GetSize()
    {
      int[] size = {this.noOfRows,this.noOfCols}; // size = {rows, columns}
      return size;
    }

    
    /* Sets the values at [row, col] 
     * Is the new value zero or non-zero?
     * Does a node already exist at [row, col]?
     * Does the row or column contain other non-zero entries?
     */
    public void SetValue(int row, int col, int value)
    {
        if(root.FindRow(row) == null) {
            createRow(row);
        }

        if(root.FindColumn(col) == null){
            createCol(col);
        }

        if(value == 0){


        }
        else
        {



        }

    }

    private void createRow(int row) {

    }

    private void createCol(int colume) {

    }



    /* Gets the value at [row, col]
     * E.G. Search down the dummy header column 0 looking for the specified row
     * If the row list doesn't exist then all entries along that row are zero
     * If the row list exists, search along it for the specified column
     */
    public int GetValue(int row, int col)
    {
      return 0;
    }
   
}
