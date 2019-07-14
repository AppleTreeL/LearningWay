import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class TestBinaryTree{

    //public TreeNode root;
    public Map<Integer, String> map = new TreeMap<>();
    class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public int i = 0;

    //根据字符串创建二叉树
    public  TreeNode createTestTree(String str) {
        TreeNode root = null;
        //TreeNode it = null;
        //1.如果对应字符不是井号，那么创建一个根节点
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i += 1;
            root.left = createTestTree(str);
            root.right = createTestTree(str);
        }else{//2.如果是井号，那么直接++
            i += 1;
        }
        return root;
    }

    public int size = 0;
    
    //获取叶子节点个数
    public int getSize(TreeNode root) {
        if(root.left == null){
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }

    public int getLeafSize(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    public static int getKLevelSize(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    public static TreeNode find(TreeNode root, char vale) {
        //1.找根，跟是否为空，root.vale = value
        if(root == null){
            return null;
        }
        if(root.val == vale){
            return root;
        }
        //2.找左树
        TreeNode l = find(root.left, vale);
        if(l != null){
            return l;
        }
        //3.找右树
        l = find(root.right, vale);
        if(l != null){
            return l;
        }
        return null;
    }


    public static int height(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    //前序遍历
    public static void binaryTreePrevOrder(TreeNode root) {
        if(root == null){
            return;
        }else{
            System.out.println(root.val);
            binaryTreePrevOrder(root.left);
            binaryTreePrevOrder(root.right);
        }
    }

    //中序遍历
    public static void binaryTreeInOrder(TreeNode root) {
        if(root.left == null){
            System.out.println(root.val);
            return;
        }else{
            binaryTreeInOrder(root.left);
            binaryTreeInOrder(root.right);
        }
    }

    //后序遍历
    public static void binaryTreePostOrder(TreeNode root) {
        if(root == null){
            return;
        }else{
            binaryTreePrevOrder(root.left);
            binaryTreePrevOrder(root.right);
            System.out.println(root.val);
        }
    }

    //非递归先序遍历
    public static void binaryTreePrevOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while(cur != null || !stack.empty()){
            while(cur != null){
                System.out.print(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
    }

    //非递归中序遍历
    public static void binaryTreeInOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.empty()) {
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(cur);
            cur = top.right;
        }
    }

    //非递归后序遍历
    public static void binaryTreePostOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.empty()) {
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right != null || pre == cur){
                System.out.print(cur.val);
                pre = cur;
                cur = null;
                stack.pop();
            }else{
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        
    }

}