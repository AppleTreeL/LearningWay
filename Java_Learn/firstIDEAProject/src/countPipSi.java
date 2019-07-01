import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @Classname countPipSi
 * @Description TODO
 * @Date 2019/7/1 19:51
 * @Created by AppleTree
 */
public class countPipSi {

    public static int counter(int emptyBottone){
        if(emptyBottone < 1 || emptyBottone > 100)
            throw new IllegalArgumentException("参数越界");
        if(emptyBottone < 3 && emptyBottone >= 1) return 0;

        int counter = 0;
        int empty = emptyBottone;
        int get = 0;

        while (empty >= 3) {
            get = empty / 3;
            empty = get + (empty % 3);
            if(empty == 0) {
                break;
            }
            counter += get;
            if(empty == 2){
                empty += 1;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        try {
            InputStream in = new FileInputStream(file);
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextInt()){
                int num = scanner.nextInt();
                if(num == 0) break;
                System.out.println(counter(num));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(counter(81));
    }

}
