#include <bits/stdc++.h>
using namespace std;
int main(){
	string s1 = "thic tic titic tttiiic";
	string s2 = "tic";
	int frq[s1.length()+1][26]={0};
	int j=0;
	int c = 0;
	int end = -1;
	int start = -1;
	int min = INT_MAX;
	
	for(int i=0;i<s1.length();i++){
		
		if(s1[i]==s2[j])
		{
			j++;
		}
		if(j==s2.length()){
			int k = i;
			for(;k>=0;k--){
				if(s1[k]==s2[0])
				break;
			}
			cout<<k<<" "<<i<<endl;
			int curr = i-k+1;
			cout<<curr<<" "<<min<<endl;
			if(curr<min){
				min = curr;
				start = k;
				end = i;
			}
			
			j=0;
		}
		
		
	}
	
	
	for(int i=start;i<=end;i++)
	cout<<s1[i];
	
}