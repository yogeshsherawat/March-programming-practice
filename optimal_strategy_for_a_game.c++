#include <bits/stdc++.h>
using namespace std;
int fun(vector<int> arr,int i,int j){
	if(i==j)
	return arr[i];
	if(i+1==j)
	return std::max(arr[i],arr[j]);
	int k1 = arr[i]+ std::min(fun(arr,i+2,j),fun(arr,i+1,j-1));
	int k2 = arr[j]+ std::min(fun(arr,i+1,j-1),fun(arr,i,j-2));
	return std::max(k1,k2);
}
int fun2(vector<int> arr,int i,int j,vector<vector<int>> dp){
	if(i==j)
	return arr[i];
	if(i+1==j)
	return std::max(arr[i],arr[j]);
	if(dp[i][j]!=-1)
	return dp[i][j];
	
	int k1 = arr[i]+ std::min(fun2(arr,i+2,j,dp),fun2(arr,i+1,j-1,dp));
	int k2 = arr[j]+ std::min(fun2(arr,i+1,j-1,dp),fun2(arr,i,j-2,dp));
	dp[i][j]=std::max(k1,k2);
	return dp[i][j];
}
int fun3(vector<int> arr,int n){
	vector<vector<int>> dp(n,vector<int>(n,-1));
	
	for(int gap=0;gap<n;gap++){
		for(int i=0,j=gap;j<arr.size();j++){
			int x = (j+2<arr.size()?dp[i][j+2]:0);
			int y = ((i+1<=j && j-1>=0)?dp[i+1][j-1]:0);
			int z = ((j-2>=0)?dp[i][j-2]:0);
			int k1 = arr[i]+std::min(x,y);
			int k2 = arr[j]+std::min(y,z);
			dp[i][j]=std::max(k1,k2);
		}
	}
	return dp[s][e];
	
}
int fun4(vector<int> arr,int n){
	int dp[n+1][n];
	for(int i=0;i<=n;i+=2){
		for(int j=0;j<n;j++){
			if(i==0)
			{
			dp[i][j]=0;
			continue;
		}
		if(i==2){
			dp[i][j]=Math.max(arr[i],arr[j]);
			continue;
		}
		
		dp[j]
		
		
			
		}
	}
}
int main(){
	vector<int> arr={ 5,3,7,10};
	vector<vector<int>> dp(arr.size(),vector<int>(arr.size(),-1));
	int i = 0;
	int j = 3;
	
	int ans = fun(arr,i,j);
	int ans2 = fun2(arr,i,j,dp);
	int ans3 = fun3(arr,i,j);
	cout<<ans<<" "<<ans2<<endl;
	cout<<ans3<<endl;
}

