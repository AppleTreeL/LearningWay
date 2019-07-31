package DayQuestionTest;

/**
 * @Classname DayQuestionTest.RichManAndNormal
 * @Description TODO
 * @Date 2019/7/20 21:07
 * @Created by AppleTree
 */
//Fiddler
public class RichManAndNormal {

    public static void main(String[] args) {
        int normal = 0;
        for (int i = 1; i <= 30; i++) {
            normal += Math.pow(2, i - 1);
        }
        System.out.println(10*30 + " ");
        System.out.println(normal);
    }

}
