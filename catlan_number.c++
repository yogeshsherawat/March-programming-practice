#include <bits/stdc++.h>
using namespace std;
int catlan(int n){
	if(n==0 || n==1)
	return 1;
	int ans = 0;
	for(int i=0;i<n;i++){
		ans+= catlan(i)*catlan(n-1-i);
	}
	return ans;
}
int catlanDP(int n){
	int dp[n+1]={0};
	dp[0]=1;
	dp[1]=1;
	for(int i=2;i<=n;i++){
		int sum =0;
		for(int j=0;j<i;j++){
			sum+=dp[j]*dp[i-1-j];
		}
		dp[i]=sum;
	}
	return dp[n];
}
int main()
{	int k = 10;
	//cout<<catlan(k)<<endl;
	cout<<catlanDP(k)<<endl;
	
}