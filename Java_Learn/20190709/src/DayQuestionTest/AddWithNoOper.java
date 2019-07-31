package DayQuestionTest;

/**
 * @Classname DayQuestionTest.AddWithNoOper
 * @Description TODO
 * @Date 2019/7/17 11:59
 * @Created by AppleTree
 */
public class AddWithNoOper {

    public static int add(int A, int B){
        int sum = 0;
        int c = 0;
        do {
            sum = A ^ B;
            c = (A & B) << 1;
            A = sum;
            B = c;
        }while (B != 0);
        return sum;
        //return (A ^ B) ^ (A & B)<<1;
    }

    public static void main(String[] args) {
        //System.out.println(add(15,15));// 1111,1111,   0000, 1111, 11110 =
        boolean b = true?false:(true==true?false:true);
        boolean c = false==false;
        System.out.println(b);
    }

}
