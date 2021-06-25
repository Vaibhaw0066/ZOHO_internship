package strings;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;;


public class Retrive_a_string_from_struct {

	
	@FieldOrder({"data"})
	public static class StringData extends Structure{
		public static class ByValue extends StringData implements Structure.ByValue {}
		public String data;
		
	} 
	
	
	interface Clib extends Library{
		
		final Clib INSTANCE = (Clib)Native.load("strings",Clib.class);
	    public StringData.ByValue getStructString();
	    public void cleanup_data(StringData.ByValue v);
	}
	
	
	public static void main(String[] args) {
		
		StringData.ByValue sd = Clib.INSTANCE.getStructString();
		Clib.INSTANCE.cleanup_data(sd);
		
		System.out.println(sd.data);
		
		

	}

}
