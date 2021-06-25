package struct;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public class Struct_containing_array_of_struct {
	
	@FieldOrder({"data"})
	public static class Struct1 extends Structure{
		public static class ByReference extends Struct1 implements Structure.ByReference{}
		public int data;
		
	}
	

	
	public interface Clib extends Library{
		Clib INSTANCE = (Clib)Native.load("struct_modification",Clib.class);
		
		void sendStructArray(Struct1.ByReference data,int size);

	} 
	
	public static void main(String[] args) {
		
		Struct1.ByReference s1 = new Struct1.ByReference();
		Struct1[] arr = (Struct1[])s1.toArray(10);
		
		
		for(int i=0;i<10;i++) 
			arr[i].data = i*10;
		
		Clib.INSTANCE.sendStructArray(s1, 10);
		
	
		
		
	}
}
