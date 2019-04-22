public class first_tset_analyze{
    public static int  function(int n) {
        int ret = 0;
        while(n != 0) {
            ret = ret + (n % 10) * (n % 10);
            n = n / 10;
        }
        return ret;
    }

    /**
     * judge a num 
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int ret = n;
        if(n < 0) return false;
        while(ret != 1){
            ret = function(ret);
            if(ret == 4)
                return false;
        }
        return true;
    }

    /**
     * return the char occured three times
     * @param str
     * @return
     */
    public static char countThreeChar(String str) {
        int[] hash = new int[256];
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char reg = ch[i];
            if((reg < 'z' && reg > 'a') || (reg > 'A' && reg <'Z')){
                hash[reg] += 1;
                if(hash[reg] == 3)
                    return reg;
            }

        }
        return '0';
    }

    public static int killGames(int n) {
        int[] arrays = new int[n];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = 1;
        }

        int counter = 0;
        int num = n;
        while(num != 1){
            for (int i = 0; i <n; i++) {
                if(arrays[i] == 1){
                    counter += 1;
                    if(counter == 3){
                        arrays[i] = 0;
                        num --;
                        counter = 0;
                    }
                }
                
            }
        }
        for (int i = 0; i < n; i++) {
            if(arrays[i] == 1)
                return i + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        //System.out.println(first_tset_analyze.isHappy(5));
        //System.out.println(first_tset_analyze.countThreeChar("aabbbc"));
        System.out.println(first_tset_analyze.killGames(4));
    }

}