package DayTest01;

import java.util.Scanner;

/**
 * @Classname IPExchange
 * @Description TODO
 * @Date 2019/7/31 16:12
 * @Created by AppleTree
 */
public class IPExchange {

//    public static int toDecimalism(String binaryString){
//        int binary = Integer.parseInt(binaryString);
//        int decimal = 0;
//        int p = 0;
//        while (true){
//            if(binary == 0) break;
//            else {
//                int temp = binary % 10;
//                decimal += temp * Math.pow(2, p);
//                binary = binary / 10;
//                p++;
//            }
//        }
//        return decimal;
//    }

    /**
     * 十进制分段IP转成一个整数表示
     * @param binary String类型的十进制以点分割的字符串IP
     * @return 返回一个标准的十进制整数值
     */
    public static int getIntIP(String binary) {
        int intIP = 0;
        binary = binary.trim();
        //String binary = binaryHe.substring(0,binaryHe.length() -1);
        String[] data = binary.split("\\.");
        String[] b = new String[data.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.toBinaryString(Integer.valueOf(data[i]));
        }

        for (int i = 0; i < b.length; i++) {
            if(b[i].length() <8) {
                int count = b[i].length();
                StringBuilder temp = new StringBuilder(b[i]);
                temp.reverse();
                while (count < 8) {
                    temp.append("0");
                    count += 1;
                }
                temp.reverse();
                b[i] = temp.toString();
            }
        }

//        for (int i = 0; i < b.length; i++) {
//            System.out.println(data[i]);
//        }

        StringBuilder dealData = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            dealData.append(b[i]);
        }
        String finalRes = dealData.toString().trim();
        if(finalRes.equals("")){
            return -1;
        }
        return Integer.valueOf(finalRes, 2);
    }

    public static String getStringIP(int num){
        String binary = Integer.toBinaryString(num).trim();
        if(binary.length() < 32){
            int count = binary.length();
            StringBuilder temp = new StringBuilder(binary);
            temp.reverse();
            while (count < 32){
                temp.append("0");
                count += 1;
            }
            temp.reverse();
            binary = temp.toString();
        }
        String[] strings = new String[4];
        strings[0] = binary.substring(0, 8);
        strings[1] = binary.substring(8, 16);
        strings[2] = binary.substring(16, 24);
        strings[3] = binary.substring(24, 32);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            res.append(Integer.valueOf(strings[i], 2));
            if(i < strings.length - 1){
                res.append(".");
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //str.trim();
        int num = in.nextInt();
        System.out.println(getIntIP(str));
        System.out.println(getStringIP(num));
        //System.out.println(Integer.toBinaryString(3));
        //System.out.println(getIntIP("10.0.3.193"));
        //System.out.println(getStringIP(167969729));
    }

}
