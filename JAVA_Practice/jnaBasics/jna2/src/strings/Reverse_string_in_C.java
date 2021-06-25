package strings;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;;


public class Reverse_string_in_C {
 
	
	
	interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("strings",Clib.class);
	
			public String reverse(String data);
		
	}
	
	
	public static void main(String[] args) {
		

		String x ="ABCDE zyx 1";
		x = Clib.INSTANCE.reverse(x);
		System.out.println("Reversed : "+x);

		

	}

}
