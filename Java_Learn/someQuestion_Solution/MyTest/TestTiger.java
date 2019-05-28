package MyTest;

import java.io.*;

public class TestTiger{
    public static void main(String[] args) {

        File file = new File("D:" + File.separator + "_TestCode" + File.separator + "testOut.txt");
        if(!file.exists()){
            file.mkdirs();
        }
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            byte[] buf = new byte[1024];
            int len = -1;
            while((len = fileInputStream.read(buf)) != -1){
                System.out.println(new String(buf));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
//        try(FileOutputStream fileOutputStream = new FileOutputStream(file,true)){
//            //String str = "ABCDEFG";
//            fileOutputStream.write('\n');
//            String str2 = "I老虎U!！";
//            System.out.println(str2.getBytes().length);
//            fileOutputStream.write(str2.getBytes(),2,6);
//            fileOutputStream.flush();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}