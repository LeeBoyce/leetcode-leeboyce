package LinkedList;

/**
 * @author jianw.li
 * @date 2019/9/29 6:09 PM
 * @Description: TODO
 */
public class Test {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head ==null){
            return head;
        }

        int oldK = k;
        ListNode resNode = head;
        while(resNode !=null){
            k--;
            resNode = resNode.next;
        }
        int len = oldK - k;
        int step = len - (oldK % len);
        if(step == 0){
            return head;
        }

        resNode = head;
        ListNode headNode = resNode;
        while(resNode.next != null){
            resNode = resNode.next;
        }
        //连接成环
        resNode.next = headNode;
        ListNode tempHeadNode = headNode;
        ListNode tempEndNode = resNode;
        while(step != 0){
            step--;
            tempEndNode = headNode;
            headNode = headNode.next;
        }
        tempEndNode.next = null;
        return headNode;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = null;
        ListNode curNode = listNode;

        ListNode resultList = rotateRight(curNode, 2);
        System.out.println(resultList);
    }
}
