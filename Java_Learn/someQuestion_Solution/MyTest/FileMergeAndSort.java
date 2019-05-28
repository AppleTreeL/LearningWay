package MyTest;

import java.io.*;

/**
 * @Classname FileMerge
 * @Description TODO
 * @Date 2019/5/25 17:13
 * @Created by AppleTree
 */
public class FileMergeAndSort {

    public static void fileMerge(String[] srcFile, String destFilePath){
        File[] srcFiles = new File[srcFile.length];
        for(int i = 0; i < srcFile.length; i ++) {
            srcFiles[i] = new File(srcFile[i]);
            if(!srcFiles[i].exists()){
                try {
                    throw new FileNotFoundException(srcFiles[i] + "源文件不存在");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        File destFile = new File(destFilePath);
        if(destFile.getParent().isEmpty()){
            destFile.mkdirs();
        }

        try {
            FileOutputStream fout = new FileOutputStream(destFile,true);

            for(int i = 0; i < srcFiles.length; i++){
                try(FileInputStream fin = new FileInputStream(srcFiles[i])) {
                    byte[] buff = new byte[1024];
                    int len = -1;
                    while ((len = fin.read(buff)) != -1){
                        fout.write(buff,0,len);
                    }
                    System.out.println(fout.getChannel()+"  "+fout.getFD());
                    fout.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分立合并的图像
     * @param mergeNum
     * @param srcFile
     * @param destFilesPath
     */
    public static void fileSort(int mergeNum, String srcFile, String[] destFilesPath){
        File src = new File(srcFile);
        File[] destFiles = new File[2];

        //Test
        destFiles[0] = new File(destFilesPath[0]);
        destFiles[1] = new File(destFilesPath[1]);

        try(FileInputStream fin = new FileInputStream(src);
            FileOutputStream fout1 = new FileOutputStream(destFiles[0]);
            FileOutputStream fout2 = new FileOutputStream(destFiles[1])
        ){

            byte[] buffRead = new byte[227388];
            int len = -1;
            while((len = fin.read(buffRead)) != -1){
                fout1.write(buffRead,0, len/2);
                fout2.write(buffRead, len/2, len/2);
            }
            fout1.flush();
            fout2.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        String[] srcFiles = {"D:"+ File.separator +"_TestCode" + File.separator + "destFile.txt",
//                "D:"+ File.separator +"_TestCode" + File.separator + "srcFile.txt"
//        };//"D:"+ File.separator +"_TestCode" + File.separator + "testOut.txt"

//        String[] srcFiles = {"D:"+ File.separator +"_TestCode" + File.separator + "sidai.jpg",
//                "D:"+ File.separator +"_TestCode" + File.separator + "jiaofu.png"
//        };

        String[] srcFiles = {
                "D:"+ File.separator +"_TestCode" + File.separator + "college.jpg",
                "D:"+ File.separator +"_TestCode" + File.separator + "cab.jpg"
        };

        String dest = "D:"+ File.separator +"_TestCode" + File.separator + "mergeJpg2.jpg";

        fileMerge(srcFiles, dest);



//        String[] srcFiles = {
//                "D:"+ File.separator +"_TestCode" + File.separator + "sort1.jpg",
//                "D:"+ File.separator +"_TestCode" + File.separator + "sort2.jpg"
//        };
//
//        String dest = "D:"+ File.separator +"_TestCode" + File.separator + "mergeJpg2.jpg";
//
//
//        fileSort(2,dest,srcFiles);

    }

}
