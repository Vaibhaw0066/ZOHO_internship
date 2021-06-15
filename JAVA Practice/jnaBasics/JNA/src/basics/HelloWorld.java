
package basics;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class HelloWorld {
	
	
	interface CLibrary extends Library{
		
		
	CLibrary INSTANCE =(CLibrary)Native.load(Platform.isWindows() ? "msvcrt":"c",CLibrary.class);
	
	
		public  void printf(String format, Object... args);
		public  void sleepf();
		
	}
	
	

	public static void main(String[] args) {
		CLibrary.INSTANCE.printf("Hellow world!\n");

	}

}
