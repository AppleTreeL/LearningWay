public class Work_2019_2_12 {
	
    public static String stringCompress(String str){//字符串简单压缩
        int pos = 0;
        int count = 0;
        char[] chs = str.toCharArray();
        //System.out.println(chs[chs.length - 1]);
        char temp;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i <= chs.length - 1; i = pos + 1){
            temp = chs[i];
            pos = i;
            count = 1;
            while(pos < chs.length-1 && chs[pos] == chs[pos+1]){
                count++;
                pos++;
            }
            if(count > 1){
                sb.append(temp);
                sb.append(count);
            }else{
                sb.append(temp);
            }
		count = 1;
        }
        return sb.toString();
    }

    public static int isNumeric(String str){//识别字母个数
        int count  = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i <= chs.length - 1; i++) {
            if(((chs[i] <= 'z') && (chs[i] >= 'a'))  ||  ((chs[i] <= 'Z') && (chs[i] >= 'A'))) {
                count += 1;
                //System.out.println("current: "+ i);
            }
        }
        return  count;
    }

    public static String reverseSentence(String str) {//保留单词句子翻转
        char[] chr = str.toCharArray();
        int pos = 0;
        StringBuffer temp = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chr.length; i++) {
            if(chr[i] != 32){
//                System.out.println("select: "+chr[i]);
                temp.append(chr[i]);
            }else {
//                System.out.println(i);
//                System.out.println(temp);
                sb.insert(0,temp.toString()+" ");
                temp.replace(0,temp.length(),"");
            }
        }
        sb.insert(0,temp.toString()+" ");
        return sb.toString();
    }

    public static String leftRotateString(String str,int n){//指定位置之前的字符串翻转
        StringBuffer change = new StringBuffer();
        change = new StringBuffer(str.substring(0, n));
        change.reverse();
        String re = change.toString() + str.substring(n,str.length());
        return  re;
    }

	/*
    public static void main(String[] args) {//test code
        /**
         * String and StringBuffer, their exchanging
         * @Author: AppleTree
         *
        String str = "hello";
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);
    }*/

    /*public static void someTestcode(String[] args) {
        String str = "192.168.1.1";
        String[] str1 = str.split("\\.");// * ^ . | \
        for (String s: str1) {
            System.out.println(s);
        }
        System.out.println(str1.length);
        String trim1 = "    abc cde    ";
        System.out.println(trim1);
        System.out.println(trim1.trim());*/
 //       String str = "abcdef";
//        System.out.println(Work_2019_2_12.leftRotateString(str, 2));
 //       System.out.println(str.substring(0,1));
//        String str = "i am biter";
//        System.out.println("source: "+ str);
//        System.out.println("after reverse: "+ Work_2019_2_12.reverseSentence(str));
//        System.out.println(Work_2019_2_12.isNumeric(str));
//        String str = "aabbcccde";
//        //System.out.println(str);
//        System.out.println(Work_2019_2_12.stringCompress(str));
    }
}
