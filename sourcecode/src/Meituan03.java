import java.util.*;
import java.lang.*;

public class Meituan03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 2];
        for (int i = 1; i <=n ; ++i) {
            a[i]=scanner.nextInt();
        }
        a[0]=a[n+1]=0;
        int[][][] f=new int[n+2][n+2][2];
        int inf=300000000;
        for (int i = n; i > 0 ; --i)
            for (int j = i; j <=n ; ++j){
                f[i][j][0]=f[i][j][1]=inf;
                for (int k = i; k <=j ; ++k) {
                    int ans = 0;
                    if (k > i) ans += f[i][k - 1][1];
                    if (k < i) ans += f[k + 1][j][0];
                    f[i][j][0] = Math.min(f[i][j][0], ans + a[k] * a[i - 1]);
                    f[i][j][1] = Math.min(f[i][j][1], ans + a[k] * a[j + 1]);
                }
                }
                System.out.println(f[1][n][0]);
            }
}
