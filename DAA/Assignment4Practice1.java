// time 0(n!)
// space o(n^2)

class Assignment4Practice1
{
	public static void main(String[] args) 
	{
		int n=4;
		boolean board[][]=new boolean[n][n];

		int prow=3;
		int pcol=1;

		board[prow][pcol]=true;

		solveNQueen(board,prow,0,n);
	}


	public static void solveNQueen(boolean board[][],int prow,int row,int n)
	{
		if(row==n)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(board[i][j])
					{
						System.out.print("1 ");
					}
					else
					{
						System.out.print("0 ");
					}
				}
				System.out.println();
			}

			System.out.println();

			return;
		}

		if(row==prow)
		{
			solveNQueen(board,prow,row+1,n);
		}

		else
		{
			for(int i=0;i<n;i++)
			{
				if(isSafe(row,i,board,n))
				{
					board[row][i]=true;
					solveNQueen(board,prow,row+1,n);
					board[row][i]=false;
				}
			}
		}
	}


	public static boolean isSafe(int row,int col,boolean board[][],int n)
	{
		for(int i=0;i<n;i++)
		{
			if(board[i][col])
			{
				return false;
			}
		}

		for(int i=0;i<n;i++)
		{
			if(board[row][i])
			{
				return false;
			}
		}

		int row1=row;
		int col1=col;

		while(row1>=0 && col1>=0)
		{
			if(board[row1][col1])
			{
				return false;
			}
			row1--;
			col1--;
		}

		int row2=row;
		int col2=col;

		while(row2>=0 && col2<n)
		{
			if(board[row2][col2])
			{
				return false;
			}
			row2--;
			col2++;
		}

		int row3=row;
		int col3=col;

		while(row3<n && col3>=0)
		{
			if(board[row3][col3])
			{
				return false;
			}
			row3++;
			col3--;
		}

		int row4=row;
		int col4=col;

		while(row4<n && col4<n)
		{
			if(board[row4][col4])
			{
				return false;
			}
			row4++;
			col4++;
		}
		return true;
	}
}