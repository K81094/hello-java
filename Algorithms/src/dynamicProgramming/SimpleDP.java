package dynamicProgramming;

public class SimpleDP {
	public int minSteps(int n)
	{
		int c=0;
		while(n>1){
			if(n%3==0){
				n=n/3;	c++;
			}
			else if(n%3==1){
				n=n-1;	c++;
			}
			else if(n%2==0)
			{
				n=n/2;	c++;
			}
			else if(n%2==1){
				n=n-1;	c++;
			}
			else{
				n=n-1;
				c++;
			}
		}
		return c;

	}
	public static void main(String[] args) {

		SimpleDP dp=new SimpleDP();
		System.out.println(dp.minSteps(9999));



	}

}
