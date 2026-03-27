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
It also takes advantage of multicore processors by running threads in parallel without the overhead of creating separate processes, which makes execution of programs more efficient.
*/
import java.io.IOException;
import java.io.File;
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
		
		
	}

	//taken straight out of my sparse array assignment
	public static void print2dArray(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.printf(matrix[i][j] + "\t");
            }
            System.out.println();    
        }    
        System.out.println();
	}

	//converts file to 2d int array
	public static int[][] matrixFromFile(int rows, int columns, Scanner file_reader)
	{
		return null; //TODO: fill this in
		
	}


}