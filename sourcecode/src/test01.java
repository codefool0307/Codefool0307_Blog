import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int[] a = new int[13];
        int[] f = new int[n + 2];
        for (int i = 0; i <10; ++i)
        {a[i]=-1;}
        a[s.charAt(0)-'0']=0;
        for (int i = 1; i < n; ++i) {
            f[i]=f[i-1]+1;
            int u = s.charAt(i)- '0';
            if (a[u]!=-1){
                if (f[i]>f[a[u]]+1) f[i]=f[a[u]]+1;
            }
            else a[u]=i;
        }
        System.out.println(f[n-1]);
    }
}
