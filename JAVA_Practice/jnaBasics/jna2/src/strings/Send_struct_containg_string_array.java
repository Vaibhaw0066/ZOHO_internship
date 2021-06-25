package strings;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public class Send_struct_containg_string_array {
	
	@FieldOrder({"size","string"})
	public static class Struct extends Structure{
		
		public static class ByReference extends Struct implements Structure.ByReference{}
		
		public int size;
		public Pointer string;  // char **
		
	}
	
	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("strings",Clib.class); 
		
		public void send_string_Array(Struct.ByReference s);
	
	}
	
	public static void main(String[] args) {
		
		Struct.ByReference  s = new Struct.ByReference();
		
		s.size =4;
		String []str = new String[s.size];
		
		str[0]="One";
		str[1]="Two";
		str[2]="Three";
		str[3]="Four";
		
		// Copying a string array to contigious memeory block using Pointer
		s.string = new StringArray(str);
		
		Clib.INSTANCE.send_string_Array(s);
		

		

	}

}
