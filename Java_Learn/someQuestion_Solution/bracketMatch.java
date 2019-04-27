class bracketMatch{
    /**
     * 括号匹配问题解决方案
     * e1 : "()]" ->不合法
     * e2 : "{[()]}" ->合法
     * e3 : ")(" ->不合法
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack[top ++ ] = s.charAt(i);
            }else {
                if(top == 0) {
                    System.out.println("right char is more");
                    return false;
                }
                char ch =  stack[top - 1];
                if(ch == '{' && s.charAt(i) == '}' || ch == '[' && s.charAt(i) == ']' || ch == '(' && s.charAt(i) == ')') {
                    top -= 1;
                }else{
                    System.out.println("match erros ocurrs");
                    return false;
                }
            }
        }

        if(top > 0) {
            System.out.println("left chars os more1");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValid("{[()]}")); //合法
    }
}