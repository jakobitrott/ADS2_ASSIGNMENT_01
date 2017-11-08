package ads2;

/* Use this class to hold node information within the Sparse Matrix data structure 
 * Sparse matrices hold integer numbers*/
public class SparseMatrixNode {
  //Define member variables of SparseMatrixNode class
    public int row, col, value;
    public SparseMatrixNode down,across;


  //Default Constructor function
    public SparseMatrixNode(int row, int col, int value, SparseMatrixNode down, SparseMatrixNode across){
        this.row = row;
        this.col = col;
        this.value = value;
        this.down = down;
        this.across = across;


    }

    public SparseMatrixNode FindRow(int row){


        if (this.row == row){
            return this;
        }
        else
            return(this.down==null? null: this.down.FindRow(row));
    }
    
  //Optional: Create some helper methods below for your implementation.
    public SparseMatrixNode FindColumn(int col){

        if(this.col==col){
            return this;
        }
        else
            return(this.across ==null? null: this.across.FindRow(row));

    }

    public SparseMatrixNode GetRowTerminator(){return (across==null?this:across.GetRowTerminator());}


    public String toString(){

        String res = "["+row+", "+col+", "+value+"] ";

        if(across!=null)
            res+=across;
        return res;
    }


}
