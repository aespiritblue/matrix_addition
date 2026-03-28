public class ThreadOperation extends Thread
{
    //instance variables to 
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] matrixC;
    private String quadrant;

    //constructor
    public ThreadOperation(int[][] matrixA, int[][] matrixB, int[][] matrixC, String quadrant)
    {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.matrixC = matrixC;
        this.quadrant = quadrant;
    }

    //start here,we need to split the matrix into quadrants
    public static int[] getQuadrantIndexes(int rows, int columns, String quadrant)
    {
        int middleRow = rows / 2;
        int middleCol = columns / 2;

        int rowStart, rowEnd, colStart, colEnd = 0;

        if(quadrant.equals("upper left")) 
        {
            rowStart = 0;
            rowEnd = middleRow;
            colStart = 0;
            colEnd = middleCol;
        }

        else if(quadrant.equals("upper right"))
        {
            rowStart = 0;
            rowEnd = middleRow;
            colStart = middleCol;
            colEnd = columns;
        }
        
        else if(quadrant.equals("lower left"))
        {
            rowStart = middleRow;
            rowEnd = rows;
            colStart = 0;
            colEnd = middleCol;
        }   
        
        else //lower right
        {
            rowStart = middleRow;
            rowEnd = rows;
            colStart = middleCol;
            colEnd = columns;
        }

        return new int[] {rowStart, rowEnd, colStart, colEnd};
    }

    @Override
    public void run()
    {
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        int[] index = getQuadrantIndexes(rows, cols, quadrant);

        int rowStart = index[0];
        int rowEnd = index[1];
        int colStart = index[2];
        int colEnd = index[3];


        for(int i = rowStart; i < rowEnd; i++)
        {
            for(int j = colStart; j < colEnd; j++)
            {
                int result = matrixA[i][j] + matrixB[i][j];
                matrixC[i][j] = result;

            }    
        }  
        //test to see if threads were done 
        //System.out.println("Thread " + quadrant + " done");
    }
}
 