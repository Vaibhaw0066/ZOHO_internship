package jna2;






import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
//Annotation
import com.sun.jna.Structure.FieldOrder;

	public class GenralStructure {		
		
		@FieldOrder({"field1","field2","field3"})
		public static class structC extends Structure
		{
			public int field1;
			public int field2;
			public String field3;
			
		};
		
		
		@FieldOrder({"data"})
		public static class NativeStructure extends Structure{
			
			public String data; 
			
		};

		
		
		
		
		public interface CLib extends Library {
			
			CLib INSTANCE = (CLib)Native.load("/home/vaibhaw/Desktop/ZOHO_internship/JAVA Practice/jnaBasics/jna2/src/sharedLib/struct.so",CLib.class);
			
			public void printByReference(structC data);
			public void printByReference2(NativeStructure data);
			public NativeStructure getStructFromC();
		}
	
		public static void main(String[] args) {
			
		structC data = new structC();
		
		data.field1 = 10;
		data.field2 = 20;
		data.field3 = "From JAVA";
		
		// Sending a struct to 
		CLib.INSTANCE.printByReference(data);
		
		NativeStructure new1 = CLib.INSTANCE.getStructFromC();
		CLib.INSTANCE.printByReference2(new1);
		
		
		
		System.out.println("=============  Called form JAVA  =========");
		System.out.println("Updated field1: "+data.field1);
		System.out.println("Updated field2: "+data.field2);
		System.out.println("Updated field3: "+data.field3);
		
	}
}

