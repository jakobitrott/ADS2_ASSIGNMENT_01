package ads2;

/* This data structure should use outward-facing zero-based indexing.  To maintain 
 * the concept that there is a dummy header column at 0 (as per the lecture slides) 
 * you can simply add one to any row and column values passed into this class and 
 * keep this "slight of hand" behind the scenes and invisible to the outside world
 * This class uses SparseMatrixNode to hold the nodes and stores integer values
 */

// You may  find it useful to search out further reading related to "Sparse Matrix using Linked Lists"
class SparseMatrix {
    private SparseMatrixNode root;
    private int maxRows, maxCols;

    public SparseMatrix()
    {
        maxRows = maxCols =0;


        root=new SparseMatrixNode(0, 0, 0, new SparseMatrixNode(0, 0, 0, null, null), new SparseMatrixNode(0, 0, 0, null, null));
    }

    public void Create(int noofrows, int noofcols)
    {
        this.maxRows =noofrows;
        this.maxCols =noofcols;
        root=new SparseMatrixNode(0, 0, 0, new SparseMatrixNode(noofrows+1, 0, 0, null, null), new SparseMatrixNode(0, noofcols+1, 0, null, null));
    }

    public int GetNoOfRows()
    {
        return maxRows;
    }

    public int GetNoOfCols()
    {
        return maxCols;
    }


    public int GetValue(int row, int col)
    {
        SparseMatrixNode current;                     //used to travel through the sparse matrix
        int value = 0;                      // return value

        current = FindNode(row,col);       //finds the node at the row and column if it exists


        if(current != null)
            value = current.value;          //if node was found value changes


        return value;
    }

    private SparseMatrixNode FindNode(int row, int col)
    {

        SparseMatrixNode node=root.FindRow(row);


        return (node==null?null:node.FindColumn(col)); //returns a node if found, if not returns null
    }



    public void SetValue(int row, int col, int value)
    {

        SparseMatrixNode previous = null; //manages the link between nodes
        SparseMatrixNode current;         //the node we use to travel


        current = FindNode(row,col); //makes the current node the old one

        if(current != null) { //if one exists it changes its value

            current.value = value;

            if (current.value == 0) {  //if it changes the value to 0 it removes the node

                findDown(row, col).down = current.down; //skips over the node in the column

                findAcross(row, col).across = current.across; //skips over the node in the row

                if (isRowEmpty(row)) //if the row is now empty it deletes it
                    deleteRow(row);

                if (isColEmpty(col)) //if column is now empty it deletes it
                    deleteCol(col);
            }
        }
        else //if the node doesn't exist it will be created
        {
            if(FindNode(row,0) == null)
                createRow(row);
            if(FindNode(0,col) == null)
                createColumn(col);

            current = root;


            //current goes through the list until it is pointing to the node after the node we want to create
            //previous point to the node before
            while(current.row < row)
                current = current.down;


            while(current.col < col)
            {
                previous = current;
                current = current.across;

            }

            //crates a new node that is pointed to by the node before it and it points to the node to the right

            previous.across = new SparseMatrixNode(row,col,value, findDown(row,col).down, current);

            findDown(row,col).down = previous.across;

        }

    }



    private void createRow(int row) {
        SparseMatrixNode previous = null;
        SparseMatrixNode current = root;

        //travel down until current is the head row to be deleted
        //previous is the row header after

        while(current.row < row){

            previous = current;
            current = current.down;
        }

        //creates a new header node that points to a node which points to nothing
        previous.down = new SparseMatrixNode(row,0,0,current, new SparseMatrixNode(row,maxCols+1,0,null,null));

    }

    private void deleteRow(int row){

        SparseMatrixNode previous = null;
        SparseMatrixNode current = root;

        //travels down until current is the row to be deleted
        //prev is the row after it
        while(current.row < row){
            previous = current;
            current = current.down;
        }

        previous.down = current.down;

    }

    private void createColumn(int column) {
        SparseMatrixNode previous = null;
        SparseMatrixNode current = root;

        //travels across until current is the column header to be deleted
        // prev is the column after it
        while(current.col < column){
            previous = current;
            current = current.across;
        }

        //crates a new head node that points to a node which points to nothing
        previous.across = new SparseMatrixNode(0,column,0, new SparseMatrixNode(maxRows + 1,column,0,null,null),current);


    }

    private void deleteCol(int col){

        SparseMatrixNode previous = null;
        SparseMatrixNode current = root;

        //travels across until current is the col to be deleted
        //previous is the column header after
        while(current.col < col)
        {
            previous = current;
            current = current.across;
        }

        previous.across = current.across;


    }



    private SparseMatrixNode findDown(int row, int col){
        SparseMatrixNode current = root;
        SparseMatrixNode previous = null;

        //travel across the link list to the correct column
        while(current.col < col)
            current = current.across;


        //travels down until current is the node below
        // previous is the node above current
        while(current.row < row)
        {
            previous = current;
            current = current.down;

        }

        return previous;


    }

    private SparseMatrixNode findAcross(int row, int col){
        SparseMatrixNode current = root;
        SparseMatrixNode previous = null;

        //travel across the linked list to the correct row
        while(current.row < row)
            current = current.down;


        //travel right until current is the node right of the parameters
        // previous is the node to the left
        while(current.col < col)
        {
            previous = current;
            current = current.across;
        }

        return previous;
    }

    private boolean isRowEmpty(int row){

        boolean rowEmpty = true;
        SparseMatrixNode tracker =  root;

        //travel across the row
        while(tracker.row < row)
            tracker = tracker.down;

        //if correct row is found, check to see if there are 2 nodes
        if(tracker.row == row)
            //if true return false;
            if(tracker.across.across != null) rowEmpty = false;


        return rowEmpty;

    }

    private boolean isColEmpty(int col){

        boolean colEmpty = true;

        SparseMatrixNode tracker = root;

        //travel across the column
        while(tracker.col < col)
            tracker = tracker.across;

        //if correct row is found, check to see if there are 2 nodes
        if(tracker.col == col)
            //if so return false
            if(tracker.down.down != null) colEmpty = false;


        return colEmpty;


    }


    public String toString()
    {
        String res="";
        SparseMatrixNode tmp=root;
        while (tmp!=null)
        {
            res+=tmp.toString()+"\n";
            tmp=tmp.down;
        }

        return res;
    }

}
