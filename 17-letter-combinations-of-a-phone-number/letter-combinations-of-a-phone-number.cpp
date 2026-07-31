class Solution {
private:
    void f(int ind,string &s,string str,vector<string>&ans,
    vector<vector<char>>&mpp){
        int n = s.size();
        if(ind == n){
            ans.push_back(str);
            return;
        }
        for(int i=0;i<mpp[(s[ind]-'0')].size();i++){
            f(ind+1,s,str + mpp[(s[ind]-'0')][i],ans,mpp);
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        vector<vector<char>>mpp{
            {},{},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };
        vector<string>ans;
        f(0,digits,"",ans,mpp);
        return ans;
    }
};