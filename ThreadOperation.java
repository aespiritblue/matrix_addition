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

    //we need to split the matrix into quadrants
    public static int[] getQuadrantIndexes(int rows, int columns, String quadrant)
    {
        int middleRow = rows / 2;
        int middleCol = columns / 2;

        int rowStart, rowEnd, colStart, colEnd;

        if(quadrant.equals("upper left")) 
        {

        }

        else if(quadrant.equals("upper right"))
        {

        }
        
        else if(quadrant.equals("lower left"))
        {

        }   
        
        else //lower right
        {

        }

        return new int[] {rowStart, rowEnd, colStart, colEnd};
    }

    @Override
    public void run()
    {
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        int[] idx = getQuadrantIndexes(rows, cols, quadrant);
    }
}
 