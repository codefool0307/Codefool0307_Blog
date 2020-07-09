

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

        //方法numberOfLeadingZeros测试
        int i1 = Integer.numberOfLeadingZeros(4325888);
        System.out.println(i1);

        //toUnsignedString0方法测试

        Integer.toUnsignedString0()
    }


}
