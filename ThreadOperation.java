public class ThreadOperation extends Thread
{
    //instance variables for our matrices
    private int[][] matrixA; //first input matrix
    private int[][] matrixB; //second input matrix
    private int[][] matrixC; //result
    private String quadrant; //which quadrant

    //constructor
    public ThreadOperation(int[][] matrixA, int[][] matrixB, int[][] matrixC, String quadrant)
    {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.matrixC = matrixC;
        this.quadrant = quadrant;
    }

    //start here, we need to split the matrix into quadrants
    public static int[] getQuadrantIndexes(int rows, int columns, String quadrant)
    {
        //splits matrix in half (used integer division)
        int middleRow = rows / 2;
        int middleCol = columns / 2;

        int rowStart, rowEnd, colStart, colEnd = 0; //sets everything initially to 0

        //bounds of each quadrant
        if(quadrant.equals("upper left")) 
        {
            rowStart = 0;       //top half
            rowEnd = middleRow; 
            colStart = 0;       //left half
            colEnd = middleCol;
        }

        else if(quadrant.equals("upper right"))
        {
            rowStart = 0;       //top half
            rowEnd = middleRow;
            colStart = middleCol;   //right half
            colEnd = columns;
        }
        
        else if(quadrant.equals("lower left"))
        {
            rowStart = middleRow; //bottom half w/ extra row
            rowEnd = rows;
            colStart = 0;       //left half
            colEnd = middleCol;
        }   
        
        else //lower right
        {
            rowStart = middleRow;   //bottom half w/ extra row
            rowEnd = rows;
            colStart = middleCol; //right half
            colEnd = columns;
        }

        //returns int arrays
        return new int[] {rowStart, rowEnd, colStart, colEnd};
    }

    //add elements of quadrant
    @Override
    public void run()
    {
        //gets length
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        //gets indexes for quadrant
        int[] index = getQuadrantIndexes(rows, cols, quadrant);

        //start and end index for rows and columns from array
        int rowStart = index[0];
        int rowEnd = index[1];
        int colStart = index[2];
        int colEnd = index[3];

        //loop over rows and colums
        for(int i = rowStart; i < rowEnd; i++)
        {
            for(int j = colStart; j < colEnd; j++)
            {
                //adds it up
                int result = matrixA[i][j] + matrixB[i][j];
                matrixC[i][j] = result;

            }    
        }  
        //test to see if threads were done 
        //System.out.println("Thread " + quadrant + " done");
    }
}
 