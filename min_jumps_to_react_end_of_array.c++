#include <bits/stdc++.h>
using namespace std;
int solve(vector<int> arr,int i,int n){
	if(i>=n-1)
	return 0;
	int k = arr[i];
	int min = 1000;
	for(int j=i+1;j<n&&j<=k+i;j++){
		min = std::min(min,solve(arr,j,n));
		
	}
	return 1+min;
	
}
int solve2(vector<int> arr,int n){
	
	    int dp[n];
	for(int i=0;i<n;i++)
	dp[i]=INT_MAX;
	dp[0]=1;
	for(int i=1;i<n;i++){
        
		for(int j=i-1;j>=0;j--){
			if(j+arr[j]>=i){
			dp[i]=std::min(dp[i],dp[j]+1);
		}
		}
	}
        if(dp[n-1]==INT_MAX)
            return -1;
	return dp[n-1]-1;
     
	
}
int solve3(vector<int> arr,int n){
	
	int jump = 1;
	int steps = arr[0];
	int maxReach = arr[0];
	for(int i=1;i<n;i++){
		
		if(i==n-1)
		return jump;
		
		maxReach = std::max(maxReach,arr[i]+i);
		steps--;
		if(steps==0){
			jump++;
			if(i>=maxReach)
			return -1;
			steps=maxReach-i;
		}
		
		
	}
	return -1;
}


int main()
{
	vector<int> arr{1,3,5,8,9,2,4,6,8,6,4};
	//cout<<solve(arr,0,arr.size())<<endl;
	cout<<solve2(arr,arr.size())<<endl;
	cout<<solve3(arr,arr.size());
;	
}