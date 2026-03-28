/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

Multi-threading minimizes resource usage by allowing multiple threads to share the same space in memory. 
This allows multiple processes to happen when running the program without having to resorting to having to having to "eat up" all the memory.
*/
/*
Angelo Espiritu
2/7/2026
Purpose: To create a threaded matrix addition program
Sources: 
https://stackoverflow.com/questions/55285990/dividing-matrix-into-four-sub-blocks
https://stackoverflow.com/questions/5463781/java-how-to-split-a-2d-array-into-two-2d-arrays
https://www.geeksforgeeks.org/java/multithreading-in-java/
https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
https://stackoverflow.com/questions/36381153/adding-java-2d-arrays
*/
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		/* Testing print2dArray
		int[][] testMatrix = 
        {
            {5,0,0,0},
            {0,8,0,0},
            {0,0,0,0},
            {0,6,0,0}
        };
		print2dArray(testMatrix);
		*/
		try
		{
			Scanner fileReader = new Scanner(new File(args[0])); //reads in from command line
			int rows = fileReader.nextInt();
			int cols = fileReader.nextInt();

			int[][] matrixA = matrixFromFile(rows, cols, fileReader);
			int[][] matrixB = matrixFromFile(rows, cols, fileReader);
			int[][] matrixC = new int[rows][cols];

			//make sure that input matrices print and are read in
			System.out.println("Matrix A");
			print2dArray(matrixA);

			System.out.println("Matrix B");
			print2dArray(matrixB);

			//instatiate threads
			ThreadOperation T1 = new ThreadOperation(matrixA, matrixB, matrixC, "upper left");
			ThreadOperation T2 = new ThreadOperation(matrixA, matrixB, matrixC, "upper right");
			ThreadOperation T3 = new ThreadOperation(matrixA, matrixB, matrixC, "lower left");
			ThreadOperation T4 = new ThreadOperation(matrixA, matrixB, matrixC, "lower right");

			//start threads
			T1.start();
			T2.start();
			T3.start();
			T4.start();
			try
			{
				//wait for all threads
				T1.join();
				T2.join();
				T3.join();
				T4.join();
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			fileReader.close(); //close scanner

			System.out.println("Added array");
			print2dArray(matrixC);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
	}

	//taken straight out of my sparse array assignment
	public static void print2dArray(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.printf("%5d",matrix[i][j]);
            }
            System.out.println();    
        }    
        System.out.println();
	}

	//converts file to 2d int array
	public static int[][] matrixFromFile(int rows, int columns, Scanner fileReader)
	{
		int[][] matrix = new int[rows][columns];

		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				matrix[i][j] = fileReader.nextInt();
			}	
		}	
		
		return matrix;
	}


}