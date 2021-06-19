package struct;

import com.sun.jna.Library;
import com.sun.jna.Native;
import struct.Send_an_array_of_doubles_to_C.Struct;
import struct.Send_an_array_of_doubles_to_C.Clib;
import struct.Send_an_array_of_doubles_to_C.Struct.ByReference;


public class Receive_an_array_of_doubles_from_C {

	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("/home/vaibhaw/Desktop/ZOHO_internship/JAVA Practice/jnaBasics/jna2/src/sharedLib/modify_struct.so",Clib.class);
		
		public ByReference recieveDouble(int size);
		
		
	} 
	public static void main(String[] args) {
			
		ByReference []s = (ByReference [])Clib.INSTANCE.recieveDouble(5).toArray(5);
		
		for(int i=0;i<5;i++)
			System.out.println(s[i].data);

	}

}
