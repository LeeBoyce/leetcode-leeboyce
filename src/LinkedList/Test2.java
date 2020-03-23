package LinkedList;

/**
 * @author jianw.li
 * @date 2019/9/30 9:34 PM
 * @Description: TODO
 */
public class Test2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        //双指针解法
        ListNode beforeNode = new ListNode(0);
        ListNode afterNode = new ListNode(0);

        ListNode beforeResNode = beforeNode;
        ListNode afterResNode = afterNode;
        while(head != null){

            if(head.val < x){
                beforeNode.next = head;
                beforeNode = beforeNode.next;
            }else{
                afterNode.next = head;
                afterNode = afterNode.next;
            }
            head= head.next;
        }
        afterNode.next = null;

        beforeNode.next = afterResNode.next;

        return beforeResNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);

        ListNode resultList = partition(listNode,3);
        System.out.println(resultList);
    }
}
