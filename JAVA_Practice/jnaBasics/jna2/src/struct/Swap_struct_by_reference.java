package struct;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public class Swap_struct_by_reference {

	@FieldOrder({"val"})
	public static class Struct extends Structure{
		
		public static class ByReference extends Struct implements Structure.ByReference{}
		public int val;
		
	}
	
	public interface Clib extends Library{
		Clib INSTANCE = (Clib)Native.load("struct_modification", Clib.class);

		void swap_struct(Struct.ByReference s1,Struct.ByReference s2);
	} 
	
	public static void main(String[] args) {
		
		Struct.ByReference s1 = new Struct.ByReference();
		s1.val =10;
		
		Struct.ByReference s2 = new Struct.ByReference();
		s2.val =20;
		
		System.out.println("Before swapping :  s1->val =  "+s1.val+"   s2->val = "+s2.val);
		Clib.INSTANCE.swap_struct(s1, s2);
		System.out.println("After swapping :  s1->val =  "+s1.val+"   s2->val = "+s2.val);
		
	}

}
