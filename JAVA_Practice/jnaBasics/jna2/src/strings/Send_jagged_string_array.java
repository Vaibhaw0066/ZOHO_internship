package strings;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public class Send_jagged_string_array {

	

	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("strings",Clib.class);
	
		
		public static final int num = 0;
		
		public void SendJaggedArrayToC(JaggedArray.ByRefference j);
		
	}
	
	
	@FieldOrder({"jaggedArray"})
	public class JaggedArray extends Structure{
		public class ByRefference extends JaggedArray implements Structure.ByReference{};
		public Pointer jaggedArray;    // char**

	}
	
	public static void main(String[] args) {
		
		
		
	}

}

