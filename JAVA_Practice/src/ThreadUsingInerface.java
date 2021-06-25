


class Aa implements Runnable{
		
		public void run() {
			for(int i=0;i<10;i++) {

				System.out.println("A");
				try{Thread.sleep(200);} catch(Exception e) {}
			}
		}
		
	}
	
	
class Bb implements Runnable{
		
		public void run() {
			
			for(int i=0;i<10;i++) {
				System.out.println("B");
//				try {Thread.sleep(100);} catch(Exception e) {}
			}
				
		}
		
		
	}

public class ThreadUsingInerface {

	public static void main(String[] args) throws Exception {
		
		Runnable a1 =new Aa();
		Runnable b1 = new Bb();
		
		
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(b1);
		
		t1.start();
		t1.join();
//		t2.join();
		t2.start();
	}

}
