import java.util.ArrayList;

public class BooleanSourceExample {
    public static void main(String[] args) {
        Boolean aTrue = Boolean.TRUE;
        Boolean aBoolean = new Boolean(true);

        Boolean aBoolean1 = Boolean.valueOf(aBoolean);
        System.out.println(aBoolean1);

        String s = Boolean.toString(true);
        System.out.println(s);

        String s1="false";
        System.setProperty(s1, "false");
        boolean aBoolean2 = Boolean.getBoolean(s1);
        System.out.println(aBoolean2);

        int i=3;
        boolean neg=(i<0);
        System.out.println(neg);

    }
}