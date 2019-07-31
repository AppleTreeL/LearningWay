package DayTest01;

/**
 * @Classname AddMethodLInkedList
 * @Description TODO
 * @Date 2019/7/26 22:30
 * @Created by AppleTree
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddMethodLInkedList {

    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode cur = a;
        StringBuilder A = new StringBuilder();
        StringBuilder B = new StringBuilder();
        StringBuilder res = new StringBuilder();
        while (cur != null){
            A.append(cur.val);
            if(cur.next != null){
                cur = cur.next;
            }else {
                break;
            }
        }
        cur = b;
        while (cur != null){
            B.append(cur.val);
            if(cur.next != null){
                cur = cur.next;
            }else {
                break;
            }
        }
        int i = 0;
        for (i = 0; i < A.length(); i++) {
            if(i >= B.length()){
                break;
            }
            int atmep = A.charAt(i) - 48;
            int btemp = B.charAt(i) - 48;
            int resTemp = atmep + btemp;
            res.append(resTemp);
        }

        for (int j = i; j < B.length(); j++) {
            res.append(B.charAt(j));
        }
        res.reverse();
        ListNode resList = null;
        ListNode curList = null;
        for (int j = 0; j < res.length(); j++) {
            if(resList == null) {
                resList = new ListNode((res.charAt(j) - 48));
                curList = resList;
            }else {
                curList.next = new ListNode((res.charAt(j) - 48));
                curList = curList.next;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode cura = a;
        cura.next = new ListNode(2);
        cura = cura.next;
        cura.next = new ListNode(3);
        ListNode b = new ListNode(3);
        ListNode curb = b;
        curb.next = new ListNode(2);
        curb = curb.next;
        curb.next = new ListNode(1);
        ListNode res = plusAB(a, b);
        ListNode cur = res;
        while (cur != null){
            System.out.print(cur.val);
            if(cur.next != null)
                cur = cur.next;
            else break;
        }
    }

}
