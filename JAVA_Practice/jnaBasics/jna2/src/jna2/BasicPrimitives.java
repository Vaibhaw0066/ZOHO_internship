package jna2;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;

public class BasicPrimitives{
	
	
	
	public static class Int extends IntByReference{}
	
	interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("primitive", Clib.class);
		
		
//		
//		/*     PRIMITIVE DATA STRUCTUES   */
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
//		
		
		/* Primitive By reference  */
		int swapInt(Int a,Int b);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		Clib a = Clib.INSTANCE;
		
		System.out.println("Sum = "+a.sum(10, 20));
		a.printNchars('D', 10);
		a.printSquare(10);
		System.out.println("103^5 = "+a.pow_recu(103, 5));
		System.out.println(a.concatNtimes("Hello->",5));
		
		Int aa = new Int();
		Int bb = new Int();
		
		aa.setValue(100);
		bb.setValue(200);
		
		System.out.println("\nBefore: a = "+aa.getValue()+"   b = "+bb.getValue());
		
		int add = a.swapInt(aa, bb);
		
		
		System.out.println("After : a = "+aa.getValue()+"   b = "+bb.getValue());
		System.out.println("Addiion : "+add);
		
		System.out.println();
		System.out.println();
		
	
	}
	
	
	
}


