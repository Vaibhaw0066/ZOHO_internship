package threading;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;




public class Threading_basic {
	
	
	public static class ClassA implements Runnable{

		@Override
		public void run() {
			Clib.INSTANCE.loop_for_n(1000000);
			
		}
		
	}
	
	public static class ClassB implements Runnable{
		
		@Override
		public void run() {
			Clib.INSTANCE.say_hi_n_times(20);
			System.out.println("Loop for n finished");
		}
		
	}
	
	public static class ClassC implements Runnable{
		
		@Override
		public void run() {
			System.out.println("\n\n\nSum of first 50 nums : "+Clib.INSTANCE.sum_of_n_natural_nums(500));
			System.out.println("Sum function finished");
		}
		
	}
	
	public static class ClassD implements Runnable{
		
		
		@Override
		public void run(){
			
			
			int []arr =  Clib.INSTANCE.return_n_length_array(5000).getIntArray(0, 5000);
//			for(int i=0;i<50;i++) {
////				System.out.println(arr[i]+ "  ->"+ i);
//				try {Thread.sleep(10);}catch(Exception e){}
//			}
			System.out.println("Arrary recieved!");
		}
		

		
	}
	
	public interface Clib extends Library{
		
		Clib INSTANCE = (Clib)Native.load("threads",Clib.class);
		
		
		void loop_for_n(int n);
		NativeLong sum_of_n_natural_nums(int n);
		void say_hi_n_times(int n);		
		Pointer return_n_length_array(int n);

		
	}
	
	public static void main(String[] args) throws Exception{
		
		
		
		// Loop for 1000 times
		ClassA obj1 = new ClassA();
		ClassB obj2 = new ClassB();
		ClassC obj3 = new ClassC();
		ClassD obj4 = new ClassD();
		
		
		Thread t1 = new Thread(obj1,"Looping_1000_elements");
		Thread t2 = new Thread(obj2,"say_hi_n_times");
		Thread t3 = new Thread(obj3,"sum_of_n_natural_nums");
		Thread t4 = new Thread(obj4,"return_n_length_array");
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
		for(int i=0;i<10;i++) {
			
			Thread.sleep(1000);
			System.out.println("Time "+(i+1)+" seconds.");
			System.out.println("t1 is in progress: "+t1.isAlive());
			System.out.println("t2 is in progress: "+t2.isAlive());
			System.out.println("t3 is in progress: "+t3.isAlive());
			System.out.println("t4 is in progress: "+t4.isAlive());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
