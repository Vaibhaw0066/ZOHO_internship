package jna2;

import java.io.File;
import java.io.FilenameFilter;

import com.sun.jna.Library;
import com.sun.jna.Native;

import threading.ImageConversionMultithreaded.ConvertToPNG;

public class ConvertImageToPNG {
	
	
	
	public static class ConvertToPNG implements Runnable{
		
		String title;
		
		public ConvertToPNG(String tit) {this.title =tit;}
		
		public void run() {
			
			Clib.INSTANCE.convert(title);
		}
		
		
	}
	

	
	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("convertToPNG",Clib.class);
		
		void convert(String filename);
	}

	// File representing the folder that you select using a FileChooser
    static final File dir = new File("/home/vaibhaw/Desktop/ZOHO_internship/JAVA_Practice/jnaBasics/jna2/images");

    
    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "gif", "jpg", "bmp" // and other formats you need
    };
	
    
    
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
    
    
    
	
//	=====================    MAIN    ===================================================//
	public static void main(String[] args) {
		
		
			if(dir.isDirectory()) {
				
	            for (final File f : dir.listFiles(IMAGE_FILTER)) {

	                try {
	                	
	                	System.out.println(f.getName());
	                	Clib.INSTANCE.convert(f.getName());
	                	
	                
	                } catch (final Exception e) {
	                    
	                	System.out.println("Exception "+ e);
	                	
	                }
	            }
			}
			
			System.out.println("Working");
			


	}

}
