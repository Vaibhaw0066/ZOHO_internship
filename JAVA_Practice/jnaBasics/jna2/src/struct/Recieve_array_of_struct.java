package struct;

import struct.Send_array_of_struct.Clib;
import struct.Send_array_of_struct.Struct;
import struct.Send_array_of_struct.Struct.ByReference;
import com.sun.jna.Library;
import com.sun.jna.Native;


public class Recieve_array_of_struct {
	
	interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("struct_modification",Clib.class);
		
		public Struct.ByReference recieve(int size);
	}
	
	public static void main(String[] args) {
		
		
		ByReference st = (ByReference)Clib.INSTANCE.recieve(5);
		Struct []arr = (Struct [])st.toArray(5);
	
		for(int i=0;i<5;i++) {
			System.out.println(arr[i].val);
		}
		
		
		
	}

}
