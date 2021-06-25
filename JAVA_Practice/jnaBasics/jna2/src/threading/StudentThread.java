package threading;

public class StudentThread {


	
	
	/* 
	 * A. Write a class to create a thread StudentAvgThread 
	 * that will calculate and display the student average in 
	 * 3 courses for 3 students. You need to use a multidimensional
	 * array containing the courses marks for each student.   
	*/
	public static class StudentAvgThread extends Thread{
		
		public static int [][]std = new int[100][100];
		public static int row;
		public static int col;
		
		public void run() {
			
			int sum = 0;
			
			for(int i=0;i<row;i++) {
				sum=0;
				for(int j=0;j<col;j++)
					sum+=std[i][j];
				

				System.out.println("Average of student"+(i+1)+" : "+sum/3);
					
			}
			System.out.println("\n");
		}
	}
	
	
	public static class CourseAvgThread extends Thread{
		public static int [][]std = new int[100][100];
		public static int row;
		public static int col;
		
		public void run() {
			int sum = 0;
			
			for(int i=0;i<col;i++) {
				sum=0;
				for(int j=0;j<row;j++)
					sum+=std[j][i];
				
				if(i==0)
					System.out.println("Math average : "+sum/3);
				if(i==1)
					System.out.println("English average : "+sum/3);
				if(i==2)
					System.out.println("IT average : "+sum/3);
					
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
		/*
		 * Declaration syntax for a multidimensional array:
		 * data_type[][] array_name = new data_type[x][y];
		 */
		
		//int [][] array_name = new int[3][3];
		
		
		
		int [][]array_name = {{85,75,95},{60,80,70},{100,60,70}};
		
		
		int row = array_name.length;
		int col = array_name[0].length;
		
		
		StudentAvgThread st_avg = new StudentAvgThread();
		CourseAvgThread cs_avg = new CourseAvgThread();
		
		st_avg.row = row;
		st_avg.col = col;
		st_avg.std = array_name;
		
		
		cs_avg.row = row;
		cs_avg.col = col;
		cs_avg.std = array_name;
		
		
		st_avg.start();
		cs_avg.start();
		
		
		
		
		
	}

}
