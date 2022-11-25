// time o(n*W)


import java.util.*;

class Assignment3Practice1
{
	public static void main(String[] args) 
	{
		int n=3;
		int W=8;
		int w[]={3,4,6};
		int v[]={30,50,60};

		int dp[][]=new int[n][W+1];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				dp[i][j]=-1;
			}
		}
		System.out.println(knapsack(n,0,W,w,v,dp));
	}

	public static int knapsack(int n,int ind,int W,int w[],int v[],int dp[][])
	{
		if(ind==n)
		{
			return 0;
		}

		if(dp[ind][W]!=-1)
		{
			return dp[ind][W];
		}

		int take=0;
		if(W>=w[ind])
		{
			take=v[ind]+knapsack(n,ind+1,W-w[ind],w,v,dp);
		}
		int nottake=knapsack(n,ind+1,W,w,v,dp);

		return dp[ind][W]=Math.max(take,nottake);
	}
}