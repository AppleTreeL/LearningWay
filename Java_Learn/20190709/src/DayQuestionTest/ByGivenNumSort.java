package DayQuestionTest;//package DayQuestionTest;

/**
 * @Classname ByGivenNumSort
 * @Description TODO
 * @Date 2019/7/24 10:12
 * @Created by AppleTree
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ByGivenNumSort {

    public static ListNode getNode(ListNode pHead, int x){
        ListNode cur = pHead;
        if(cur.val == x){
            return cur;
        }
        while (cur.next != null){
            if(cur.val == x){
                return cur;
            }
            cur = cur.next;
        }
        if(cur.val == x){
            return cur;
        }
        return null;
    }

    public static ListNode partitionSec(ListNode pHead, int x){
        StringBuilder data = new StringBuilder();
        ListNode cur = pHead;
        while(cur != null){
            data.append(cur.val);
            if(cur.next == null)
                break;
            cur = cur.next;
        }
        int[] dataInt = new int[data.length()];
        for (int i = 0; i < data.length(); i++) {
            dataInt[i] = data.charAt(i) - 48;
        }
        StringBuilder less = new StringBuilder();
        StringBuilder more = new StringBuilder();
        for (int i = 0; i < dataInt.length; i++) {
            if(dataInt[i] < x){
                less.append(dataInt[i]);
            }else{
                more.append(dataInt[i]);
            }
        }
        less.append(more);
        int[] res = new int[data.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = less.charAt(i) - 48;
        }
        ListNode head = new ListNode(res[0]);
        ListNode cur2 = head;
        for (int i = 1; i < res.length; i++) {
            cur2.next = new ListNode(res[i]);
            cur2 = cur2.next;
        }
        return head;
    }

    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode pHeadLess = null;
        ListNode pHeadLessCur = null;
        ListNode PHeadMore = null;
        ListNode pHeadMoreCur = null;
        ListNode cur = pHead;
        while (cur != null){
            if(cur.val < x){
                if(pHeadLess == null){
                    ListNode temp = new ListNode(cur.val);
                    pHeadLess = temp;
                    pHeadLessCur = pHeadLess;
                }else {
                    ListNode temp = new ListNode(cur.val);
                    pHeadLessCur.next = temp;
                    pHeadLessCur = pHeadLessCur.next;
                }
            }else {
                if(PHeadMore == null){
                    ListNode temp = new ListNode(cur.val);
                    PHeadMore = temp;
                    pHeadMoreCur = PHeadMore;
                }else {
                    ListNode temp = new ListNode(cur.val);
                    pHeadMoreCur.next = temp;
                    pHeadMoreCur = pHeadMoreCur.next;
                }
            }
            cur = cur.next;
        }
//        if(cur.val < x){
//            if(pHeadLess == null){
//                pHeadLess = cur;
//            }else {
//                pHeadLess.next = cur;
//            }
//        }else {
//            if(PHeadMore == null){
//                PHeadMore = cur;
//            }else {
//                PHeadMore.next = cur;
//            }
//        }
        ListNode curPre = pHeadLess;
        while (curPre != null){
            if(curPre.next == null){
                break;
            }
            curPre = curPre.next;
        }
        curPre.next = PHeadMore;
        return pHeadLess;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode it = pHead;
        it.next = new ListNode(2);
        it = it.next;
        it.next = new ListNode(3);
        it = it.next;
        it.next = new ListNode(4);
        it = it.next;
        it.next = new ListNode(2);
        it = it.next;
        ListNode newNode = partition(pHead,3);
        ListNode look  = newNode;
        while (look != null){
            System.out.println(look.val);
            look = look.next;
        }
//        while (look.next != null){
//            System.out.println(look.val);
//            look = look.next;
//        }
//        if(look == newNode) {
//            System.out.println("while end");
//            System.out.println(look.val);
//        }
    }

}
