package MyTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Classname FileCopy
 * @Description TODO
 * @Date 2019/5/25 17:01
 * @Created by AppleTree
 */
public class FileCopy {

    public static void copy(String srcFilePath,  String destFilePath){

        File srcFile = new File(srcFilePath);//"D:" + File.separator + "_TestCode" + File.separator + "srcFile.txt"
        File destFile = new File(destFilePath);//"D:" + File.separator + "_testCode" + File.separator + "destFile.txt"

        try(FileInputStream in = new FileInputStream(srcFile);
            FileOutputStream out = new FileOutputStream(destFile)
        ){
            byte[] buff = new byte[1024];
            int len = -1;
            while((len = in.read(buff)) != -1){
                out.write(buff,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String srcPath = "D:" + File.separator + "_TestCode" + File.separator + "srcFile.txt";
        String destPath = "D:" + File.separator + "_testCode" + File.separator + "destFile.txt";
        copy(srcPath,destPath);
    }

}
