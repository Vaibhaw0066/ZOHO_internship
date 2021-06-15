package basics;

public class Thread_Basic  {

	
	static class Temp extends Thread {
		
		public void run() {
			for(int i=0;i<10;i++) {
				System.out.println("Thread ");
				
				try {
					Thread.sleep(100);
				}catch(Exception e) {
					System.out.println("Error : "+e);
				}
				
			}
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Temp t1 = new Temp();
		t1.run();
		
		for(int i=0;i<10;i++)
		{
			System.out.println("Running main method");
			
			Temp.sleep(50);
		}
		

		

	}

}
