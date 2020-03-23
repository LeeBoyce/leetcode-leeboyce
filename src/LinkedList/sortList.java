package LinkedList;

/**
 * @author jianw.li
 * @date 2019/10/1 6:07 PM
 * @Description: TODO
 */
public class sortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null){
            if(next.val < cur.val){
                ListNode twoNext = null;
                if(next.next != null){
                    twoNext = next.next;
                }
                pre.next = next;
                cur.next = twoNext;
                next.next = cur;
            }
            pre = cur;
            cur = next;
            next = next.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);
        listNode.next.next.next.next.next = null;
        ListNode curNode = listNode;

        ListNode resultList = sortList(curNode);
        System.out.println(resultList);
    }

}
