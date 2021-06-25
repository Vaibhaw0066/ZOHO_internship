package struct;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public class Modify_struct_in_C {

	@FieldOrder({"i"})
	public static class Struct extends Structure{
		
		public static class ByReference extends Struct implements Structure.ByReference{};
		public int i;
		
	};
	
	
	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("struct_modification",Clib.class);
		public void modify(Struct.ByReference data);
	}
	
	public static void main(String[] args) {
		
		
		Struct.ByReference sr = new Struct.ByReference();
		sr.i=1;
		
		System.out.println("Orignal Value: "+sr.i);
		Clib.INSTANCE.modify(sr);
		System.out.println("Modified Value: "+sr.i);
		
	}
}
