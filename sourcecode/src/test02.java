import java.util.*;

public class test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int[] head = new int[n + 2];
        int[][] e = new int[m + 2][2];
        int[] d = new int[n+2];
        int[] nhead = new int[n + 2];
        int[][] ne = new int[m + 2][2];
        int[] nd = new int[n + 2];
        int[] que = new int[n + 2];
        for (int i = 1; i <=m ; ++i) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            e[i][0]=v;
            e[i][1]=head[u];
            head[u]=i;
            ne[i][0]=u;
            ne[i][1]=nhead[v];
            nhead[v]=i;
        }
        int h=0,t=0;
        que[1]=p;
        d[p]=1;
            while (h<t){
                int u = que[++h];
                for (int i = head[u]; i!=0; i=e[i][1]) {
                    int v=e[i][1];
                    if (d[v]==0){
                        que[++t]=v;
                        d[v]=1;
                    }
                }
            }
            int R=n-t+1;
            h=0;
            t=1;
            que[1]=p;
            nd[p]=1;
        while(h<t){
            int u=que[++h];
            for (int i = nhead[u]; i!=0; i=ne[i][1]) {
                int v = ne[i][1];
                if (nd[v]==0) {
                    que[++t]=v;
                    nd[v]=1;
                }
            }
        }
        int L=t;
        System.out.print(L);
        for (int i = L+1; i <=R ; i++) {
            System.out.printf(" %d",i);
        }
        System.out.println("");
    }
}
