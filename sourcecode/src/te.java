public class te {
    #include <iostream>
#include <string.h>
    using namespace std;
    int n,m;
    string s;
    int a[500005];
    int opt[2000005];
    int check(char op) {
        if(op=='m') {
            for(int i=1; i<=n; i++) {
                if(a[i]==1)
                    return i;
            }
            for(int i=1; i<=n; i++) {
                if(a[i]==0)
                    return i;
            }
        }
        else
        {
            for(int i=1; i<=n; i++) {
                if(a[i]==0)
                    return i;
            }
            for(int i=1; i<=n; i++) {
                if(a[i]==1)
                    return i;
            }
        }
    }
    void solve() {
        for(int i=1; i<=m; i++) {
            if(s[i]=='M') {
                int top=check('m');
                opt[i]=top;
                a[top]++;
            } else {
                int top=check('f');
                opt[i]=top;
                a[top]++;
            }
        }
        for(int i=1; i<=m; i++) {
            cout<<opt[i]<<endl;
        }
    }
    int main() {
        int t,num;
        scanf("%d",&t);
        while(t--) {
            memset(a,0,sizeof(a));
            scanf("%d",&n);
            cin>>s;
            s="#"+s;
            for(int i=1; i<s.length(); i++) {
                int num=s[i]-'0';
                a[i]=num;
            }
            scanf("%d",&m);
            cin>>s;
            s="#"+s;
            solve();
        }
        return 0;
    }
}
