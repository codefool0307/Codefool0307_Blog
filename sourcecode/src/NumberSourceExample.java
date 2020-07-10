

public class NumberSourceExample {
    public static void main(String[] args) {
        Integer integer = new Integer(9);
        String s = Integer.toString(-2, 1);
        System.out.println(s);
        //表示是字符串形式
        System.out.println(s+3);


        Integer integer1 = new Integer(67);
        String s1 = Integer.toHexString(integer1);
        String s2 = Integer.toBinaryString(integer1);
        System.out.println(s1);
        System.out.println(s2);


        String s3 = Integer.toString(78);
        System.out.println(s3);
    }


}
