package threading;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public class Basics extends Thread{
	

	@FieldOrder({"marks"})
	public static class sendStructArray extends Structure
	{	
		public static class ByReference extends sendStructArray implements Structure.ByReference{}
		public int marks;
	
	}
	
	
	@FieldOrder({"word"})
	public static class sendStringStructArray extends Structure{
		
		public static class ByReference extends sendStringStructArray implements Structure.ByReference{}
		public String word;
		
		
	}
	
	
	// Native Libray
	public interface Clib extends Library{
		
		final Clib INSTANCE1 = (Clib)Native.load("threading1",Clib.class);
		final Clib INSTANCE2 = (Clib)Native.load("threading2", Clib.class);
		
		// Send structure Array
		public double average(sendStructArray.ByReference s,int n);
		public sendStringStructArray.ByReference assignRandomWords(int n);
		
	}
	
	
	
	
	
	/*  Thread 1 */
	public static class Thread1 extends Thread{
		
		
		
		
		public Thread1(String name) {
			
			this.setName(name);
			
		}
		
		
		
		
		public void run() {
			

			 // Reference of Struct
			 	sendStructArray.ByReference s = new sendStructArray.ByReference();
			 	
			 // Assigning array of type struct to reference
				sendStructArray []s1 = (sendStructArray[])s.toArray(10000);
				
				
			// Assigning some random values	
				for(int i=0;i<10000;i++)
					s1[i].marks = (int)(Math.random()*1000)%100;
				
			
			// Calculating random value 
				System.out.println("Average marks: "+Clib.INSTANCE1.average(s,10000));
				
				try { this.sleep(200); } catch (InterruptedException e) {}
		}
		
	}
	
	
	
	
	 /*  Thread 2 */
	public static class Thread2 extends Thread{
		
		
		public Thread2(String name) {
			
			this.setName(name);
		
			
		}
		
		public void run() {

			
			// Assigning array to type of struct reference 
				sendStringStructArray []r1 =(sendStringStructArray[]) Clib.INSTANCE2.assignRandomWords(100).toArray(100);
				
				
				for(int i=0;i<100;i++)
				{
					System.out.println(r1[i].word);
					try { this.sleep(20); } catch (InterruptedException e) {}
				}
		}
		
	}
	
	
	
	 public static void main(String [] args) throws InterruptedException 
	    {
	       
		 
		 
			
		 Thread1 th1 = new Thread1("Average Marks");
		 Thread2 th2 = new Thread2("Random words");
		 
		 
		 
		 
		 th1.start();
		 th2.start();
		 
		 for(int i=0;i<10 && (th1.isAlive() || th2.isAlive());i++) {
			 System.out.println(th1.getName()+" is alive? : "+th1.isAlive());
			 System.out.println(th2.getName()+" is alive? : "+th2.isAlive());
			 Thread.sleep(500);
		 }
		
		
		 System.out.println(th1.getName()+" is alive? : "+th1.isAlive());
		 System.out.println(th2.getName()+" is alive? : "+th2.isAlive());

			
		 
		 
	    }
}
