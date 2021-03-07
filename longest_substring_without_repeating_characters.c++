#include <bits/stdc++.h>
using namespace std;
int solve(string s){
	
	unordered_map<char,int> map;
	int ans = 0;
	int k = -1;
	int c = 0;
	for(int i=0;i<s.length();i++){
		if(map.find(s[i])!=map.end())
		{
		int tmp = map[s[i]];
		if(tmp>k)
			k=tmp;
		}
	
		ans = std::max(ans,i-k);	
		map[s[i]]=i;
	
		}
		
		
	// for last element
	if(s.length()-k-1>ans)
	ans = s.length()-k-1;
	return ans;
	
	
}
int main()
{	
	string s = 
"alouzxilkaxkufsu";
	cout<<solve(s)<<endl;
	
}