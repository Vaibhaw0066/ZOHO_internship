package basics;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;



// Annotation
import com.sun.jna.Structure.FieldOrder;

	public class Struct {		

		
		@FieldOrder({"field1","field2","field3"})
		public static class structC extends Structure
		{
			public int field1;
			public int field2;
			public String field3;
			
		};
		
		
		public interface CLib extends Library {
				
				CLib INSTANCE = (CLib)Native.load("/home/vaibhaw/Desktop/ZOHO_internship/JAVA Practice/jnaBasics/JNA/src/sharedLib/struct.so",CLib.class);
				
		
		}

		
		public void print(Structure data) {}
		
		public static void main(String[] args) {
			
		structC data = new structC();
		
		data.field1 = 10;
		data.field2 = 20;
		data.field3 = "From JAVA";
		
//		CLib.INSTANCE.print(data);
		
	
	}
}

