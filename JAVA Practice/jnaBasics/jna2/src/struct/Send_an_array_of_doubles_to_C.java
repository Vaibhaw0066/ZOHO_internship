package struct;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.*;
import struct.Recieve_array_of_struct.Clib;
import struct.Send_an_array_of_doubles_to_C.Struct.ByReference;

public class Send_an_array_of_doubles_to_C {

	@FieldOrder({"data"})
	public static class Struct extends Structure{
		public static class ByReference extends Struct implements Structure.ByReference{}
		
		public double data;
	}
	
	
	interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("/home/vaibhaw/Desktop/ZOHO_internship/JAVA Practice/jnaBasics/jna2/src/sharedLib/modify_struct.so",Clib.class);
		
		public void sendDouble(Struct.ByReference s,int size);
		
	}
	
	public static void main(String[] args) {
			
		Struct.ByReference s = new Struct.ByReference();
		Struct[] st_arr = (Struct[]) s.toArray(5);
		
		for(int i=1;i<=5;i++)
			st_arr[i-1].data = (double)i*3/5;
		
		Clib.INSTANCE.sendDouble(s, 5);
	}
	
	

}
