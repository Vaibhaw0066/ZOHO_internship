
public class FrameIt {

	public static void main(String[] args) {
		
		
		String []data=new String[4];
		
		data[0]="abcd";
		data[1]="efgh";
		data[2]="ijkl";
		data[3]="mnop";
		
		
		System.out.println("Orignal PHOTO : \n");
		for(int i=0;i<4;i++)
			System.out.println(data[i]+"");
		
		System.out.println("\n+Framed photo :\n\n");
		
		for(int i=-1;i<=4;i++)
			if(i==-1 || i==4)
				System.out.println("* * * * *");
			else
				System.out.println("* "+data[i]+"  *");
		

	}

}
