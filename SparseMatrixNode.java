package ads2;

/* Use this class to hold node information within the Sparse Matrix data structure 
 * Sparse matrices hold integer numbers*/
class SMNode {
    public int row, col, value;
    public SMNode down, across;

    public SMNode(int row, int col, int value, SMNode down, SMNode across)
    {
        this.row=row;
        this.col=col;
        this.value=value;
        this.down=down;
        this.across=across;
    }


    public SMNode FindRow(int row)
    {

        if (this.row==row)
            return this;
        else
            return (this.down==null? null: this.down.FindRow(row));


    }



    public SMNode FindColumn(int col)
    {
        if (this.col==col)
            return this;
        else
            return (this.across==null? null: this.across.FindColumn(col));
    }


    public String toString()
    {
        String res="["+row+", "+col+", "+value+"] ";
        if (across!=null)
            res+=across;
        return res;
    }

}
