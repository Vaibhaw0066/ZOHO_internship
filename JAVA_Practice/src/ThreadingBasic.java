
	class A extends Thread{
		
		public void run() {
			for(int i=0;i<10;i++) {

				System.out.println("A");
				try{Thread.sleep(1);} catch(Exception e) {}
			}
		}
		
	}
	
	
	class B extends Thread{
		
		public void run() {
			
			for(int i=0;i<10;i++) {
				System.out.println("B");
				try {Thread.sleep(3);} catch(Exception e) {}
			}
				
		}
		
		
	}

public class ThreadingBasic {

	
	public static void main(String[] args) {
		
		A a1 = new A();
		B b1 = new B();
		
		a1.start();
		b1.start();
		
	}

}
