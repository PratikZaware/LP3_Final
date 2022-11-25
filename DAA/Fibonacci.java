// time o(2^n)

class Fibonacci
{
	public static void main(String[] args) 
	{
		fib(5);
		System.out.println(rec_fib(5));
	}

	public static void fib(int nth)
	{
		if(nth<=2)
		{
			System.out.println(nth-1);
		}
		else
		{
			int first=0;
			int second=1;
			int temp=0;

			for(int i=1;i<=(nth-2);i++)
			{
				temp=first+second;
				first=second;
				second=temp;
			}

			System.out.println(temp);
		}
	}

	public static int rec_fib(int n)
	{
		if(n<=2)
		{
			return n-1;
		}
		
		return rec_fib(n-1)+rec_fib(n-2);
	}
}