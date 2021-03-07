#include <bits/stdc++.h>
using namespace std;


int fact(int n){
	int ans = 1;
	while(n>0){
		ans*=n--;
	}
	return ans;
}
string solve(int n,int k){
	vector<int> v;
	for(int i=1;i<=n;i++)
	v.push_back(i);
	int times = n;
	string ans = "";
	while(times--){
	
	int factorial = fact(n);
	int partition = factorial/n;
	int index = k/partition;
	
	ans += std::to_string(v[index]);
	v.erase(v.begin()+index);
	n--;
	k = k%partition;
}
return ans;
}
int main(){
	int n,k;
	n = 4;
	k = 23;
	for(int i=0;i<24;i++){
	
	string ans = solve(n,i);
	cout<<ans<<endl;
}
	
}