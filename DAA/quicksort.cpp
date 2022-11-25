//time nlogn   worst n^2 array sorted

#include<bits/stdc++.h>
using namespace std;

int partition(vector<int>&a,int l,int h)
{
	int index=l;
	int pivot=h;
	
	for(int i=l;i<h;i++)
	{
		if(a[i]<a[pivot])
		{
			swap(a[i],a[index]);
			index++;
		}
	}
	
	swap(a[index],a[pivot]);
	return index;
}


int r_partition(vector<int>&a,int l,int h)
{
	int num=rand();
	int ri=l+num%(h-l+1);
	swap(a[h],a[ri]);
	return partition(a,l,h);
}

void quicksort(vector<int>&a,int l,int h)
{
	if(l<h)
	{
		int pi=partition(a,l,h);
		quicksort(a,l,pi-1);
		quicksort(a,pi+1,h);
	}
}


void r_quicksort(vector<int>&a,int l,int h)
{
	if(l<h)
	{
		int pi=r_partition(a,l,h);
		r_quicksort(a,l,pi-1);
		r_quicksort(a,pi+1,h);
	}
}

int main()
{
	int n;
	cin>>n;
	vector<int>a;
	for(int i=0;i<n;i++)
	{
		int x;
		cin>>x;
		a.push_back(x);
	}
	
	quicksort(a,0,n-1);
	
	for(int i=0;i<n;i++)
	{
		cout<<a[i]<<" ";
	}
	
	r_quicksort(a,0,n-1);
	
	for(int i=0;i<n;i++)
	{
		cout<<a[i]<<" ";
	}
 	return 0;
}





