package basics;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import java.lang.System;


//jna.nosys=true;

 public class JNA_new {
	
	static interface CLib extends Library{
		
	
		CLib INSTANCE = Native.load("/home/vaibhaw/Desktop/ZOHO_internship/JAVA Practice/jnaBasics/JNA/src/src/demo.so", CLib.class );
		
		
		void demo();    
	}
	
	
	public static void main(String[] args) {
		
		CLib.INSTANCE.demo();
	}

}
