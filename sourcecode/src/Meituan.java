import java.util.Arrays;
import java.util.Scanner;

public class Meituan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] a = new int[m + 2];
        for (int i = 1; i <=m ; ++i) {
            a[i]=scanner.nextInt();
        }
        Arrays.sort(a,1,m+1);
        int ans=0;
        for (int i = 1; i <=m ; i++) {
           ans+=Math.abs(i-a[i]);
        }
        System.out.println(ans);
    }
}
