package struct;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

import struct.Send_a_struct_containing_an_array_of_doubles_to_C.Struct.ByReference;

public class Send_a_struct_containing_an_array_of_doubles_to_C {

	
	@FieldOrder({"size","double_array"})
	public static class Struct extends Structure{
		
		public static class ByReference extends Struct implements Structure.ByReference{}
		
		public int size;
		public Pointer double_array;  
		
	}
	
	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("/home/vaibhaw/Desktop/ZOHO_internship/JAVA Practice/jnaBasics/jna2/src/sharedLib/modify_struct.so",Clib.class);
		
		public void send_double_struct(Struct.ByReference s);
	}
	
	
	public static void main(String[] args) {
		
		Struct.ByReference st = new Struct.ByReference();
		st.size = 100;
		
		// allocates memory to double array pointer
		st.double_array = new Memory(st.size*Native.getNativeSize(Double.TYPE));
		
//		System.out.println(Native.getNativeSize(Double.TYPE) + "  "+ Native.getNativeSize(Integer.TYPE)+ " "+Native.getNativeSize(Pointer.TYPE));
		for(int i=0;i<st.size;i++) {
			
			/* Pointer.setDouble() -> Allocates memory of size Datatype and value as well
			 * 
			 * Parameter : address , value
			 * 
			 *  adderess - > i * sizeOfDouble
			 *  value   -> 'Your Choice'
			
			*/
			st.double_array.setDouble(i*Native.getNativeSize(Double.TYPE), (double)(i));
		}
		
		Clib.INSTANCE.send_double_struct(st);
		
	}

}
