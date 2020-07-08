

public class NumberSourceExample {
    public static void main(String[] args) {
        /*Integer integer = new Integer(1);
        String s = Integer.toString(-2, 1);
        System.out.println(s);*/
        int i=2;
        boolean ne=(i<0);
        if (!ne){
            i=-i;
        }
        System.out.println(i);
    }


}
