#include <bits/stdc++.h>
using namespace std;
int main(){
	string s = "1111130";
	int n = s.length();
	int dp[1+n];
	for(int i=0;i<=n;i++)
	dp[i]=0;
	dp[n]=1;
	
	for(int i=n-1;i>=0;i--){
		if(i==n-1 && s[i]!='0')
		{
		dp[i]+=dp[i+1];
		continue;
	}
		if(s[i]=='0')
		continue;
		string tmp = "";
		tmp+=s[i];
		tmp+=s[i+1];
		if(tmp=="10" || tmp=="20")
		{
		dp[i]+=dp[i+2];
		//cout<<dp[i]<<endl;
		//cout<<"i got hit"<<endl;
	}
		else if(tmp<"27")
		dp[i]+=dp[i+1]+dp[i+2];
		else
		dp[i]=dp[i+1];
			
		
	}
	cout<<dp[0]<<endl;
}