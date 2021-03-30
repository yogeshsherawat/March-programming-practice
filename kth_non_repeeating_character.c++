	#include <bits/stdc++.h>
	using namespace std;
	int main(){
		string s = "geeksforgeeks";
		int k = 3;
		int frq[26]={0};
		vector<char> v;
		for(int i=0;i<s.length();i++){
			frq[s[i]-97]++;
		}
		for(int i=0;i<s.length();i++){
			if(frq[s[i]-97]==1)
			v.push_back(s[i]);
		}
		if(v.size()<k)
		cout<<"not possible";
		else
		cout<<v[k-1]<<endl;
		
	}