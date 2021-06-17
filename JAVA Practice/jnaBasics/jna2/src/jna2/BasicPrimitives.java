package jna2;


import com.sun.jna.Library;
import com.sun.jna.NativeLong;
import com.sun.jna.Native;

public class BasicPrimitives{
	
	
	interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("/home/vaibhaw/Desktop/ZOHO_internship/JAVA Practice/jnaBasics/JNA/src/sharedLib/primivte.so", Clib.class);
		
		
		
		/*     PRIMITIVE DATA STRUCTUES   */
		// returns the sum of two numbers
		int sum(int  a,int b);
		
		// prints the given charater n time
		void printNchars(char c,int n);
		
		// Print squre of with '*'
		void printSquare(int side);
		
		// returns a^n 
		NativeLong pow_recu(int a, int n);
		
		// Concatenate the gives string to itself n times
		String concatNtimes(String a,int n);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		Clib a = Clib.INSTANCE;
		
		System.out.println("Sum = "+a.sum(10, 20));
		a.printNchars('D', 10);
		a.printSquare(10);
		System.out.println("103^5 = "+a.pow_recu(103, 5));
		System.out.println(a.concatNtimes("Hello->",5));
	
	
	}
	
	
	
}


