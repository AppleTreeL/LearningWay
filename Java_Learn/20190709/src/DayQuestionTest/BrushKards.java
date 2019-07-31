package DayQuestionTest;

import java.util.Scanner;

/**
 * @Classname DayQuestionTest.BrushKards
 * @Description TODO
 * @Date 2019/7/19 11:26
 * @Created by AppleTree
 */
public class BrushKards {

    public static void brush(int[] array) {
        int[] a1 = new int[array.length / 2];
        int[] a2 = new int[array.length / 2];
        for (int i = 0; i < array.length / 2; i++) {
            a1[i] = array[i];
        }
        for (int i = array.length / 2; i < array.length; i++) {
            a2[i - array.length / 2] = array[i];
        }

        boolean judge = true;
        int countSum = 0;
        int countA = 0;
        int countB = 0;
        while (countSum < array.length){
            if(judge){
                array[countSum] = a1[countA];
                //if(countA < a1.length)
                    countA += 1;
                countSum += 1;
                judge = false;
            }else {
                array[countSum] = a2[countB];
                //if(countB < a2.length)
                    countB += 1;
                countSum += 1;
                judge = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder fin = new StringBuilder();
        String region = in.nextLine();
        String[] afterDeal = region.split(" ");//去掉空格
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < afterDeal.length; i++) {
            temp.append(afterDeal[i]);
        }
        String resource = temp.toString();//无空格的原始输入数据的串
        int arrayNum = resource.charAt(0) - 48;//读取一共有几组数据
        int count = 1;//记录遍历到原始数据串哪一个位置了
        for (int i = 0; i < arrayNum; i++) {
            if((resource.charAt(count) - 48) < 1)
                throw new IllegalArgumentException("参数越界" + (resource.charAt(count) - 48));
            int arraySize = 2*(resource.charAt(count) - 48);//每组数的长度
            count += 1;
            int changeTimes = resource.charAt(count) - 48;//洗牌的次数
            if(changeTimes > 100)
                throw new IllegalArgumentException("参数越界" + changeTimes);
            count += 1;
            int recordCount = count;//记录遍历到数据部分的位置，也就是需要进行洗牌的数据的开始位置
            int toInts = 0;
            int[] ints = new int[arraySize];
            for (int j = count; j < recordCount + arraySize; j++) {//进行每组数据的赋值，
                // PS：这里我按照每组数据分别处理，
                // PS：结果最后都追加到名为fin的StringBuilder里。
                ints[toInts] = resource.charAt(j) - 48;
                count += 1;
                toInts += 1;
            }
            for (int j = 0; j < changeTimes; j++) {
                brush(ints);
            }
            for (int j = 0; j < arraySize; j++) {//结果的追加
                fin.append(ints[j]);
                fin.append(" ");
            }
        }
        fin.deleteCharAt(fin.length() - 1);
        System.out.println(fin.toString());
        /*int arrayNum = in.nextInt();
        for (int i = 0; i < arrayNum; i++) {
            int arraySize = in.nextInt();
            int changeTimes = in.nextInt();
            int[] ints = new int[arraySize];
            for (int j = 0; j <arraySize; j++) {
                ints[j] = in.nextInt();
            }
            for (int j = 0; j < changeTimes; j++) {
                brush(ints);
            }
            for (int j = 0; j < arraySize; j++) {
                stringBuilder.append(ints[j]);
                if((j+1) < arraySize)
                    stringBuilder.append(" ");
            }
        }*/
    }
}
