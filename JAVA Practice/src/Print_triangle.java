
import java.io.*;
import java.util.*;

public class FirstClass {

	
	// Execution starts
	public static void main(String args[]) 
	{	
		
		Scanner scan = new Scanner(System.in);
		
		int height ;
		height = scan.nextInt();
		
		
		for(int i=0;i<height;i++) {
			
			
			for(int j=0;j<height*2;j++)			
				if(j>=((int)height*2/2 - i) && j <=((int)height*2/2)+i)
					System.out.print("*");
				else
					System.out.print(" ");
	
			System.out.println();
			
		}

		
	}
	
}
