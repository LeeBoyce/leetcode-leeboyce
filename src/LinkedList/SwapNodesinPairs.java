package LinkedList;

/**
 * @author jianw.li
 * @date 2019/9/25 11:21 PM
 * @Description: TODO
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesinPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = null;
        ListNode curNode = listNode;
        swapPairs(curNode);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode preNode = new ListNode(0);  //用于移动，标识头结点
        preNode.next = head;
        ListNode temp = preNode; //需要一个链表存储，pre后续会参与运算
        while(preNode.next != null && preNode.next.next !=null){
            ListNode startNode = preNode.next;
            ListNode endNode = preNode.next.next;
            preNode.next = endNode;
            startNode.next = endNode.next;
            endNode.next = startNode;
            preNode = startNode;
        }

        return temp.next;
    }

    // 1->2->3->4
    public static ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next); //返回null
        next.next = head; //4->3 next值为4，head为3
        return next;
    }



}
