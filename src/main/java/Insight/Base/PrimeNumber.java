package Insight.Base;

public class PrimeNumber {

	public static void main(String[] args) {
		
		for(int i=1;i<=100;i++) {
			for (int j=2;j<=i/2;j++)
			{
				if(i%j==0)
				{
					System.out.println(i + " is not a Prime Number");
					break;
				}
				
			}
					System.out.println(i + " is a Prime Number");
					
			
				}
		
			
				
			}
		

	}


