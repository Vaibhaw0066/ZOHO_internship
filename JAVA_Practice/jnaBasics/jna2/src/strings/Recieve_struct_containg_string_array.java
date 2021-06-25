package strings;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

import strings.Send_struct_containg_string_array.Clib;
import strings.Send_struct_containg_string_array.Struct;

public class Recieve_struct_containg_string_array {
	
	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("strings",Clib.class); 
		public Struct.ByReference  recieve_string_array();
	}
	
	public static void main(String[] args) {
		
		Struct.ByReference s= Clib.INSTANCE.recieve_string_array();
		
		
		String []str = s.string.getStringArray(0, s.size);
		
		for(int i=0;i<s.size;i++)
			System.out.println(str[i]);
		
		
		
		
	}

}
