package threading;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.sun.jna.Library;
import com.sun.jna.Native;

import jna2.ConvertImageToPNG.Clib;

public class ImageConversionMultithreaded {

	public static class ConvertToPNG implements Runnable{
		
		String title;
		
		public ConvertToPNG(String tit) {this.title =tit;}
		
		public void run() {
			
			synchronized (this) {
			Clib.INSTANCE.convert(title);
			}
			
		}
		
		
	}
	
	
	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("converToPNG",Clib.class);
		
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
				
				ConvertToPNG []image_list = new ConvertToPNG[dir.listFiles(IMAGE_FILTER).length];
				
				// Array that holds threads
	        	Thread []threads = new Thread[dir.listFiles(IMAGE_FILTER).length];
	        	
				int i=0;
	
				
	            for (final File f : dir.listFiles(IMAGE_FILTER)) {

	                try {
	                	image_list[i]=new ConvertToPNG(f.getName());
	                	threads[i] = new Thread(image_list[i],"Thread-"+String.valueOf(i));
	                	
	                	threads[i].start();
	                	System.out.println(f.getName());
	                	Clib.INSTANCE.convert(f.getName());
	                	i++;
	                	System.out.println("i= "+i);
	                	if(i==1) break;
	                
	                } catch (final Exception e) {
	                    
	                	System.out.println("Exception "+ e);
	                	
	                }
	            }
			}
			
			System.out.println("Working");
			



	
    /*
	public static void main(String[] args) {
		
		
        if (dir.isDirectory()) { // make sure it's a directory
        	
        	
        	ConvertToPNG []image_list = new ConvertToPNG[dir.listFiles(IMAGE_FILTER).length];    	
        	
        	// Array that holds threads
        	ArrayList<Thread> threads = new ArrayList<>();
        	
        	Integer i=0;
        	
            for (final File f : dir.listFiles(IMAGE_FILTER)) {

                try {
                	
                	// title = filename with extension
                	// Initializing image object
                	image_list[i] =  new ConvertToPNG(f.getName());
                
                	
                	// Thread created with name "Thread-i"
                	threads.add(new Thread(image_list[i],("Thread-"+(i).toString())));
                	
                	// Thread started
                	threads.get(i).start();
                	
                	// Checking Status
                	System.out.println(threads.get(i).getName()+ (threads.get(i).isAlive()?" is alive":" is completed"));
                	
                	//Incrementing i
                	i++;
                	
                
                } catch (final Exception e) {
                    
                	System.out.println("Exception "+ e);
                	
                }
            }
        }else {
        	System.out.println("Folder not found: "+dir.exists());
        	
        }

		System.out.println("Running "+dir.exists());
*/
	}

}
