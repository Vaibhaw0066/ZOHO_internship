package struct;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

import struct.Send_array_of_struct.Struct.ByReference;

public class Send_array_of_struct {

	@FieldOrder({"val"})
	public static class Struct extends Structure{
		public static class ByReference extends Struct implements Structure.ByReference{}
		
		public int val;
		
	}
	
	public interface Clib extends Library{
		
	
		Clib INSTANCE = (Clib)Native.load("struct_modification",Clib.class);
		
		// Returns the sum of data member val from an struct Array
		public int send_struct_array(Struct.ByReference Struct, int size);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		// Struct pointer Refferece
		Struct.ByReference st = new Struct.ByReference();
		
		// assigning array to struct reference pointer
		Struct[] arr = (Struct[])st.toArray(4);
		
		// Assigning values
		arr[0].val=10;
		arr[1].val=20;

		arr[2].val=30;
		arr[3].val=40;
		
		int total = Clib.INSTANCE.send_struct_array(st, 4);
		System.out.println("Total : " + total );
		
		
		
		

	}

}
