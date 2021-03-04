class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> v = {1};
        unordered_set<int> set;
        set.insert(1);
	//int n = 15;
	int a=0,b=0,c=0;
	for(int i=1;i<=n;){
		int k1 = v[a]*2;
		int k2 = v[b]*3;
		int k3 = v[c]*5;
		//cout<<a<<" "<<b<<" "<<c<<endl;
        //cout<<k1<<" "<<k2<<" "<<k3<<endl;
		
        if(k1<=k2 && k1<=k3)
		{	//cout<<k1<<endl;
            if(set.find(k1)==set.end())
            {v.push_back(k1);
            i++;
            }
            set.insert(k1);
			a++;
		}
		else if(k2<k1 && k2<k3)
		{	
			//cout<<k2<<endl;
            if(set.find(k2)==set.end()){
                i++;
			v.push_back(k2);
        }
            set.insert(k2);
			b++;
		}
		else
		{	
			//cout<<k3<<endl;
            if(set.find(k3)==set.end()){
                i++;
			v.push_back(k3);
        }
            set.insert(k3);
			c++;
		}
	}
    for(int i=0;i<v.size();i++)
       cout<<v[i]<<" ";
    return v[n-1];
    }
};